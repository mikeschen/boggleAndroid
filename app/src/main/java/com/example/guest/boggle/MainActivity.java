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
                randomLetters.clear();
                String location = mRandomTextView.getText().toString();
                for(int i=0; i < 8; i++) {
                    Random r = new Random();
                    char c = (char) (r.nextInt(26) + 'a');
                    String myLetter = "" + c;
                    randomLetters.add(myLetter);
                }
            Log.d(TAG, "" + randomLetters);
            }
        });
    }
}
