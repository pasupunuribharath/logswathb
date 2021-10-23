package com.example.logswasthfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Graphical extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphical);


        Button Agedis = (Button)findViewById(R.id.btnage);
        Button Diseasedis = (Button)findViewById(R.id.btndisease);
        Button Educationdis = (Button)findViewById(R.id.btneducation);
        Button Incomedis = (Button)findViewById(R.id.btnincome);
        Button Castedis = (Button)findViewById(R.id.btncaste);
        Agedis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Graphical.this,AgeDist.class);
                startActivity(intent);
            }

        });
        Castedis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Graphical.this,Caste.class);
                startActivity(intent);
            }

        });
        Incomedis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Graphical.this,Incomeact.class);
                startActivity(intent);
            }
        });

        Diseasedis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Graphical.this,DiseaseDist.class);
                startActivity(intent);
            }
        });

        Educationdis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Graphical.this,Educationdist.class);
                startActivity(intent);
            }
        });


    }
}