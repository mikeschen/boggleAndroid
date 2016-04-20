package com.example.guest.boggle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.rollButton)
    Button mRollButton;
    @Bind(R.id.randomTextView)
    TextView mRandomTextView;
    @Bind(R.id.submitWord)
    Button mSubmitWord;
    @Bind(R.id.editText)
    EditText mEditText;
    @Bind(R.id.wordListView)
    ListView mWordListView;
    public static final String TAG = MainActivity.class.getSimpleName();
    List<String> randomLetters = new ArrayList<String>();
    List<String> results = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRollButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int vowelCounter = 0;
                while (vowelCounter < 2) {
                    vowelCounter = 0;
                    randomLetters.clear();
                    for (int i = 0; i < 8; i++) {
                        Random r = new Random();
                        char c = (char) (r.nextInt(26) + 'a');
                        String myLetter = "" + c;
                        if ((myLetter.charAt(0) == 'a') || (myLetter.charAt(0) == 'e') || (myLetter.charAt(0) == 'i') || (myLetter.charAt(0) == 'o') || (myLetter.charAt(0) == 'u')) {
                            vowelCounter += 1;
                        }
                        randomLetters.add(myLetter);
                    }
                }
//            Log.d(TAG, "" + randomLetters);
//            Log.d(TAG, "int" + vowelCounter);
                String listRandomLetters = "";
                for (String s : randomLetters) {
                    listRandomLetters += s + "\t";
                }

                Intent intent = getIntent();
                String myRandomLetters = intent.getStringExtra("myRandomLetters");
                mRandomTextView.setText(listRandomLetters);
            }
        });

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, results);
        mWordListView.setAdapter(adapter);

        mSubmitWord.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                int trueCounter = 0;
                String listRandomLetters = "";
                for (String s : randomLetters) {
                    listRandomLetters += s + "";
                }
                List<String> wordList = new ArrayList<String>();
                wordList.add(listRandomLetters);
                String userWord = mEditText.getText().toString();
                if (userWord.length() < 3) {
                    Toast.makeText(MainActivity.this, "Words Must Be At Least 3 Letters", Toast.LENGTH_LONG).show();
                } else {
                    Log.d(TAG, userWord);
                    Log.d(TAG, "" + randomLetters);
                    trueCounter = 0;
                    for (int i = 0; i < userWord.length(); i++) {
                        for (int j = 0; j < 8; j++) {
                            char userz = userWord.charAt(i);
                            char randomz = listRandomLetters.charAt(j);
                            if (userz == randomz) {
                                trueCounter++;
                                Log.d(TAG, "userz " + trueCounter + "");
                            }
                        }
                    }
                    if (trueCounter == userWord.length()) {
                        Log.d(TAG, "winner winner!");
                        results.add(userWord);
                    } else {
                        Toast.makeText(MainActivity.this, "Try Again, wrong letters", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}
