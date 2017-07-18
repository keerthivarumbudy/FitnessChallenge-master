package com.example.adithbharadwaj.fitnesschallenge;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by adith bharadwaj on 7/11/2017.
 */

public class Goals  extends AppCompatActivity{


    private String pushUps;

    private String pullUps;

    private String crunches;

    private String running;

    private String plank;

    private String squats;

    public int mpush;

    public int mpull;

    public int mplank;

    public int mrun;

    public int msquat;

    public int mcrunch;

    private TextView pushResult;

    private TextView pullResult;

    private TextView CrunchResult;

    private TextView RunningResult;

    private TextView PlankResult;

    private TextView SquatResult;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goals);


        SharedPreferences prefs = getSharedPreferences("results",
                MODE_PRIVATE);


        //push-ups

        pullUps = prefs.getString("PullUps", "");

        //pull-ups

        pushUps = prefs.getString("PushUps",
                "");

        //crunches

        crunches = prefs.getString("Crunches", "");

        //squats

        squats = prefs.getString("Squats", "");

        //running

        running = prefs.getString("Running", "");

        //planks

        plank = prefs.getString("Planks", "");


        pushResult = (TextView) findViewById(R.id.PushUpGoals);

        pullResult = (TextView) findViewById(R.id.PullUpGoals);

        SquatResult = (TextView) findViewById(R.id.SquatsGoals);

        RunningResult = (TextView) findViewById(R.id.RunningGoals);

        CrunchResult = (TextView) findViewById(R.id.CrunchesGoals);

        PlankResult = (TextView) findViewById(R.id.PlankGoals);


        try{
            mpush = Integer.parseInt(pushUps);
        }catch(NumberFormatException ex){ // handle your exception
            pushResult.setText("Nothing to display yet");
        }

        try{
            mpull = Integer.parseInt(pullUps);
        }catch(NumberFormatException ex){ // handle your exception
            pullResult.setText("Nothing to display yet");
        }

        try{
            mcrunch = Integer.parseInt(crunches);
        }catch(NumberFormatException ex){ // handle your exception
            Log.e("", "");
        }

        try{
            mplank = Integer.parseInt(plank);
        }catch(NumberFormatException ex){ // handle your exception
            Log.e("", "");
        }

        try{
            mrun = Integer.parseInt(running);
        }catch(NumberFormatException ex){ // handle your exception
            Log.e("", "");
        }


        try{
            msquat = Integer.parseInt(squats);
        }catch(NumberFormatException ex){ // handle your exception
            Log.e("", "");
        }



    }
}
