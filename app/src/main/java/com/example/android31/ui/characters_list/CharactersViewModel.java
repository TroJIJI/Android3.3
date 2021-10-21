package com.example.android31.ui.characters_list;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android31.common.Resource;
import com.example.android31.data.models.MainResponse;
import com.example.android31.data.models.character.CharacterDto;
import com.example.android31.data.repositories.MainRepositoryImpl;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class CharactersViewModel extends ViewModel {

    private MainRepositoryImpl repository;
    @Inject
    public CharactersViewModel(MainRepositoryImpl repository) {
        this.repository = repository;
    }

    MutableLiveData<Resource<MainResponse<CharacterDto>>> getCharacters(){
        return repository.fetchCharacters();
    }


}
