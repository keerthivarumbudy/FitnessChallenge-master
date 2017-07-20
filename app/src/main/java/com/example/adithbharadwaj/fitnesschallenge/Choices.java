package com.example.adithbharadwaj.fitnesschallenge;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.AbstractCollection;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by adith bharadwaj on 7/11/2017.
 */

public class Choices extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.choices);


        TextView challenges = (TextView) findViewById(R.id.challenges);


        challenges.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent challenges = new Intent(Choices.this, challenges.class);
                startActivity(challenges);

            }
        });

        TextView goals = (TextView) findViewById(R.id.goals);

        goals.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent challenges = new Intent(Choices.this, Goals.class);
                startActivity(challenges);

                Context context = getApplicationContext();

                Toast toast = Toast.makeText(context, "Finish challenges first! ", Toast.LENGTH_LONG);
                toast.show();


            }
        });

      /**  TextView pb = (TextView) findViewById(R.id.pb);

        pb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent challenges = new Intent(Choices.this, personalbest.class);
                startActivity(challenges);
            }
        });
       */

        TextView result = (TextView) findViewById(R.id.results);


        result.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent challenges = new Intent(Choices.this, Result.class);
                startActivity(challenges);

                Context context = getApplicationContext();

                Toast toast = Toast.makeText(context, "Finish challenges first! ", Toast.LENGTH_LONG);
                toast.show();

            }
        });


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
