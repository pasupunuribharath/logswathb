package com.example.logswasthfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditVillagerDetails extends AppCompatActivity {
    private Button btProceed;
    private EditText etAadhar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_villager_details);

        btProceed=(Button)findViewById(R.id.btnEditProceed);
        etAadhar=(EditText)findViewById(R.id.eteditEnterAadhar);

        btProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aadhar=etAadhar.getText().toString();

            }
        });
    }
}