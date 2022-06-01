package com.example.javaminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DullPage extends AppCompatActivity {

    private ImageView dullSpotify, dullYT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dull_page);

        dullSpotify = findViewById(R.id.dullSpotify);
        dullYT = findViewById(R.id.dullYT);

        dullSpotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://open.spotify.com/playlist/6uzU7rZGqLYEH3HEzgc2ai?si=651576b5be4d44e9"));
                startActivity(intent);
            }
        });

        dullYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.youtube.com/watch?v=V3EucbqWS64"));
                startActivity(intent);
            }
        });

    }
}