package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Create an object of the WorkoutExpert class
     WorkoutExpert expert = new WorkoutExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin = findViewById(R.id.workoutSpinner);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "Selected Item: " + item,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayList<String> exerciseList = new ArrayList<>();
        exerciseList.add("Chest");
        exerciseList.add("Biceps");
        exerciseList.add("Triceps");
        exerciseList.add("Hips");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,exerciseList);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spin.setAdapter(arrayAdapter);

    }
       public void onClickingWorkout (View view){
           TextView work_out_type = findViewById(R.id.workouttype);
           Spinner spin = findViewById(R.id.workoutSpinner);

           // Get the selected item from the spinner
           String selectedItemFromSpinner = spin.getSelectedItem().toString();

           // Get the exercises for the selected item
           ArrayList<String> exercises = expert.getWorkouts(selectedItemFromSpinner);

           // Create a StringBuilder to append the exercises
           StringBuilder sb = new StringBuilder();

           // Loop through the exercises and append them to the StringBuilder
           for (String exercise : exercises) {
               sb.append(exercise + "\n ");
           }

           // Convert the StringBuilder to a String
           String exerciseString = sb.toString();
           // Set the text of the TextView to the exerciseString
           work_out_type.setText("You have selected " + selectedItemFromSpinner + " as your workout. Here are some exercises you can do: " + "\n"+ exerciseString);
       }
       public void wannaExit (View view){
           Intent i = new Intent(getApplicationContext(), LastActivity.class);
           startActivity(i);
            //Close all activities and exit app
           new Handler().postDelayed(new Runnable() {
               @Override
               public void run() {
                   finishAffinity();
               }
           },5000);
       }
}