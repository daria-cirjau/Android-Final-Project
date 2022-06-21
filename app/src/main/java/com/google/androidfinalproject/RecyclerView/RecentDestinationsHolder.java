package com.google.androidfinalproject.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.androidfinalproject.R;

public class RecentDestinationsHolder extends RecyclerView.ViewHolder {


    private final TextView mall;
    private final TextView details;
    private final ImageView mallPhoto;


    public RecentDestinationsHolder(@NonNull View itemView) {
        super(itemView);
        mall = itemView.findViewById(R.id.textViewMallName);
        details = itemView.findViewById(R.id.textViewDetails);
        mallPhoto = itemView.findViewById(R.id.imageViewMallPhoto);
    }



    public TextView getDetails() {
        return details;
    }

    public TextView getMall() {
        return mall;
    }

    public ImageView getMallPhoto() {
        return mallPhoto;
    }
}
