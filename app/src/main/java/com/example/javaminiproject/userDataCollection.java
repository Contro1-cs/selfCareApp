package com.example.javaminiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class userDataCollection extends AppCompatActivity {

    //Declaring variables
    private Button goBtn;
    private EditText sName, sCountry, sPhNo;

    //Firebase declarations
    private FirebaseAuth auth;
    private StorageReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data_collection);

        //Finding IDs of variables
        goBtn = findViewById(R.id.goBtn);
//        sName =  findViewById(R.id.name);
        sCountry = findViewById(R.id.country);
//        sPhNo = findViewById(R.id.phNumber);

        //Firebase declaration
        auth = FirebaseAuth.getInstance();
        reference = FirebaseStorage.getInstance().getReference().child(auth.getUid()+ "'s info");

        //Uploading data
        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = sName.getText().toString();
                String phNo = sPhNo.getText().toString();
                String country = sCountry.getText().toString();

                if(name.isEmpty() || phNo.isEmpty() || country.isEmpty()){
                    Toast.makeText(userDataCollection.this, "Something is empty", Toast.LENGTH_SHORT).show();
                } else {
                    reference.child("Name").putBytes((name.getBytes()));
                    reference.child("Country").putBytes((country.getBytes()));
                    reference.child("phone number").putBytes((phNo.getBytes())).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if(task.isSuccessful()) {
                                startActivity(new Intent(userDataCollection.this, MainActivity.class));
                                Toast.makeText(userDataCollection.this, "Thank you!", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                    });
                }
            }
        });
    }
}