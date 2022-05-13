package com.google.androidfinalproject.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.androidfinalproject.R;

import java.util.List;

public class RecentDestinationsAdapter extends RecyclerView.Adapter<RecentDestinationsHolder>{

    private List<RecentDestination> recentDestinationsList;


    public RecentDestinationsAdapter(List<RecentDestination> recentDestinationsList) {
        this.recentDestinationsList = recentDestinationsList;
    }


    public void setRecentDestinationsList(List<RecentDestination> recentDestinationsList) {
        this.recentDestinationsList = recentDestinationsList;
    }

    public List<RecentDestination> getRecentDestinationsList() {
        return recentDestinationsList;
    }

    @NonNull
    @Override
    public RecentDestinationsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_2, parent, false);
        return new RecentDestinationsHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentDestinationsHolder holder, int position) {
        RecentDestination currentDestination = recentDestinationsList.get(position);
        holder.getMall().setText(currentDestination.getMall());
        holder.getDetails().setText(currentDestination.getDetails());
    }

    @Override
    public int getItemCount() {
        return recentDestinationsList.size();
    }


}
