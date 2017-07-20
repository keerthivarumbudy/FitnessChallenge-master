package com.example.adithbharadwaj.fitnesschallenge;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.adithbharadwaj.fitnesschallenge.R.id.submit;

/**
 * Created by adith bharadwaj on 7/11/2017.
 */

public class PullUpActivity extends AppCompatActivity{

    private Button start;
    private TextView timer;

    private TextView btnvideo;

    public int count = 60;

    public String noOfPullUps;

    public  Button submit;

    public EditText mpullups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pullupactivity);

        start = (Button) findViewById(R.id.start);
        timer = (TextView)findViewById(R.id.timer);

        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                new CountDownTimer(62000, 1000){

                    public void onTick(long millis){

                        timer.setText(String.valueOf(count));
                        count--;

                        start.setClickable(false);


                        if(count == 0){
                            onFinish();
                        }
                    }

                    public void onFinish(){
                        start.setClickable(true);
                        count = 60;
                    }

                }.start();
            }
        });

        btnvideo = (TextView) findViewById(R.id.play);

        btnvideo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=bAEua0zu_74")));
                Log.i("Video", "Video Playing....");

            }
        });

        submit = (Button) findViewById(R.id.submitchallenges);
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mpullups = (EditText) findViewById(R.id.crunchestext);

                String ed_text = mpullups.getText().toString().trim();

                if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null)
                {
                    //EditText is empty

                    Context context = getApplicationContext();

                    Toast toast = Toast.makeText(context, "please enter the details", Toast.LENGTH_LONG);
                    toast.show();

                }

                else {
                    noOfPullUps = mpullups.getText().toString().trim();

                    Context context = getApplicationContext();

                    Toast toast = Toast.makeText(context, "Successfully submitted. checkout Results or Goals", Toast.LENGTH_LONG);
                    toast.show();


                    //Shared Preferences

                    SharedPreferences prefs = getSharedPreferences("results", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("PullUps", noOfPullUps);
                    editor.commit();
                }

            }
        });

    }

    // method to get no of pullups

}

