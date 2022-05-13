package com.google.androidfinalproject.room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_support);
        customerSupportViewModel = new ViewModelProvider(this).get(CustomerSupportViewModel.class);
        customerSupportViewModel.getWords().observe(this, new Observer<List<CustomerSupport>>() {
            @Override
            public void onChanged(List<CustomerSupport> customerSupports) {
                Log.e("customerSupport", customerSupports.toString());
            }
        });
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("Name");
            email = extras.getString("Email");
            problem = extras.getString("Problem");
        }

    }



    public void insertWordOnClick(View view) {
        CustomerSupport customerSupport = new CustomerSupport(name, email, problem);
        customerSupportViewModel.insert(customerSupport);
    }
}