package com.example.adithbharadwaj.fitnesschallenge;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by adith bharadwaj on 7/11/2017.
 */

public class pushupsActivity extends AppCompatActivity{

    private Button start;
    private TextView timer;

    private TextView btnvideo;

    public int count = 60;

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

    }



}
