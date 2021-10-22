package com.example.logswasthfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class
MainActivity extends AppCompatActivity {
    private Button login,reset;
    private EditText userEmail,userPassword;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button)findViewById(R.id.btnLogin);
        userEmail=(EditText) findViewById(R.id.etEmail);
        userPassword=(EditText)findViewById(R.id.etPassword);
        firebaseAuth=FirebaseAuth.getInstance();
        reset=(Button)findViewById(R.id.btnReset);
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null)
        {
            startActivity(new Intent(MainActivity.this,HomePage1.class));
        }
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ForgotActivity.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=userEmail.getText().toString();
                String s2=userPassword.getText().toString();

                if(s1.isEmpty() || s2.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter All The Details ", Toast.LENGTH_SHORT).show();
                }
                else{
                    validate(s1,s2);
                }
            }
        });
    }
    private void validate(String useremail, String userpassword)
    {
        firebaseAuth.signInWithEmailAndPassword(useremail,userpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Intent intent= new Intent(MainActivity.this,HomePage1.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Login Unsuccessfull !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}