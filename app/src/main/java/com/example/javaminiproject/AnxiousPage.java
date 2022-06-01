package com.example.javaminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AnxiousPage extends AppCompatActivity {

    private ImageView anxSpotify, anxYT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anxious_page);

        anxSpotify = findViewById(R.id.anxiSpotify);
        anxYT = findViewById(R.id.anxiYT);

        anxSpotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anxSpotify.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://open.spotify.com/playlist/6SX1Npz4qdsQJe1xbvETET?si=6bea540bfdcd4028"));
                        startActivity(intent);
                    }
                });

                anxYT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.youtube.com/watch?v=WWloIAQpMcQ"));
                        startActivity(intent);
                    }
                });


            }
        });

    }
}