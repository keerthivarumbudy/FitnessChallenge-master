package com.example.adithbharadwaj.fitnesschallenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static com.example.adithbharadwaj.fitnesschallenge.R.id.pushup;

/**
 * Created by adith bharadwaj on 7/10/2017.
 */

public class challenges extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenges);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView pushup = (TextView) findViewById(R.id.pushup);

        pushup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent push = new Intent(challenges.this, pushupsActivity.class);
                startActivity(push);
            }

        });

        TextView pullup = (TextView) findViewById(R.id.pullups);

        pullup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent pull = new Intent(challenges.this, PullUpActivity.class);
                startActivity(pull);
            }

        });

        TextView plank = (TextView) findViewById(R.id.plank);

        plank.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent plan = new Intent(challenges.this, PlankActivity.class);
                startActivity(plan);
            }

        });

        TextView squats = (TextView) findViewById(R.id.squats);

        squats.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent squ = new Intent(challenges.this, SquatsActivity.class);
                startActivity(squ);
            }

        });

        TextView crunches = (TextView) findViewById(R.id.crunches);

        crunches.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent crunch = new Intent(challenges.this, CrunchesActivity.class);
                startActivity(crunch);
            }

        });

        TextView running = (TextView) findViewById(R.id.running);

        running.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent run = new Intent(challenges.this, RunningActivity.class);
                startActivity(run);
            }

        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
