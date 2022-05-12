package com.google.androidfinalproject.NavigationFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.androidfinalproject.MainActivity;
import com.google.androidfinalproject.R;

public class ProfileFragment extends Fragment {

    private String name;
    private String email;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            name = getArguments().getString(MainActivity.NAME, " ");
            email = getArguments().getString(MainActivity.EMAIL, " ");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        TextView textViewName = view.findViewById(R.id.textViewNameName);
        TextView textViewEmail = view.findViewById(R.id.textViewEmailEmail);
        textViewName.setText(String.format("%s", name));
        textViewEmail.setText(String.format("%s", email));
        return  view;
    }

}