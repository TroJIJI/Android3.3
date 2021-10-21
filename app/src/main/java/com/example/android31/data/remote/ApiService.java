package com.example.android31.data.remote;

import com.example.android31.data.models.character.CharacterDto;
import com.example.android31.data.models.LocationDto;
import com.example.android31.data.models.MainResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("api/character")
    Call<MainResponse<CharacterDto>> fetchCharacters();
    @GET("api/character/{id}")
    Call<CharacterDto> fetchCharacter(
            @Path("id") int id
    );

    @GET("api/location")
    Call<MainResponse<LocationDto>> fetchLocation();


}
