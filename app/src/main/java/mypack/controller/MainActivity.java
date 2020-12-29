package mypack.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mypack.R;
import mypack.model.User;

public class MainActivity extends AppCompatActivity {
    public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";
    public static final String PREF_KEY_FIRSTNAME = "PREF_KEY_FIRSTNAME";
    private static final int GAME_ACTIVITY_REQUEST_CODE = 42;
    private static final String TAG = "MainActivity";
    private TextView mGreetingText;

    private EditText mNameInput;
    private Button mPlayButton;
    private User mUser;
    private SharedPreferences mPreferences;

    private TextView mscoreTextMoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Log.e("fromm", "lbl10");
        super.onCreate(savedInstanceState);
        Log.e("fromm", "log de Peter MOUEZA");
        setContentView(R.layout.activity_main);

        //Correction : affiche ou ?
        System.out.println("MainActivity::onCreate()");

        mUser = new User();
        mPreferences = getPreferences(MODE_PRIVATE);

        mGreetingText = (TextView) findViewById(R.id.activity_main_greeting_txt);
        mNameInput = (EditText) findViewById(R.id.activity_main_name_input);
        mPlayButton = (Button) findViewById(R.id.activity_main_play_btn);
        this.mscoreTextMoi = (TextView) findViewById(R.id.score_txt);

        mPlayButton.setEnabled(false);

        greetUser();

        /**p1c5 Gérez les actions de l'utilisateur*/
        /**code source*/
        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This is where we'll check the user input
                mPlayButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = mNameInput.getText().toString();
                mUser.setFirstName(firstname);

                mPreferences.edit().putString(PREF_KEY_FIRSTNAME, mUser.getFirstName()).apply();

                Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                //startActivity(gameActivityIntent);
                startActivityForResult(gameActivityIntent, GAME_ACTIVITY_REQUEST_CODE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            // Fetch the score from the Intent
            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);
            Log.e(TAG, "erreur=" + score);
            // scoreText.setText(score); cause crash -> trial in greetUser()
            mscoreTextMoi.setText(""+score);


            mPreferences.edit().putInt(PREF_KEY_SCORE, score).apply();

            greetUser();

        } else {
            Log.e(TAG, "NULL1");
        }
    }


    /**
     * à 2 endroits : au create ET qd recupere score
     */
    private void greetUser() {
        String firstname = mPreferences.getString(PREF_KEY_FIRSTNAME, null);

        if (null != firstname) {
            int score = mPreferences.getInt(PREF_KEY_SCORE, 0);

            String fulltext = "Welcome back, " + firstname
                    + "!\nYour last score was " + score
                    + ", will you do better this time?";
            mGreetingText.setText(fulltext);
            mNameInput.setText(firstname);
            mNameInput.setSelection(firstname.length());
            mPlayButton.setEnabled(true);

            //mscoreTextMoi.setText(""+score);
         }
    }
}
