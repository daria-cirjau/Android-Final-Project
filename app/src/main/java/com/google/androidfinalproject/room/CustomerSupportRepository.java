package com.google.androidfinalproject.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CustomerSupportRepository {
    private CustomerSupportDao customerSupportDao;
    private LiveData<List<CustomerSupport>> customerSupport;

    CustomerSupportRepository(Application application){
        CustomerSupportDatabase customerSupportDatabase = CustomerSupportDatabase.getDatabase(application);
        customerSupportDao = customerSupportDatabase.csDao();
        customerSupport = customerSupportDao.getCustomerSupportList();
    }

    public LiveData<List<CustomerSupport>> getCustomerSupport(){
        return customerSupport;
    }


    void insert(CustomerSupport customerSupport){
        CustomerSupportDatabase.databaseWriteExecutor.execute(()->{
            customerSupportDao.insert(customerSupport);
        });
    }

}
