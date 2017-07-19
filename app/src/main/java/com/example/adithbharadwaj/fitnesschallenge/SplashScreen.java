package com.example.adithbharadwaj.fitnesschallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adithbharadwaj.fitnesschallenge.MainActivity;
import com.example.adithbharadwaj.fitnesschallenge.R;

public class SplashScreen extends AppCompatActivity {

    private TextView splash;
    private ImageView iv;
    private TextView challenge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        splash = (TextView)findViewById(R.id.splash);
        iv = (ImageView)findViewById(R.id.iv);
        challenge = (TextView) findViewById(R.id.challenge);



        Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.challenge);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.mytransition);

        iv.startAnimation(anim);
        splash.startAnimation(anim);
        challenge.startAnimation(anim2);

        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(8000);
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}