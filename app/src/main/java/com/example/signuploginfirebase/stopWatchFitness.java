package com.example.signuploginfirebase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class stopWatchFitness extends AppCompatActivity {

    TextView descText;
    private int seconds = 0;
    private boolean running;
    FirebaseDatabase database;
    DatabaseReference databaseFitness;
    FitnessInformationGet fitnessInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch_fitness);
        startTimer();

        descText = findViewById(R.id.showDesc);


        descText.setText(getIntent().getStringExtra("desc"));

    }
    public void onstart (View view)
    {
        running = true;
    }
    public void onpause (View view){
        running = false;
    }
    public void onreset(View view){
        running = false;
        seconds = 0;
    }
    private void startTimer(){
        TextView timer=findViewById(R.id.timer);
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hrs = seconds/3600;
                int mins = (seconds%3600)/60;
                int sec = seconds%60;
                String time = String.format("%02d:%02d:%02d",hrs,mins,sec);
                timer.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }


}