package com.example.triviaapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.triviaapp.R;
import com.example.triviaapp.TriviaActivity;
import com.example.triviaapp.TriviaList;

import java.util.ArrayList;

/*
RecyclerAdapter "bind" values/data stored in memory to the visual components we see on screen.
In other words, it's the glue between JAVA and XML. More accurately, it's a translation layer.
As you can, this class extends from a class called CountryViewHolder (the class we create below)
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CountryViewHolder> {


    int selection = 0;
    String selectionNames;
    private Context context;
    //ArrayList of that holds all data fields
    private ArrayList<TriviaList> list;
    private ArrayList<String>selectionList = new ArrayList<>();
    //Constructor
    public RecyclerAdapter(ArrayList list, Context context) {
        this.list = list;
        this.context = context;

    }

    /*
    grabs the views from our card_design.xml layout file
    similar to onCreate() methods - initializes the views - connects the Java and XML sides together
     */
    public class CountryViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewCountryName, textViewDetails;
        private ImageView imageView;
        private CardView cardView;
        public  CountryViewHolder(@NonNull View itemView){
            super(itemView);

            textViewCountryName = itemView.findViewById(R.id.textViewCountryName);
            cardView = itemView.findViewById(R.id.cardView);


        }

    }

    @NonNull
    @Override
    //this where you inflate ("draw" the view on screen) the layout
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design, parent, false);
        return new CountryViewHolder((view));
    }

    @Override
    //assigning values/data to the views we created in the card_design.xml layout file
    //based on position (row)
    public void onBindViewHolder(@NonNull CountryViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textViewCountryName.setText(list.get(position).getQuestion());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    @Override
    //recycler view wants to know how many items(rows) will be displayed
    public int getItemCount() {
        return list.size();
    }


}

