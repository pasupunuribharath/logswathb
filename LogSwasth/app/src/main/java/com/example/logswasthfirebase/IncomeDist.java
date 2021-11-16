package com.example.logswasthfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;

import static android.graphics.Color.MAGENTA;
import static android.graphics.Color.RED;

public class IncomeDist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_dist);

        FirebaseDatabase rootNode;
        DatabaseReference reference;
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("villagers");

        GraphView graph=(GraphView)findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series= new LineGraphSeries<>();
        DataPoint[] dp = new DataPoint[4];



        ArrayList<String> Incomelist = new ArrayList<String>();

        int [] arr= new int[4];

        for(int i =0; i<10; i++)
        {
            arr[i]=0;
        }

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot mydataSnapshot : dataSnapshot.getChildren()){
                    VillagerHelperClass villagersdetails = mydataSnapshot.getValue(VillagerHelperClass.class);
                    Incomelist.add(villagersdetails.getIncome());


                }

                for(String i : Incomelist)
                {
                    if(i.equals("Below 10000"))
                    {
                        arr[0]++;
                    }
                    if(i.equals("10000-50000"))
                    {
                        arr[1]++;
                    }
                    if(i.equals("50000-150000"))
                    {
                        arr[2]++;
                    }
                    if(i.equals("Above 150000"))
                    {
                        arr[3]++;
                    }

                }









                    dp[0]= new DataPoint(10000,arr[0]);
                dp[1]= new DataPoint(50000,arr[1]);
                dp[2]= new DataPoint(150000,arr[2]);
                dp[3]= new DataPoint(155000,arr[3]);


                series.resetData(dp);
                graph.addSeries(series);


            }



            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });


    }
}