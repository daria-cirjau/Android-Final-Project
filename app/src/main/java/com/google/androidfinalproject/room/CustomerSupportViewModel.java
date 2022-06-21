package com.google.androidfinalproject.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CustomerSupportViewModel extends AndroidViewModel {

    private CustomerSupportRepository customerSupportRespository;
    private LiveData<List<CustomerSupport>> csLiveData;

    public CustomerSupportViewModel(@NonNull Application application) {
        super(application);
        customerSupportRespository = new CustomerSupportRepository(application);
        csLiveData = customerSupportRespository.getCustomerSupport();
    }

    public LiveData<List<CustomerSupport>> getCsLiveData() {
        return csLiveData;
    }

    void insert(CustomerSupport customerSupport){
        customerSupportRespository.insert(customerSupport);
    }

}
