package com.google.androidfinalproject.RecyclerView;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class RecentDestination {
    private String mall;
    private String details;
    private int id;

    public RecentDestination(int id, String mall, String details) {
        this.id = id;
        this.mall = mall;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }

    public String getMall() {
        return mall;
    }

    public void setMall(String mall) {
        this.mall = mall;
    }

}
