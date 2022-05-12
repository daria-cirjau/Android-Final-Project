package com.google.androidfinalproject.RecyclerView;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class RecentDestination {
    private String mall;/*
    private String nbOfHours;

    private String date;
    private String hour;*/
    private String details;

    public RecentDestination(String mall, String details) {
        this.mall = mall;/*
        this.nbOfHours = nbOfHours;
        this.date = date;
        this.hour = hour;*/
        this.details = details;
    }


    public String getDetails() {
        return details;
    }

    public String getMall() {
        return mall;
    }

    public void setMall(String mall) {
        this.mall = mall;
    }/*

    public String getNbOfHours() {
        return nbOfHours;
    }

    public void setNbOfHours(String nbOfHours) {
        this.nbOfHours = nbOfHours;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }*/
}
