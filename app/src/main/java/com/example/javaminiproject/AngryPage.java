package com.example.javaminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AngryPage extends AppCompatActivity {

    private ImageView angrySpotify, angryYT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angry_page);

        angrySpotify = findViewById(R.id.angrySpotify);
        angryYT = findViewById(R.id.angryYT);

        angrySpotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://open.spotify.com/playlist/1HfmEbuAMYsHnnRWAx7B2X?si=032f79b53579465f"));
                startActivity(intent);
            }
        });

        angryYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.youtube.com/watch?v=Pfbnc-u8Ta4"));
                startActivity(intent);
            }
        });

    }
}