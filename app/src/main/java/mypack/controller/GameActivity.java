package mypack.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

import mypack.R;
import mypack.model.Question;
import mypack.model.QuestionBank;

public class GameActivity extends AppCompatActivity {
    private TextView mQuestionText;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;

    QuestionBank mQuestionBank = null;

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


        mQuestionText = (TextView) findViewById(R.id.activity_game_question_text);
        mAnswerButton1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mAnswerButton2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mAnswerButton3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mAnswerButton4 = (Button) findViewById(R.id.activity_game_answer4_btn);


        mQuestionBank = this.generateQuestions();

    }
}