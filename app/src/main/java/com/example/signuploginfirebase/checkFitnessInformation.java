package com.example.signuploginfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class checkFitnessInformation extends AppCompatActivity {

    Button startBtn;
    TextView workoutName, workoutTime, descriptionText;
    String cardio, abs, chest, back, legs, shoulders, tricep, bicep;
    CheckBox checkCardio, checkAbs, checkChest, checkBack, checkLegs, checkShoulders, checkTricep, checkBicep;
    FirebaseDatabase database;
    DatabaseReference databaseFitness;
    FitnessInformationGet fitnessInfo;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_fitness_information);

        startBtn = findViewById(R.id.startButton);
        workoutName = findViewById(R.id.editWorkout2);
        workoutTime = findViewById(R.id.editWorkoutTime2);
        descriptionText = findViewById(R.id.editDescription2);
        checkCardio = (CheckBox) findViewById(R.id.CardioCheckBox2);
        checkAbs = (CheckBox) findViewById(R.id.AbsCheckBox2);
        checkChest = (CheckBox) findViewById(R.id.ChestCheckBox2);
        checkBack = (CheckBox) findViewById(R.id.BackCheckBox2);
        checkLegs = (CheckBox) findViewById(R.id.LegsCheckBox2);
        checkShoulders = (CheckBox) findViewById(R.id.ShouldersCheckBox2);
        checkTricep = (CheckBox) findViewById(R.id.TricepCheckBox2);
        checkBicep = (CheckBox) findViewById(R.id.BicepCheckBox2);

        cardio = getIntent().getStringExtra("getCardio");
        abs = getIntent().getStringExtra("getAbs");
        chest = getIntent().getStringExtra("getChest");
        back = getIntent().getStringExtra("getBack");
        legs = getIntent().getStringExtra("getLegs");
        shoulders = getIntent().getStringExtra("getShoulders");
        tricep = getIntent().getStringExtra("getTricep");
        bicep = getIntent().getStringExtra("getBicep");

        workoutName.setText(getIntent().getStringExtra("editWorkoutName"));
        workoutTime.setText(getIntent().getStringExtra("editWorkoutTime"));
        descriptionText.setText(getIntent().getStringExtra("editWorkoutDesc"));

        if(cardio.equals("Cardio")){
            checkCardio.setChecked(true);
        }
        if(abs.equals("Abs")){
            checkAbs.setChecked(true);
        }
        if(chest.equals("Chest")){
            checkChest.setChecked(true);
        }
        if(back.equals("Back")){
            checkBack.setChecked(true);
        }
        if(legs.equals("Legs")){
            checkLegs.setChecked(true);
        }
        if(shoulders.equals("Shoulders")){
            checkShoulders.setChecked(true);
        }
        if(tricep.equals("Triceps")){
            checkTricep.setChecked(true);
        }
        if(bicep.equals("Biceps")){
            checkBicep.setChecked(true);
        }


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openNewActivity();
            }
        });
    }
    public void openNewActivity(){
        Intent intent = new Intent(this,stopWatchFitness.class);
        st=descriptionText.getText().toString();
        intent.putExtra("desc",st);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}