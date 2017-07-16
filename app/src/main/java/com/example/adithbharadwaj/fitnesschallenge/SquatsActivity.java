package com.example.adithbharadwaj.fitnesschallenge;

import android.content.Context;
import android.content.Intent;
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

public class SquatsActivity extends AppCompatActivity{


    private Button start;
    private TextView timer;

    private TextView btnvideo;

    public int count = 60;

    public String noOfSquats;

    public  Button submit;

    public EditText msquats;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.squatsactivity);

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

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Gty7rFrsnBg")));
                Log.i("Video", "Video Playing....");

            }
        });

        submit = (Button) findViewById(R.id.submitchallenges);
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                msquats = (EditText) findViewById(R.id.crunchestext);

                String ed_text = msquats.getText().toString().trim();

                if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null)
                {
                    //EditText is empty
                    Context context = getApplicationContext();

                    Toast toast = Toast.makeText(context, "please enter the details", Toast.LENGTH_LONG);
                    toast.show();

                }

                else {
                    noOfSquats = msquats.getText().toString().trim();

                    Context context = getApplicationContext();

                    Toast toast = Toast.makeText(context, "your details have been successfully recorded", Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });

    }

    // method to get no of squats

    public String getNoOfSquats(){

        return noOfSquats;

    }
}
