package com.google.androidfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.androidfinalproject.RecyclerView.RecentDestination;

import java.util.Calendar;

public class ReserveActivity extends AppCompatActivity {
    private String mall;
    private int year;
    private int month;
    private int day;

    private int hour;
    private int minute;

    private TextView textViewDate;
    private TextView textViewTime;
    private EditText editTextNumberOfHrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        textViewDate = findViewById(R.id.textViewDate);
        textViewTime = findViewById(R.id.textViewTime);
        editTextNumberOfHrs = findViewById(R.id.editTextNumberOfHrs);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
    }

    public void openDatePickerOnClick(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(ReserveActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                textViewDate.setText(String.format("%d-%d-%d",selectedDay, selectedMonth+1, selectedYear));
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    public void openTimePickerOnClick(View view) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(ReserveActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                textViewTime.setText(String.format("%d:%d", selectedHour, selectedMinute));
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }

    public void reserveActivityOnClick() {
        RecentDestination recentDestination = new RecentDestination(this.mall,
                String.valueOf(this.editTextNumberOfHrs.getText().toString()+ " " +this.day + "-"+ this.month +"-"+ this.year+" "+ this.hour+":"+ this.minute));

    }

    public String getMall(){
        return mall;
    }

    public String getDate(){
        return this.day + "-"+ this.month +"-"+ this.year+" ";

    }

    public String getHour(){
        return this.hour+":"+ this.minute;
    }

    public String getNbOfHours() {
        return this.editTextNumberOfHrs.getText().toString();
    }


    public void reserveActivityOnClick(View view) {
        Intent intent = new Intent(ReserveActivity.this, ReservedActivity.class);
        startActivity(intent);
    }
}