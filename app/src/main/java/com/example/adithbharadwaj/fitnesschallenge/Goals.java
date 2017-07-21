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


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

        //push-ups

        if(pushUps.toString().trim() == null || pushUps.toString().trim().equals("") || pushUps.toString().trim().isEmpty()){
            pushResult.setText("nothing to display yet");
        }
        else{
            ((TextView) findViewById(R.id.PushUpGoals)).setTextSize(30);

            pushResult.setText("you did " + mpush + " Push-Ups" + "\n" + " your goal is to do " +
                    (mpush + 5) + " Push-Ups");
        }

        //pull-ups


        if(pullUps.toString().trim() == null || pullUps.toString().trim().equals("") || pullUps.toString().trim().isEmpty()){
            pullResult.setText("nothing to display yet");
        }
        else{
            ((TextView) findViewById(R.id.PullUpGoals)).setTextSize(30);
            pullResult.setText("you did " + mpull + " Pull-Ups" + "\n" + " your goal is to do " +
                    (mpull + 2) + " Pull-Ups");
        }

        //crunches


        if(crunches.toString().trim() == null || crunches.toString().trim().equals("") || crunches.toString().trim().isEmpty()){
            CrunchResult.setText("nothing to display yet");
        }
        else{
            ((TextView) findViewById(R.id.CrunchesGoals)).setTextSize(30);
            CrunchResult.setText("you did " + mcrunch + " Crunches " + "\n" + "your goal is to do " +
                    (mcrunch + 5) + " crunches");

        }

        //planks

        if(plank.toString().trim() == null || plank.toString().trim().equals("") || plank.toString().trim().isEmpty()){
            PlankResult.setText("nothing to display yet");
        }
        else{
            ((TextView) findViewById(R.id.PlankGoals)).setTextSize(30);
            PlankResult.setText("you did Plank for " + mplank + " seconds " + "\n" + "your goal is to do planks for " +
                    (mplank + 30) + " seconds");
        }

        //running

        if(running.toString().trim() == null || running.toString().trim().equals("") || running.toString().trim().isEmpty()){
            RunningResult.setText("nothing to display yet");
        }
        else{
            ((TextView) findViewById(R.id.RunningGoals)).setTextSize(30);
            RunningResult.setText("you ran 1k in " + mrun + " seconds " + "\n" + "your goal is to run 1k in " + (mrun - 20)
                    + " seconds");

        }

        //squats

        if(squats.toString().trim() == null || squats.toString().trim().equals("") || squats.toString().trim().isEmpty()){
            SquatResult.setText("nothing to display yet");
        }
        else{
            ((TextView) findViewById(R.id.SquatsGoals)).setTextSize(30);

            SquatResult.setText("you did " + msquat + " Squats " + "\n" + "your goal is to do " + (msquat + 5) + " Squats");

        }


    }
}
