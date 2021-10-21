package com.example.android31.di;

import android.content.Context;

import com.example.android31.data.local.CharacterDao;
import com.example.android31.data.local.RoomClient;
import com.example.android31.data.remote.ApiService;
import com.example.android31.data.remote.RetrofitClient;
import com.example.android31.data.repositories.MainRepositoryImpl;
import com.example.android31.domain.repositories.MainRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class AppModule {

    @Provides
    public static MainRepository provideRepository(ApiService apiService,CharacterDao dao){
        return new MainRepositoryImpl(apiService,dao);
    }

    @Provides
    public static ApiService provideApiService(RetrofitClient client){
        return client.provideApiService();
    }


    @Provides
    public static RetrofitClient provideRetrofitClient(){
        return new RetrofitClient();
    }

    @Provides
    public static RoomClient provideRoomClient(){
        return new RoomClient();
    }

    @Provides
    public static CharacterDao provideCharacterDao(RoomClient client, @ApplicationContext Context context){
        return client.provideCharacterDao(client.provideDatabase(context));
    }

}
