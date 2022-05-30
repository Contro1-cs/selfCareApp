package com.example.javaminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //Declaring variables
    private ImageView profileBtn;
    private ImageView sadCard, fearfulCard, fedUpCard, anxiousCard, dullCard, angryCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Addressing variables
        profileBtn = findViewById(R.id.profileBtn);
        sadCard = findViewById(R.id.sadCard);
        fearfulCard = findViewById(R.id.fearfulCard);
        fedUpCard = findViewById(R.id.fedUpCard);
        anxiousCard = findViewById(R.id.anxiousCard);
        dullCard = findViewById(R.id.dullCard);
        angryCard = findViewById(R.id.angryCard);



        //OnClickListeners
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ProfilePage.class));
            }
        });

        //Redirecting to Sad page
        sadCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SadPage.class));
            }
        });

        //Redirecting to Fearful page
        fearfulCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FearfulPage.class));
            }
        });

        //Redirecting to Fed up page
        fedUpCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FedUpPage.class));
            }
        });


        //Redirecting to Anxious page
        anxiousCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AnxiousPage.class));
            }
        });

        //Redirecting to Dull page
        dullCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DullPage.class));
            }
        });

        //Redirecting to Angry page
        angryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AngryPage.class));
            }
        });
    }
}