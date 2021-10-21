package com.example.android31.data.local;

import android.content.Context;

import androidx.room.Room;

public class RoomClient {

    public AppDatabase provideDatabase(Context context){
        return Room.databaseBuilder(context,AppDatabase.class,"rick-and-morty")
                .allowMainThreadQueries()
                .build();

    }

    public CharacterDao provideCharacterDao(AppDatabase database){
        return database.characterDao();
    }
}
