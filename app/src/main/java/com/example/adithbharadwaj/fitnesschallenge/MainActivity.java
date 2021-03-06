package com.example.adithbharadwaj.fitnesschallenge;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.id;
import static android.R.attr.label;
import static android.R.attr.onClick;
import static com.example.adithbharadwaj.fitnesschallenge.R.id.submit;

public class MainActivity extends AppCompatActivity {

    private EditText mname;
    private EditText mage;
    private EditText mheight;
    private EditText mweight;
    public String Gen;



    private TextView message;

    private double bmi;
    private double weight;
    private double height;

    private Button next;

    private String yourbmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mheight = (EditText) findViewById(R.id.height);
        mweight = (EditText) findViewById(R.id.weight);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        Gen = spinner.getSelectedItem().toString();
        SharedPreferences prefs = getSharedPreferences("results", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("gender", Gen);
        editor.commit();

        Button sumbit = (Button) findViewById(R.id.submit);

        sumbit.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                String ed_text = mheight.getText().toString().trim();
                String ed_text1 = mweight.getText().toString().trim();

                if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null || ed_text1.isEmpty() || ed_text1.length() == 0 || ed_text1.equals("") || ed_text1 == null )
                {
                    //EditText is empty
                    Context context = getApplicationContext();

                    Toast toast = Toast.makeText(context, "Please enter the details", Toast.LENGTH_LONG);
                    toast.show();

                }

                else
                {
                    //EditText is not empty

                    mheight = (EditText) findViewById(R.id.height);
                    mweight = (EditText) findViewById(R.id.weight);

                    height = Integer.parseInt(mheight.getText().toString());
                    weight = Integer.parseInt(mweight.getText().toString());
                }

                message = (TextView) findViewById(R.id.display);

                bmi = weight / (height / 100 * height / 100);


                yourbmi = "Your BMI is: " + bmi + "\n" + "A healthy BMI ranges from 19 to 25." + "\n";

                if (bmi < 19) {
                    message.setText(yourbmi + "You are underweight since your BMI is less than 19.");

                } else if (bmi > 25) {
                    message.setText(yourbmi + "You are overweight since your BMI is lgreater than 25.");

                } else if(bmi > 19 && bmi < 25){
                    message.setText(yourbmi + "You are healthy since your BMI is between 19 and 25.");
                }
                else{
                    message.setText("Please enter the details so that we can measure your BMI(body-mass index)");
                }

                next.setVisibility(View.VISIBLE);

            }


        });


        next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent challenges = new Intent(MainActivity.this, Choices.class);
                startActivity(challenges);

            }


        });


    }

}