package com.example.logswasthfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnalysisAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis2);

        Button Analysis =(Button)findViewById(R.id.btnanalysisgraph);
        
        Analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnalysisAct.this,Graphical.class);

                startActivity(intent);
            }
        });
    }
}