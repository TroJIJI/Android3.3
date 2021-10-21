package com.example.android31.data.repositories;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;

import com.example.android31.App;
import com.example.android31.common.Resource;
import com.example.android31.data.local.CharacterDao;
import com.example.android31.data.models.MainResponse;
import com.example.android31.data.models.character.CharacterDto;
import com.example.android31.data.remote.ApiService;
import com.example.android31.domain.repositories.MainRepository;
import com.example.android31.ui.character_detail.CharacterDetailFragmentArgs;
import com.example.android31.ui.characters_list.CharactersFragmentDirections;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepositoryImpl implements MainRepository {

    private ApiService service;
    private CharacterDao dao;

    @Inject
    public MainRepositoryImpl(ApiService service, CharacterDao dao) {
        this.service = service;
        this.dao = dao;
    }
    
    @Override
    public MutableLiveData<Resource<MainResponse<CharacterDto>>> fetchCharacters() {
        MutableLiveData<Resource<MainResponse<CharacterDto>>> liveData = new MutableLiveData<>();
        liveData.setValue(Resource.loading(null));
       service.fetchCharacters().enqueue(new Callback<MainResponse<CharacterDto>>() {
            @Override
            public void onResponse(Call<MainResponse<CharacterDto>> call, Response<MainResponse<CharacterDto>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    liveData.setValue(Resource.success(response.body()));
                    dao.insertAllCharacters(response.body().getResults());
                } else {
                    liveData.setValue(Resource.error(response.message(), null));
                }
            }

            @Override
            public void onFailure(Call<MainResponse<CharacterDto>> call, Throwable t) {
                liveData.setValue(Resource.error(t.getLocalizedMessage(), null));
            }
        });

        return liveData;
    }


}
