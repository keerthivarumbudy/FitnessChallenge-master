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

/**
 * Created by adith bharadwaj on 7/11/2017.
 */

public class RunningActivity extends AppCompatActivity{

    private Button start;
    private  Button stop;

    private TextView timer;

    CountDownTimer mtimer;

    private TextView btnvideo;

    public int count = 0;

    public String runningTime;

    public  Button submit;

    public EditText mrunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.runningactivity);

        start = (Button) findViewById(R.id.start);
        timer = (TextView)findViewById(R.id.timer);

        stop = (Button) findViewById(R.id.stop);

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mtimer.cancel();
                start.setClickable(true);
            }
        });

        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mtimer = new CountDownTimer(200000, 1000) {

                    public void onTick(long millis) {

                        timer.setText(String.valueOf(count));
                        count++;

                        start.setClickable(false);

                    }

                    public void onFinish() {

                    }



                }.start();
            }

        });

        btnvideo = (TextView) findViewById(R.id.play);

        btnvideo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Gty7rFrsnBg")));
                Log.i("Video", "Video Playing....");

            }
        });

        submit = (Button) findViewById(R.id.submitchallenges);
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mrunning = (EditText) findViewById(R.id.crunchestext);

                String ed_text = mrunning.getText().toString().trim();

                if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null)
                {
                    //EditText is empty

                    Context context = getApplicationContext();

                    Toast toast = Toast.makeText(context, "please enter the details", Toast.LENGTH_LONG);

                }

                else {
                    runningTime = mrunning.getText().toString().trim();

                    Context context = getApplicationContext();

                    Toast toast = Toast.makeText(context, "Successfully submitted. checkout Results or Goals", Toast.LENGTH_LONG);
                    toast.show();


                    //Shared Preferences

                    SharedPreferences prefs = getSharedPreferences("results", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("Running", runningTime);
                    editor.commit();
                }

            }
        });

    }

    // method to get no of running time

}


