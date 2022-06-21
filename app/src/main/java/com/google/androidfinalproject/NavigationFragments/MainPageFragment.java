package com.google.androidfinalproject.NavigationFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.androidfinalproject.MainActivity;
import com.google.androidfinalproject.R;
import com.google.androidfinalproject.RecyclerView.RecentDestination;
import com.google.androidfinalproject.RecyclerView.RecentDestinationsAdapter;
import com.google.androidfinalproject.ReserveActivity;

import java.util.ArrayList;
import java.util.List;

public class MainPageFragment extends Fragment {


    private RecyclerView recyclerViewDestinations;
    private List<RecentDestination> recentDestinationsList;
    private static int id = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            String mallName = getArguments().getString(ReserveActivity.MALL_NAME, " ");
            String details = getArguments().getString(ReserveActivity.DETAILS, " ");

            recentDestinationsList.add(new RecentDestination(id++, mallName, details));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_main_page, container, false);
        recyclerViewDestinations = getActivity().findViewById(R.id.recyclerView);
        setupRecyclerViewRecentDestinations();
        return view;

    }

    public void getRecentDestinationsList() {
        recentDestinationsList = new ArrayList<>();
        RecentDestination recentDestination1 = new RecentDestination(0, "Sun Plaza",  "3 08-05-2022 2:20");
        RecentDestination recentDestination2 = new RecentDestination(1, "Afi", "1 10-05-2022 4:50");

        recentDestinationsList.add(recentDestination2);
        recentDestinationsList.add(recentDestination1);
    }

    public RecentDestinationsAdapter getRecentDestinationsAdapter() {
        return new RecentDestinationsAdapter(recentDestinationsList);
    }

    private void setupLayoutManager() {
        recyclerViewDestinations.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    private void setupRecyclerViewRecentDestinations() {
        getRecentDestinationsList();
        setupLayoutManager();
        recyclerViewDestinations.setAdapter(getRecentDestinationsAdapter());

    }

}