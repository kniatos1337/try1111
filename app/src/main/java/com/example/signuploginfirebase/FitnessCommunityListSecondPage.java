package com.example.signuploginfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FitnessCommunityListSecondPage extends AppCompatActivity {
    Button saveBtn;
    EditText workoutName, workoutTime, descriptionText;
    CheckBox checkCardio, checkAbs, checkChest, checkBack, checkLegs, checkShoulders, checkTricep, checkBicep;
    FirebaseDatabase database;
    DatabaseReference databaseFitness;
    FitnessInformationGet fitnessInfo;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_list_second_page);
        saveBtn = findViewById(R.id.saveButton);
        workoutName = findViewById(R.id.editWorkout);
        workoutTime = findViewById(R.id.editWorkoutTime);
        descriptionText = findViewById(R.id.editDescription);
        checkCardio = findViewById(R.id.CardioCheckBox);
        checkAbs = findViewById(R.id.AbsCheckBox);
        checkChest = findViewById(R.id.ChestCheckBox);
        checkBack = findViewById(R.id.BackCheckBox);
        checkLegs = findViewById(R.id.LegsCheckBox);
        checkShoulders = findViewById(R.id.ShouldersCheckBox);
        checkTricep = findViewById(R.id.TricepCheckBox);
        checkBicep = findViewById(R.id.BicepCheckBox);
        databaseFitness = database.getInstance().getReference().child("Workouts");
        fitnessInfo = new FitnessInformationGet();

        String cardio = "Cardio";
        String abs = "Abs";
        String chest = "Chest";
        String back = "Back";
        String legs = "Legs";
        String shoulders = "Shoulders";
        String tricep = "Triceps";
        String bicep = "Biceps";
        String nullVal = "Nothing";

        databaseFitness.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists())
                {
                    i = (int) snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fitnessInfo.setWorkoutName(workoutName.getText().toString());
                fitnessInfo.setWorkoutTime(workoutTime.getText().toString());
                fitnessInfo.setDescription(descriptionText.getText().toString());
                databaseFitness.child(String.valueOf(i+1)).setValue(fitnessInfo);

                if(checkCardio.isChecked()) {
                    fitnessInfo.setCardio(cardio);
                    databaseFitness.child(String.valueOf(i + 1)).setValue(fitnessInfo);
                }else {
                    fitnessInfo.setCardio(nullVal);
                    databaseFitness.child(String.valueOf(i+1)).setValue(fitnessInfo);
                }

                if(checkAbs.isChecked()){
                    fitnessInfo.setAbs(abs);
                    databaseFitness.child(String.valueOf(i+1)).setValue(fitnessInfo);
                }else {
                    fitnessInfo.setAbs(nullVal);
                    databaseFitness.child(String.valueOf(i+1)).setValue(fitnessInfo);
                }

                if(checkChest.isChecked()){
                    fitnessInfo.setChest(chest);
                    databaseFitness.child(String.valueOf(i+1)).setValue(fitnessInfo);
                }else {
                    fitnessInfo.setChest(nullVal);
                    databaseFitness.child(String.valueOf(i+1)).setValue(fitnessInfo);
                }

                if(checkBack.isChecked()){
                    fitnessInfo.setBack(back);
                    databaseFitness.child(String.valueOf(i+1)).setValue(fitnessInfo);
                }else {
                    fitnessInfo.setBack(nullVal);
                    databaseFitness.child(String.valueOf(i+1)).setValue(fitnessInfo);
                }

                if(checkLegs.isChecked()){
                    fitnessInfo.setLegs(legs);
                    databaseFitness.child(String.valueOf(i+1)).setValue(fitnessInfo);
                }else {
                    fitnessInfo.setLegs(nullVal);
                    databaseFitness.child(String.valueOf(i+1)).setValue(fitnessInfo);
                }

                if(checkShoulders.isChecked()){
                    fitnessInfo.setShoulders(shoulders);
                    databaseFitness.child(String.valueOf(i+1)).setValue(fitnessInfo);
                }else {
                    fitnessInfo.setShoulders(nullVal);
                    databaseFitness.child(String.valueOf(i+1)).setValue(fitnessInfo);
                }

                if(checkTricep.isChecked()){
                    fitnessInfo.setTricep(tricep);
                    databaseFitness.child(String.valueOf(i+1)).setValue(fitnessInfo);
                }else {
                    fitnessInfo.setTricep(nullVal);
                    databaseFitness.child(String.valueOf(i+1)).setValue(fitnessInfo);
                }

                if(checkBicep.isChecked()) {
                    fitnessInfo.setBicep(bicep);
                    databaseFitness.child(String.valueOf(i+1)).setValue(fitnessInfo);
                }else {
                    fitnessInfo.setBicep(nullVal);
                    databaseFitness.child(String.valueOf(i+1)).setValue(fitnessInfo);
                }


                openNewActivity();
            }
        });


    }
    public void openNewActivity(){
        Intent intent = new Intent(this,FitnessCommunityList.class);
        startActivity(intent);
    }
}