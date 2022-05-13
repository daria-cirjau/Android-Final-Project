package com.google.androidfinalproject.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CustomerSupportDao {
    @Insert
    void insert(CustomerSupport customerSupport);
    @Query("SELECT * from customer_support_table ORDER BY customerName ASC")
    LiveData<List<CustomerSupport>> getCustomerSupportList();


}
