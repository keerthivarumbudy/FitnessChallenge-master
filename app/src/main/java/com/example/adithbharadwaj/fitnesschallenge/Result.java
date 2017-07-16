package com.example.adithbharadwaj.fitnesschallenge;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.id;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.adithbharadwaj.fitnesschallenge.R.string.pushups;

/**
 * Created by adith bharadwaj on 7/11/2017.
 */

public class Result extends AppCompatActivity{

    private String pushUps;

    private String pullUps;

    private String crunches;

    private String running;

    private String plank;

    private String squats;

    private TextView pushResult;

    private TextView pullResult;

    private TextView CrunchResult;

    private TextView RunningResult;

    private TextView PlankResult;

    private TextView SquatResult;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);


        SharedPreferences prefs = getSharedPreferences("results",
                MODE_PRIVATE);


         pushUps = prefs.getString("PushUps",
                "");

        pullUps = prefs.getString("PullUps", "");

        crunches = prefs.getString("Crunches", "");

        squats = prefs.getString("Squats", "");

        running = prefs.getString("Running", "");

        plank = prefs.getString("Planks", "");

        // reference variables

        pushResult = (TextView) findViewById(R.id.pushUpResult);

        pullResult = (TextView) findViewById(R.id.pullUpResult);

        SquatResult = (TextView) findViewById(R.id.squatsResult);

        RunningResult = (TextView) findViewById(R.id.RunningResult);

        CrunchResult = (TextView) findViewById(R.id.crunchesResult);

        PlankResult = (TextView) findViewById(R.id.plankResult);


      /**  if(     pushUps.isEmpty() || pushUps.length() == 0 || pushUps.equals("") || pushUps == null ||

                crunches.isEmpty() || crunches .length() == 0 || crunches .equals("") || crunches  == null ||

                pullUps.isEmpty() || pullUps.length() == 0 || pullUps.equals("") || pullUps == null ||

                squats.isEmpty() || squats.length() == 0 || squats.equals("") || squats == null ||

                running.isEmpty() || running.length() == 0 || running.equals("") || running == null ||

                plank.isEmpty() || plank.length() == 0 || plank.equals("") || plank == null ){

            Context context = getApplicationContext();

            Toast toast = Toast.makeText(context, "please go to challenges and complete them for your results", Toast.LENGTH_LONG);
            toast.show();

        }
       */



      //push ups

            int mpush = Integer.parseInt(pushUps);

            if(mpush <= 4){
                pushResult.setText("you did " + pushUps + " pushups. you are very poor. click on goals to improve.");
            }

            if(mpush <= 18 && mpush >= 10){
                pushResult.setText("you did " + pushUps + " pushups. you are below average. click on goals to improve.");
            }

            if(mpush <= 34 && mpush >= 19){
                pushResult.setText("you did " + pushUps + " pushups. you are good. click on goals to improve.");
            }

            if(mpush >= 35){
                pushResult.setText("you did " + pushUps + " pushups. you are excellent. click on goals to improve. but you don't need to, do you? ");
            }


            //pull ups

        int mpull = Integer.parseInt(pullUps);

        if(mpull <= 1){
            pullResult.setText("You did " + pullUps + " Pull-ups. you are very poor. click on goals to improve.");
        }

        if(mpull <= 6 && mpull >= 2){
            pullResult.setText("You did " + pullUps + " Pull-ups. you are average. click on goals to improve.");
        }

        if(mpush <= 15 && mpull >= 7){
            pullResult.setText("You did " + pullUps + " Pull-ups. you are good. click on goals to improve.");
        }

        if(mpull >= 16){
            pullResult.setText("You did " + pullUps + " Pull-ups. you are excellent. click on goals to improve. but you don't need to, do you? ");
        }

        //Crunches

        int mcrunch = Integer.parseInt(crunches);

        if(mcrunch <= 18){
            CrunchResult.setText("You did " + crunches + " crunches. you are very poor. click on goals to improve.");
        }

        if(mcrunch <= 19 && mcrunch >= 38){
            CrunchResult.setText("You did " + crunches + " crunches. you are average. click on goals to improve.");
        }

        if(mcrunch <= 39 && mcrunch >= 49){
            CrunchResult.setText("You did " + crunches + " crunches. you are good. click on goals to improve.");
        }

        if(mcrunch >= 50){
            CrunchResult.setText("You did " + crunches + " crunches. you are excellent. click on goals to improve. but you don't need to, do you? ");
        }


        //Planks

        int mplank = Integer.parseInt(plank);

        if(mplank <= 30){
            PlankResult.setText("You did plank for " + plank + " seconds. you are very poor. click on goals to improve.");
        }

        if(mplank <= 60 && mplank >= 31){
            PlankResult.setText("You did plank for " + plank + " seconds. you are average. click on goals to improve.");
        }

        if(mplank <= 180 && mplank >= 60){
            PlankResult.setText("You did plank for " + plank + " seconds. you are good. click on goals to improve.");
        }

        if(mplank >= 181){
            PlankResult.setText("You did plank for " + plank + " seconds. you are excellent. click on goals to improve. but you don't need to, do you? ");
        }

        //Running


        int mrun = Integer.parseInt(running);

        if(mrun >= 300){
            RunningResult.setText("You ran for " + running + " seconds. you are very poor. click on goals to improve.");
        }

        if(mrun <= 301  && mrun >= 240 ){
            RunningResult.setText("You ran for " + running + " seconds. you are average. click on goals to improve.");
        }

        if(mrun <= 241 && mrun >= 150){
            RunningResult.setText("You ran for " + running + " seconds. you are good. click on goals to improve.");
        }

        if(mrun <= 149){
            RunningResult.setText("You ran for " + running + " seconds. you are excellent. click on goals to improve. but you don't need to, do you? ");
        }

        //Squats


        int msquat = Integer.parseInt(squats);

        if(msquat <= 20){
            SquatResult.setText("You did " + squats + " squats. you are very poor. but you can easily improve. click on goals to improve.");
        }

        if(msquat <= 21  && msquat >= 29 ){
            SquatResult.setText("You did " + squats + " squats. you are average. click on goals to improve.");
        }

        if(msquat <= 30 && msquat >= 34){
            SquatResult.setText("You did " + squats + " squats. you are good. click on goals to improve.");
        }

        if(msquat >= 35){
            SquatResult.setText("You did " + squats + " squats. you are excellent. click on goals to improve. but you don't need to, do you? ");
        }


    }
}
