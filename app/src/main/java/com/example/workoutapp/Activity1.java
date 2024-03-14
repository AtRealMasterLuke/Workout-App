package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        //define the UI Views
        TextView textViewActivity2 = findViewById(R.id.textViewActivity2);
        LottieAnimationView lottieActivity1 = findViewById(R.id.lottieActivity1);

        //Set the animation resource to be played by the LottieAnimationView
        lottieActivity1.setAnimation(R.raw.hamster);

        //Animate the TextView by changing its Y-axis position
        //negative values move the view upwards while positive move the view downwards
        textViewActivity2.animate().translationY(-1400).setDuration(2700).setStartDelay(0);
        //Animating the LottieAnimationView
        lottieActivity1.animate().translationX(2200).setDuration(3400).setStartDelay(3000);

        lottieActivity1.playAnimation();

        //Delay the execution of the specified intent for 6 secs after creation of this current activity
        //after the delay, the main activity starts
        new Handler().postDelayed(new Runnable() {
            @Override
            //This code creates an intent that explicitly starts MainActivity when created
            public void run() {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        }, 5000);
    }
}