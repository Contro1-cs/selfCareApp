package com.example.javaminiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SignalStrengthUpdateRequest;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

public class signUpActivity extends AppCompatActivity {

    private TextView signUpBtn, rdLogin;
    private EditText signUpEmail, signUpPass;

    //Firebase utilities
    private FirebaseAuth mAuth;
    StorageReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Firebase declarations
        mAuth = FirebaseAuth.getInstance();
        reference = FirebaseStorage.getInstance().getReference().child(mAuth.getUid() + "'s info");

        //Finding IDs of variables
        signUpBtn = findViewById(R.id.signUpBtn);
        signUpEmail = findViewById(R.id.signUpEmail);
        signUpPass = findViewById(R.id.signUpPass);
//        name = findViewById(R.id.name);
//        phNumber = findViewById(R.id.phNumber);
        rdLogin = findViewById(R.id.rdLogIn);

        rdLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signUpActivity.this, signInActivity.class));
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sEmail = signUpEmail.getText().toString();
                String sPass = signUpPass.getText().toString();
//                String personName = name.getText().toString();
//                String phoneNumber = phNumber.getText().toString();

                if(sEmail.isEmpty() || sPass.isEmpty()){
                    Toast.makeText(signUpActivity.this, "Something is empty", Toast.LENGTH_SHORT).show();
                }else{

//                    reference.child("Email").putBytes((sEmail.getBytes()));
//                    reference.child("name").putBytes((personName.getBytes()));
//                    reference.child("phone number").putBytes(phoneNumber.getBytes());

                    //Creating user profile
                    mAuth.createUserWithEmailAndPassword(sEmail, sPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(signUpActivity.this, userDataCollection.class));
                                Toast.makeText(signUpActivity.this, "Sign Up successfully!", Toast.LENGTH_SHORT).show();
                                finish();
                            }else{
                                Toast.makeText(signUpActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}