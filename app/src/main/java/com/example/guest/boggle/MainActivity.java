package com.example.guest.boggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.rollButton) Button mRollButton;
    public static final String TAG = MainActivity.class.getSimpleName();
    final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    final int N = alphabet.length();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRollButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Random r = new Random();
                char c = (char) (r.nextInt(26) + 'a');
                String myLetter = "" + c;
                Log.d(TAG, myLetter);
            }
        });
    }
}
