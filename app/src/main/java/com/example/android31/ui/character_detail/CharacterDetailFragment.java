package com.example.android31.ui.character_detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.android31.App;
import com.example.android31.R;
import com.example.android31.common.Resource;
import com.example.android31.data.local.CharacterDao;
import com.example.android31.data.models.MainResponse;
import com.example.android31.data.models.character.CharacterDto;
import com.example.android31.data.remote.ApiService;
import com.example.android31.databinding.FragmentCharacterDetailBinding;
import com.example.android31.ui.characters_list.CharactersFragment;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
@AndroidEntryPoint
public class CharacterDetailFragment extends Fragment {

    private FragmentCharacterDetailBinding binding;
    private int characterId;
    private ApiService api;

    @Inject
    CharacterDao dao;

    public CharacterDetailFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        characterId = CharacterDetailFragmentArgs.fromBundle(getArguments()).getId();
        CharacterDto characterDto=dao.getCharacter(characterId);
        binding.tvDetailName.setText(characterDto.getName());
        binding.tvDetailStatus.setText(characterDto.getStatus());
        Glide.with(this).load(characterDto.getImage()).circleCrop().into(binding.ivCharacter);


    }


}