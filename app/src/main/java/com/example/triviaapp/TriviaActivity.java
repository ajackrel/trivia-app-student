package com.example.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TriviaActivity extends AppCompatActivity {

    //question
    TextView questionView;
    //Choice A
    Button answer_A;
    //Choice B
    Button answer_B;
    //Choice C
    Button answer_C;
    //Choice D
    Button answer_D;
    //Back button
    Button buttonBack;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        //initialize the views


        //retrieve and store the intented data from MainActivity.java


        //set the text views



        //create a new intent path from here to Main
        Intent intent = new Intent(TriviaActivity.this, MainActivity.class);

        //event listener for Choice A


        //event listener for Choice B



        //event listener for Choice C


        //event listener for Choice D


        //event listener for back button

    }
}