package com.example.adithbharadwaj.fitnesschallenge;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.id;
import static android.R.attr.track;
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

    public int mpush;

    public int mpull;

    public int mplank;

    public int mrun;

    public int msquat;

    public int mcrunch;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

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


        // reference variables

        pushResult = (TextView) findViewById(R.id.pushUpResult);

        pullResult = (TextView) findViewById(R.id.pullUpResult);

        SquatResult = (TextView) findViewById(R.id.squatsResult);

        RunningResult = (TextView) findViewById(R.id.RunningResult);

        CrunchResult = (TextView) findViewById(R.id.crunchesResult);

        PlankResult = (TextView) findViewById(R.id.plankResult);


      //push up


        try{
            mpush = Integer.parseInt(pushUps);
        }catch(NumberFormatException ex){ // handle your exception
            pushResult.setText("Nothing to display yet");
        }


        if(pushUps == null){
            pushResult.setText("nothing to display yet");
        }

        if(mpush <= 4){
                pushResult.setText("you did " + mpush + " pushups. you are very poor. click on goals to improve.");
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

        try{
             mpull = Integer.parseInt(pullUps);
        }catch(NumberFormatException ex){ // handle your exception
            pullResult.setText("Nothing to display yet");
        }



        if(pushUps.toString().trim() == null || pushUps.toString().trim().equals("") || pushUps.toString().trim().isEmpty()){
            pushResult.setText("nothing to display yet");
        }


        if(pullUps == null){
            pullResult.setText("nothing to display yet");
        }

        if(mpull <= 1){
            pullResult.setText("You did " + pullUps + " Pull-ups. you are very poor. click on goals to improve.");
        }

        if(mpull <= 6 && mpull >= 2){
            pullResult.setText("You did " + pullUps + " Pull-ups. you are average. click on goals to improve.");
        }

        if(mpull <= 15 && mpull >= 7){
            pullResult.setText("You did " + pullUps + " Pull-ups. you are good. click on goals to improve.");
        }

        if(mpull >= 16){
            pullResult.setText("You did " + pullUps + " Pull-ups. you are excellent. click on goals to improve. but you don't need to, do you? ");
        }



        //Crunches

        try{
            mcrunch = Integer.parseInt(crunches);
        }catch(NumberFormatException ex){ // handle your exception
            Log.e("", "");
        }

        if(pullUps.toString().trim() == null || pullUps.toString().trim().equals("") || pullUps.toString().trim().isEmpty()){
            pullResult.setText("nothing to display yet");
        }


        if(mcrunch == -1){
            CrunchResult.setText("Nothing to display yet");
        }

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

        try{
            mplank = Integer.parseInt(plank);
        }catch(NumberFormatException ex){ // handle your exception
            Log.e("", "");
        }

        if(crunches.toString().trim() == null || crunches.toString().trim().equals("") || crunches.toString().trim().isEmpty()){
           CrunchResult.setText("nothing to display yet");
        }


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

        try{
            mrun = Integer.parseInt(running);
        }catch(NumberFormatException ex){ // handle your exception
            Log.e("", "");
        }

        if(plank.toString().trim() == null || plank.toString().trim().equals("") || plank.toString().trim().isEmpty()){
            PlankResult.setText("nothing to display yet");
        }


        if(mrun >= 300){
            RunningResult.setText("You ran for " + running + " seconds. you are very poor. click on goals to improve.");
        }

        if(mrun <= 301  && mrun >= 240 ){
            RunningResult.setText("You ran for " + running + " seconds. you are average. click on goals to improve.");
        }

        if(mrun <= 241 && mrun >= 161){
            RunningResult.setText("You ran for " + running + " seconds. you are good. click on goals to improve.");
        }

        if(mrun <= 160){
            RunningResult.setText("You ran for " + running + " seconds. you are excellent. click on goals to improve. but you don't need to, do you? ");
        }


        //Squats

        try{
            msquat = Integer.parseInt(squats);
        }catch(NumberFormatException ex){ // handle your exception
            Log.e("", "");
        }

        if(running.toString().trim() == null || running.toString().trim().equals("") || running.toString().trim().isEmpty()){
            RunningResult.setText("nothing to display yet");
        }


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

        else if(msquat == -1){
            SquatResult.setText("Nothing to display yet");
        }


        if(squats.toString().trim() == null || squats.toString().trim().equals("") || squats.toString().trim().isEmpty()){
            SquatResult.setText("nothing to display yet");
        }

    }

 /**   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mmenu = getMenuInflater();
        mmenu.inflate(R.menu.menu_activity, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.settings:

                SharedPreferences preferences = getSharedPreferences("results", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
        }

        return super.onOptionsItemSelected(item);
    }
*/
}
