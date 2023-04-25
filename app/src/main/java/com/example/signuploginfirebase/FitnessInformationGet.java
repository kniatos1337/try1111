package com.example.signuploginfirebase;

import android.widget.CheckBox;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class FitnessInformationGet {

    private String workoutName;
    private String workoutTime;
    private String Cardio, Abs, Chest, Back, Legs, Shoulders, Tricep, Bicep;
    private String Description;

    public FitnessInformationGet() {
    }

    public FitnessInformationGet(String workoutName, String workoutTime, String cardio, String abs, String chest, String back, String legs, String shoulders, String tricep, String bicep, String description) {
        this.workoutName = workoutName;
        this.workoutTime = workoutTime;
        Cardio = cardio;
        Abs = abs;
        Chest = chest;
        Back = back;
        Legs = legs;
        Shoulders = shoulders;
        Tricep = tricep;
        Bicep = bicep;
        Description = description;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getWorkoutTime() {
        return workoutTime;
    }

    public void setWorkoutTime(String workoutTime) {
        this.workoutTime = workoutTime;
    }

    public String getCardio() {
        return Cardio;
    }

    public void setCardio(String cardio) {
        Cardio = cardio;
    }

    public String getAbs() {
        return Abs;
    }

    public void setAbs(String abs) {
        Abs = abs;
    }

    public String getChest() {
        return Chest;
    }

    public void setChest(String chest) {
        Chest = chest;
    }

    public String getBack() {
        return Back;
    }

    public void setBack(String back) {
        Back = back;
    }

    public String getLegs() {
        return Legs;
    }

    public void setLegs(String legs) {
        Legs = legs;
    }

    public String getShoulders() {
        return Shoulders;
    }

    public void setShoulders(String shoulders) {
        Shoulders = shoulders;
    }

    public String getTricep() {
        return Tricep;
    }

    public void setTricep(String tricep) {
        Tricep = tricep;
    }

    public String getBicep() {
        return Bicep;
    }

    public void setBicep(String bicep) {
        Bicep = bicep;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
