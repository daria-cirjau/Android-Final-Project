package com.google.androidfinalproject.room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.androidfinalproject.R;

import java.util.List;

public class CustomerSupportActivity extends AppCompatActivity {

    private CustomerSupportViewModel customerSupportViewModel;
    private String name;
    private String email;
    private String problem;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_support);
        Intent intent = getIntent();
        name = intent.getStringExtra("Name");
        email = intent.getStringExtra("Email");
        problem = intent.getStringExtra("Problem");

        customerSupportViewModel = new ViewModelProvider(this).get(CustomerSupportViewModel.class);
        //customerSupportViewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(CustomerSupportViewModel.class);
        customerSupportViewModel.getCsLiveData().observe(this, new Observer<List<CustomerSupport>>() {
            @Override
            public void onChanged(List<CustomerSupport> customerSupports) {
                Log.e("customerSupport", customerSupports.toString());
            }
        });


    }



    public void insertOnClick(View view) {
        CustomerSupport customerSupport = new CustomerSupport(name, email, problem);
        customerSupportViewModel.insert(customerSupport);
        textView = findViewById(R.id.textViewShow);
        textView.setText(customerSupportViewModel.getCsLiveData().getValue().toString());
    }
}