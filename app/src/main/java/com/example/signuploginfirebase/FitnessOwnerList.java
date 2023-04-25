package com.example.signuploginfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FitnessOwnerList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    FitnessAdapterNew fitnessAdapterNew;
    ArrayList<FitnessInformationGet> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_owner_list);
        recyclerView = findViewById(R.id.ownerList);
        database = FirebaseDatabase.getInstance().getReference("OurWorkouts");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        fitnessAdapterNew = new FitnessAdapterNew(this,list);
        recyclerView.setAdapter(fitnessAdapterNew);

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
}