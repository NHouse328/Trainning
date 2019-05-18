package com.trainning.todo;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

public class AppApliction extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseApp.initializeApp(getApplicationContext());
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
