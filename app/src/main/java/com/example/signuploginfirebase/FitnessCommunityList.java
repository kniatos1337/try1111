package com.example.signuploginfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FitnessCommunityList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    FitnessAdapterNew fitnessAdapterNew;
    ArrayList<FitnessInformationGet> list;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_list);

        button = (Button) findViewById(R.id.buttonUp);
        recyclerView = findViewById(R.id.userList);
        database = FirebaseDatabase.getInstance().getReference("Workouts");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        fitnessAdapterNew = new FitnessAdapterNew(this,list);
        recyclerView.setAdapter(fitnessAdapterNew);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    FitnessInformationGet fitnessInformationGet = dataSnapshot.getValue(FitnessInformationGet.class);
                    list.add(fitnessInformationGet);

                }
                fitnessAdapterNew.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void openNewActivity(){
        Intent intent = new Intent(this,FitnessCommunityListSecondPage.class);
        startActivity(intent);
    }
}