/*
Author: Adam Jackrel
Date: Fall/Spring 2023-24

This app is designed to reinforce the advanced Android concepts. SharedPreference, Intents and App
Lifecycle are heavily used in this app. Of course, the RecyclerView is again
the main attraction of the app.

This app also utilizes JSON files to function. The app is designed to allow pretty much any
custom data set to be used. Simply modify the code to fit the needs of the data and it shouldn't be
too much trouble.

Feel free to modify the contents of this program and make improvements as you wish!
 */

package com.example.triviaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity{

    SharedPreferences sharedPreferences;
    private RecyclerView recyclerView;
    private com.example.triviaapp.RecyclerAdapter recyclerAdapter;
    //stores all of the JSON data
    private ArrayList<TriviaList> triviaList = new ArrayList<>();
    //displays the number of correct answers
    private TextView correct;
    //displays the players cash
    private TextView cash;
    //new game button - sets cash and correct to 0
    private Button new_game;

    //stores the total accumulated money the player has earned
    int total = 0;
    //stores the total accumulated answer count for the player
    int correctAnswers = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        correct = findViewById(R.id.textView3);
        cash = findViewById(R.id.textView4);
        new_game = findViewById(R.id.button3);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        recyclerAdapter = new com.example.triviaapp.RecyclerAdapter(triviaList, MainActivity.this);
        recyclerView.setAdapter(recyclerAdapter);

        //load the JSON from the Asset file location
        String temp = loadJSONFromAsset();

        //must be inside of a try-catch block
        //create the ArrayList
        try {
            JSONArray obj = new JSONArray(temp);
            setUpTriviaArrays(obj);
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }


        //event listener for the NEW GAME button - clears players progress
        new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    /*
        This method takes the String parsed by the loadJSONFromAsset() method and converts
        it to an Java arraylist.
     */
    private void setUpTriviaArrays(JSONArray obj) throws JSONException {


    }

    /*
   This method converts the JSON file to a JSONArray format that will be used in setUpTriviaArrays()
    */
    public String loadJSONFromAsset() {
        System.out.println("inside of loadJSONFromAsset");
        String json = null;
        try {
            System.out.println("start json parsing");
            InputStream is = getAssets().open("million.json");
            System.out.println("end json parsing");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


}