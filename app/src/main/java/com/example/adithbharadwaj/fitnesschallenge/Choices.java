package com.example.adithbharadwaj.fitnesschallenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

            }
        });

      /**  TextView pb = (TextView) findViewById(R.id.pb);

        pb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent challenges = new Intent(Choices.this, PersonalBest.class);
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

            }
        });


    }


}
