package com.example.logswasthfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomePage1 extends AppCompatActivity {
    private Button registerVillager,editVillager;
    private FirebaseAuth firebaseAuth;
    private Button Analysis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page1);

        registerVillager=(Button)findViewById(R.id.btRegisterVillager);
        editVillager=(Button)findViewById(R.id.btEditVillager);
        Analysis=(Button)findViewById(R.id.analysis);
        firebaseAuth=FirebaseAuth.getInstance();


        registerVillager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomePage1.this,RegisterVillager2.class);
                startActivity(intent);
            }
        });
        editVillager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomePage1.this,EditVillagerDetails.class);
                startActivity(intent);
            }
        });
        Analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomePage1.this,AnalysisActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logoutMenu:{
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent (HomePage1.this,MainActivity.class));
            }
        }
        return super.onOptionsItemSelected(item);
    }
}