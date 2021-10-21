package com.example.android31.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.android31.data.models.character.CharacterDto;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllCharacters(List<CharacterDto> characterDto);

    @Query("SELECT * FROM character")
    List<CharacterDto> getAllCharacters();

    @Query("SELECT * FROM character WHERE id = :id")
    CharacterDto getCharacter(int id);
}
