package com.example.adithbharadwaj.fitnesschallenge;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.mode;

/**
 * Created by adith bharadwaj on 7/11/2017.
 */

public class pushupsActivity extends AppCompatActivity{

    private Button start;

    private TextView timer;

    private TextView btnvideo;

    public int count = 60;

    public String noOfPushUps;

    public  Button submit;

    public EditText mpushups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pushupsactivity);

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

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=5eSM88TFzAs")));
                Log.i("Video", "Video Playing....");

            }
        });

        submit = (Button) findViewById(R.id.submitchallenges);
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mpushups = (EditText) findViewById(R.id.crunchestext);

                String ed_text = mpushups.getText().toString().trim();

                if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null)
                {
                    //EditText is empty
                    Context context = getApplicationContext();

                    Toast toast = Toast.makeText(context, "please enter the details", Toast.LENGTH_LONG);
                    toast.show();


                }

                else {
                    noOfPushUps = mpushups.getText().toString().trim();

                    Log.i("no of pushups", noOfPushUps);

                    Context context = getApplicationContext();

                    Toast toast = Toast.makeText(context, "your details have been successfully recorded", Toast.LENGTH_LONG);
                    toast.show();


                    // Shared preferences:


                    SharedPreferences prefs = getSharedPreferences("results", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("PushUps", noOfPushUps);
                    editor.commit();


                }

            }
        });

    }

}
