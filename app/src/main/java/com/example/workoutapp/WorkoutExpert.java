package com.example.workoutapp;

import java.util.ArrayList;

public class WorkoutExpert {
    ArrayList<String> getWorkouts (String workout){
        ArrayList<String> exercise = new ArrayList<>();

        if(workout.equals("Chest")){
            exercise.add("Dumbbell bench presses");
            exercise.add("Dips");
            exercise.add("Incline presses");
        }
        else if(workout.equals("Biceps")){
            exercise.add("Dumbbell curls");
            exercise.add("Hammer curls");
            exercise.add("Cable curls");
        }
        else if(workout.equals("Triceps")){
            exercise.add("Dips");
            exercise.add("Overhead extensions");
            exercise.add("Skull crushers");
        }
        else if(workout.equals("Hips")){
            exercise.add("Squats");
            exercise.add("Lunges");
            exercise.add("Hip thrusts");
        }
        return exercise;
    }
}
