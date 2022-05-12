package com.google.androidfinalproject.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.androidfinalproject.MainActivity;
import com.google.androidfinalproject.R;
import com.google.androidfinalproject.ReserveActivity;

import java.util.ArrayList;
import java.util.List;

public class RecentDestinationsListFragment extends Fragment {

    private RecyclerView recyclerViewDestinations;
    private List<RecentDestination> recentDestinationsList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_recent_destination_list, container, false);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewDestinations = getActivity().findViewById(R.id.recyclerView);
        recyclerViewDestinations.setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecentDestinationsList();
        //setupLayoutManager();
        recyclerViewDestinations.setAdapter(getRecentDestinationsAdapter());
    }

    public void getRecentDestinationsList() {
        recentDestinationsList = new ArrayList<>();
        RecentDestination recentDestination1 = new RecentDestination("Sun Plaza",  "3 08-05-2022 2:20");
        RecentDestination recentDestination2 = new RecentDestination("Afi", "1 10-05-2022 4:50");

        recentDestinationsList.add(recentDestination2);
        recentDestinationsList.add(recentDestination1);


    }

    // step 2: get adapter
    private RecentDestinationsAdapter getRecentDestinationsAdapter() {
        return new RecentDestinationsAdapter(recentDestinationsList);
    }


}