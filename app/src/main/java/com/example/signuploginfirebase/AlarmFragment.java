package com.example.signuploginfirebase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//Alarm home
public class AlarmFragment extends Fragment implements FragmentResultListener {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alarm, container, false);


        Bundle bundle = getArguments();
        if (bundle != null) {
            String myString = bundle.getString("time");
            // Do something with myString
        }

        Button button = (Button) view.findViewById(R.id.newAlarm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open instance of new frag add alarm
                AddAlarm newFragment = new AddAlarm();

                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.frame_layout, newFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // register the fragment as a listener for results
        getChildFragmentManager().setFragmentResultListener("alarm_add", this, this);
    }



    @Override
    public void onFragmentResult(String requestKey, Bundle result) {
        //ListView listView;
        //ArrayList<String> arrayList;
        //ArrayAdapter<String> adapter;

        //listView = (ListView) findViewById(R.id.listView);
        //arrayList = new ArrayList<>();
        //adapter = new ArrayAdapter<String>(getApplicationContext(), andoird.R.layout.simple_list_item_1, arrayList);

        // handle the result passed from the AddAlarm fragment
        //if (requestKey.equals("alarm_add")) {
            //String time = result.getString("alarm_add");

            // add the time to the list view
            //ListView listView = (ListView) getView().findViewById(R.id.listView);
            // create a new item and add it to the list view adapter
            //...

            //arrayList.add(time);
            //adapter.notifyDataSetChanged();
        //}
    }

}