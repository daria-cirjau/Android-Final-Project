package com.google.androidfinalproject.RecyclerView;


import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.androidfinalproject.MallFragments.SunPlazaParkingFragment;
import com.google.androidfinalproject.R;

public class RecentDestinationsHolder extends RecyclerView.ViewHolder {


    private final TextView mall;
    /*private final TextView nbOfHours;

    private final TextView date;
    private final TextView hour;*/
    private final TextView details;

    public RecentDestinationsHolder(@NonNull View itemView) {
        super(itemView);
        mall = itemView.findViewById(R.id.textViewMallName);
        /*nbOfHours = itemView.findViewById(R.id.textViewNbOfHours);
        date = itemView.findViewById(R.id.textViewDate);
        hour = itemView.findViewById(R.id.textViewTime);*/
        details = itemView.findViewById(R.id.textViewDetails);
    }



    public TextView getDetails() {
        return details;
    }

    public TextView getMall() {
        return mall;
    }

/*
    public TextView getNbOfHours() {
        return nbOfHours;
    }

    public TextView getDate() {
        return date;
    }

    public TextView getHour() {
        return hour;
    }*/
}
