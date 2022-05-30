package com.example.javaminiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signInActivity extends AppCompatActivity {

    private EditText logInEmail, logInPass;
    private TextView logInBtn, rdSignUp;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        logInEmail = findViewById(R.id.logInEmail);
        logInPass = findViewById(R.id.logInPass);
        logInBtn = findViewById(R.id.logInBtn);
        rdSignUp = findViewById(R.id.rdSignUp);
        auth = FirebaseAuth.getInstance();

        rdSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signInActivity.this, signUpActivity.class));
            }
        });

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = logInEmail.getText().toString();
                String password = logInPass.getText().toString();

                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(signInActivity.this, "Something is empty", Toast.LENGTH_SHORT).show();
                } else {
                    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(signInActivity.this, MainActivity.class));
                                Toast.makeText(signInActivity.this, "Logged in successfully!", Toast.LENGTH_SHORT).show();
                                finish();
                            }else{
                                Toast.makeText(signInActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
        if(mUser!=null){
            startActivity(new Intent(signInActivity.this, MainActivity.class));
            finish();
        }
    }
}