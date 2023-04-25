package com.example.signuploginfirebase;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FitnessAdapterNew extends RecyclerView.Adapter<FitnessAdapterNew.MyViewHolder> {

    Context context;
    ArrayList<FitnessInformationGet> list;

    public FitnessAdapterNew(Context context, ArrayList<FitnessInformationGet> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FitnessAdapterNew.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cards,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FitnessAdapterNew.MyViewHolder holder, int position) {


        FitnessInformationGet fitnessInformationGet = list.get(position);
        holder.fitnessName.setText(fitnessInformationGet.getWorkoutName());
        holder.fitnessTime.setText(fitnessInformationGet.getWorkoutTime());
        holder.fitnessDesc.setText((fitnessInformationGet.getDescription()));

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, checkFitnessInformation.class);
                intent.putExtra("editWorkoutName", fitnessInformationGet.getWorkoutName());
                intent.putExtra("editWorkoutTime", fitnessInformationGet.getWorkoutTime());
                intent.putExtra("editWorkoutDesc", fitnessInformationGet.getDescription());
                intent.putExtra("getCardio", fitnessInformationGet.getCardio());
                intent.putExtra("getAbs",fitnessInformationGet.getAbs());
                intent.putExtra("getChest",fitnessInformationGet.getChest());
                intent.putExtra("getBack",fitnessInformationGet.getBack());
                intent.putExtra("getLegs",fitnessInformationGet.getLegs());
                intent.putExtra("getShoulders",fitnessInformationGet.getShoulders());
                intent.putExtra("getTricep",fitnessInformationGet.getTricep());
                intent.putExtra("getBicep",fitnessInformationGet.getBicep());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView fitnessName, fitnessTime, fitnessDesc, checkCardio, checkAbs, checkChest, checkBack, checkLegs, checkShoulders, checkTricep, checkBicep;;
        Button button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            fitnessName = itemView.findViewById(R.id.cardName);
            fitnessTime = itemView.findViewById(R.id.cardTime);
            fitnessDesc = itemView.findViewById(R.id.cardDesc);

            button = itemView.findViewById(R.id.cardButton);
        }

    }

}
