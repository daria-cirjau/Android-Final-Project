package com.google.androidfinalproject.room;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "customer_support_table")
public class CustomerSupport {



    @PrimaryKey
    @NonNull
    @ColumnInfo
    private String customerName;
    private String customerEmail;
    private String customerProblem;

    public CustomerSupport(String customerName, String customerEmail, String customerProblem) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerProblem = customerProblem;
    }

    @NonNull
    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerProblem() {
        return customerProblem;
    }

    @Override
    public String toString() {
        return "CustomerSupport{" +
                "customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerProblem='" + customerProblem + '\'' +
                '}';
    }
}
