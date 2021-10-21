package com.example.android31.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.android31.data.models.character.CharacterDto;

@Database(entities = {CharacterDto.class},version = 1)
abstract class AppDatabase extends RoomDatabase {

    public abstract CharacterDao characterDao();
}
