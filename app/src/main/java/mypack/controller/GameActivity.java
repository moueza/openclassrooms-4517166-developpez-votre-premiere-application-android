package mypack.controller;

import android.content.DialogInterface;
import android.content.Intent;

import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import mypack.R;
import mypack.model.Question;
import mypack.model.QuestionBank;

/**
 * p2c5 2:14 nouv questionp2c5 3:15 tjs v7 pr retrocompatibilitep2c5 3:30 Builder
 * p2c5 3:15 tjs v7 pr retrocompatibilitep2c5 3:30 Builder
 * p2c5 3:15 tjs v7 pr retrocompatibilitep2c5 3:30 Builder
 * p2c5 3:15 tjs v7 pr retrocompatibilitep2c5 3:30 Builder
 */
/**p2c5 3:15 tjs v7 pr retrocompatibilite*/
/**p2c5 3:30 Builder*/

/**p2c5 4:40 finish remonte ds Activity prec*/


public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";

    private TextView mQuestionText;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;
    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;
    private int mScore;
    private int mNumberOfQuestions;

    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";

    public QuestionBank getQuestionBank() {
        return mQuestionBank;
    }

    public void setQuestionBank(QuestionBank questionBank) {
        mQuestionBank = questionBank;
    }


    public TextView getQuestionText() {
        return mQuestionText;
    }

    public void setQuestionText(TextView questionText) {
        mQuestionText = questionText;
    }

    public Button getAnswerButton1() {
        return mAnswerButton1;
    }

    public void setAnswerButton1(Button answerButton1) {
        mAnswerButton1 = answerButton1;
    }

    public Button getAnswerButton2() {
        return mAnswerButton2;
    }

    public void setAnswerButton2(Button answerButton2) {
        mAnswerButton2 = answerButton2;
    }

    public Button getAnswerButton3() {
        return mAnswerButton3;
    }

    public void setAnswerButton3(Button answerButton3) {
        mAnswerButton3 = answerButton3;
    }

    public Button getAnswerButton4() {
        return mAnswerButton4;
    }

    public void setAnswerButton4(Button answerButton4) {
        mAnswerButton4 = answerButton4;
    }

    public QuestionBank generateQuestions() {
        Question question1 = new Question("Who is the creator of Android?",
					  Arrays.asList("Andy Rubin",
							"Steve Wozniak",
							"Jake Wharton",
							"Paul Smith"),
					  0);

        Question question2 = new Question("When did the first man land on the moon?",
					  Arrays.asList("1958",
							"1962",
							"1967",
							"1969"),
					  3);

        Question question3 = new Question("What is the house number of The Simpsons?",
					  Arrays.asList("42",
							"101",
							"666",
							"742"),
					  3);

        return new QuestionBank(Arrays.asList(question1,
					      question2,
					      question3));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        mQuestionBank = this.generateQuestions();

        mScore = 0;
        mNumberOfQuestions = 4;

	//wire widgets
        mQuestionText = (TextView) findViewById(R.id.activity_game_question_text);
        mAnswerButton1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mAnswerButton2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mAnswerButton3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mAnswerButton4 = (Button) findViewById(R.id.activity_game_answer4_btn);


        //Use the same listener for the four buttons.
        //The tag value will be used to distinguish the button triggered
        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);
        mAnswerButton4.setOnClickListener(this);


        // Use the tag property to 'name' the buttons
        mAnswerButton1.setTag(0);
        mAnswerButton2.setTag(1);
        mAnswerButton3.setTag(2);
        mAnswerButton4.setTag(3);

        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);
        mAnswerButton4.setOnClickListener(this);

        /*3:06->6:12**/
        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);
        //this.setQuestionMoi(this.generateQuestions().getQuestion());
        // this.displayQuestion(this.generateQuestions().getQuestion());
    }

    /**5:01*/
    private void displayQuestion(final Question question) {
        // Set the text for the question text view and the four buttons
        this.mQuestionText.setText(question.getQuestion());

        this.mAnswerButton1.setText(question.getChoiceList().get(0));
        this.mAnswerButton2.setText(question.getChoiceList().get(1));
        this.mAnswerButton3.setText(question.getChoiceList().get(2));
        this.mAnswerButton4.setText(question.getChoiceList().get(3));

    }

    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();
        if (responseIndex == mCurrentQuestion.getAnswerIndex()) {
            //Good answer
            Toast.makeText(this, "Correct !", Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            //bad answer
            Toast.makeText(this, "False !", Toast.LENGTH_SHORT).show();

        }


        if (--mNumberOfQuestions == 0) {
            // No question left, end the game
            endGame();
        } else {
            mCurrentQuestion = mQuestionBank.getQuestion();
            displayQuestion(mCurrentQuestion);
        }
    }

    private void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Well done!")
	    .setMessage("Your score is " + mScore)
	    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //https://developer.android.com/reference/android/app/Activity.html#finish() ancre
                        Intent intent = new Intent();
                        intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                })
	    .create()
	    .show();
    }

}
