package com.example.javaminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class sad extends AppCompatActivity {

    private ImageView ytSad;
    private ImageView engSpotify;
    private ImageView hindiSpotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sad);

        ytSad = findViewById(R.id.ytSad);
        engSpotify = findViewById(R.id.engSpotify);
        hindiSpotify = findViewById(R.id.hindiSpotify);

        ytSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/watch?v=8Su5VtKeXU8&ab_channel=TheSchoolofLife"));
                startActivity(viewIntent);
            }
        });

        engSpotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent engspotify = new Intent("android.intent.action.VIEW", Uri.parse("https://open.spotify.com/playlist/0uQUuQSxkO3tylUSOKnyEB"));
                startActivity(engspotify);
            }
        });
        hindiSpotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hindiSpotify = new Intent("android.intent.action.VIEW", Uri.parse("https://open.spotify.com/playlist/1gd8rPLzo3bjk1yyQce0h7"));
                startActivity(hindiSpotify);
            }
        });

    }
}