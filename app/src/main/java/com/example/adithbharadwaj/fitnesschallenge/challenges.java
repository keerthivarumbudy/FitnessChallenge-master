package com.example.adithbharadwaj.fitnesschallenge;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
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

        pushup.setOnTouchListener(new CustomTouchListener());

        pushup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent push = new Intent(challenges.this, pushupsActivity.class);
                startActivity(push);
            }

        });

        TextView pullup = (TextView) findViewById(R.id.pullups);

        pullup.setOnTouchListener(new CustomTouchListener());

        pullup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent pull = new Intent(challenges.this, PullUpActivity.class);
                startActivity(pull);
            }

        });

        TextView plank = (TextView) findViewById(R.id.plank);

        plank.setOnTouchListener(new CustomTouchListener());

        plank.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent plan = new Intent(challenges.this, PlankActivity.class);
                startActivity(plan);
            }

        });

        TextView squats = (TextView) findViewById(R.id.squats);

        squats.setOnTouchListener(new CustomTouchListener());

        squats.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent squ = new Intent(challenges.this, SquatsActivity.class);
                startActivity(squ);
            }

        });

        TextView crunches = (TextView) findViewById(R.id.crunches);

        crunches.setOnTouchListener(new CustomTouchListener());

        crunches.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent crunch = new Intent(challenges.this, CrunchesActivity.class);
                startActivity(crunch);
            }

        });

        TextView running = (TextView) findViewById(R.id.running);

        running.setOnTouchListener(new CustomTouchListener());

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

    public class CustomTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    ((TextView) view).setTextColor(0xFFFFFFFF); // white
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    ((TextView) view).setTextColor(Color.parseColor("#4a4a4a")); // lightblack
                    break;
            }
            return false;
        }
    }


}
