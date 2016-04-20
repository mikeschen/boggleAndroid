package com.example.guest.boggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.rollButton) Button mRollButton;
    @Bind(R.id.randomTextView) TextView mRandomTextView;
    public static final String TAG = MainActivity.class.getSimpleName();
    List<String> randomLetters = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRollButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int vowelCounter = 0;
                randomLetters.clear();
                String location = mRandomTextView.getText().toString();
                for(int i=0; i < 8; i++) {
                    Random r = new Random();
                    char c = (char) (r.nextInt(26) + 'a');
                    String myLetter = "" + c;
                    randomLetters.add(myLetter);
                    if ((myLetter.charAt(0) == 'a') || (myLetter.charAt(0) == 'e')  || (myLetter.charAt(0) == 'i') || (myLetter.charAt(0) == 'o') || (myLetter.charAt(0) == 'u')) {
                        vowelCounter += 1;
                    }
                }
            Log.d(TAG, "" + randomLetters);
            Log.d(TAG, "int" + vowelCounter);
            }
        });
    }
}
