package com.example.javaminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import io.grpc.ManagedChannelProvider;

public class SadPage extends AppCompatActivity {

    private ImageView sadSpotify, sadYT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sad_page);

        sadSpotify = findViewById(R.id.sadSpotify);
        sadYT = findViewById(R.id.sadYT);

        sadSpotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://open.spotify.com/playlist/3wh8Zn8WkE8jDCvzoIygoS?si=79dd8599e20a4a5c"));
                startActivity(intent);
            }
        });

        sadYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.youtube.com/watch?v=BL9WblAEK_A"));
                startActivity(intent);
            }
        });
    }
}