package com.example.javaminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class FedUpPage extends AppCompatActivity {

    private ImageView fedSpotify, fedYT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fed_up_page);

        fedSpotify = findViewById(R.id.fedSpotify);
        fedYT = findViewById(R.id.fedYT);

        fedSpotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://open.spotify.com/playlist/3wh8Zn8WkE8jDCvzoIygoS?si=79dd8599e20a4a5c"));
                startActivity(intent);
            }
        });

        fedYT.setOnClickListener(new View.OnClickListener() {
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