package com.google.androidfinalproject.room;


import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CustomerSupport.class}, version = 1)
public abstract class CustomerSupportDatabase extends RoomDatabase {
        public abstract CustomerSupportDao wordDao();
        private static volatile CustomerSupportDatabase INSTANCE;
        static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(4);

        static CustomerSupportDatabase getDatabase(final Context context){
            if(INSTANCE == null){
                synchronized (CustomerSupportDatabase.class){
                    if(INSTANCE == null)
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CustomerSupportDatabase.class,
                               "customer_support_database" ).build();
                }
            }
            return INSTANCE;
        }

}
