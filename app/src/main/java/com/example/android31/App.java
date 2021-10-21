package com.example.android31;

import android.app.Application;

import com.example.android31.data.local.CharacterDao;
import com.example.android31.data.local.RoomClient;
import com.example.android31.data.remote.ApiService;
import com.example.android31.data.remote.RetrofitClient;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class App extends Application {




    @Override
    public void onCreate() {
        super.onCreate();
    }
}
