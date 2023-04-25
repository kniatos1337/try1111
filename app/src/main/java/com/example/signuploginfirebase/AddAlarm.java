package com.example.signuploginfirebase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TimePicker;

//adding a new alarm
public class AddAlarm extends Fragment {
    private TimePicker timePicker;
    private int uHour;
    private int uMinute;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.alarm_add, container, false);

        timePicker = view.findViewById(R.id.timePicker);

        Button cancelButton = view.findViewById(R.id.button_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close the fragment
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.popBackStack();
            }
        });


        // Get the user-selected time when the save button is clicked
        Button saveButton = view.findViewById(R.id.button_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uHour = timePicker.getHour();
                uMinute = timePicker.getMinute();

                //new item
                String time = String.format("%02d:%02d", uHour, uMinute);
                Bundle result = new Bundle();
                result.putString("time", time);
                Toast toast = Toast.makeText(getContext(), time, Toast.LENGTH_LONG);
                toast.show();

                //AlarmFragment alarmFragment = new AlarmFragment();
                //alarmFragment.setArguments(result);


                //pass to AlarmFragment
                getParentFragmentManager().setFragmentResult("alarm_add", result);

                // TODO: Save the user-selected time to a database or shared preferences

                // Close the fragment
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.popBackStack();
            }
        });

        return view;
    }
}