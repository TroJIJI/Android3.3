package com.example.android31.domain.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.android31.common.Resource;
import com.example.android31.data.models.MainResponse;
import com.example.android31.data.models.character.CharacterDto;

import java.util.List;

public interface MainRepository {

    MutableLiveData<Resource<MainResponse<CharacterDto>>> fetchCharacters();


}
