package com.example.android31.ui.characters_list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android31.App;
import com.example.android31.base.BaseFragment;
import com.example.android31.data.local.CharacterDao;
import com.example.android31.data.models.character.CharacterDto;
import com.example.android31.data.models.MainResponse;
import com.example.android31.databinding.FragmentCharactersBinding;
import com.example.android31.ui.character_detail.CharacterDetailFragment;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@AndroidEntryPoint
public class CharactersFragment extends BaseFragment<FragmentCharactersBinding> implements CharactersAdapter.OnCharacterClick {

    @Inject
    CharacterDao dao;
    private CharactersViewModel viewModel;
    private CharactersAdapter adapter;


    public CharactersFragment() {
    }


    @Override
    protected FragmentCharactersBinding bind() {
        return FragmentCharactersBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initialize() {
        viewModel = new ViewModelProvider(requireActivity()).get(CharactersViewModel.class);

    }

    @Override
    protected void setupObservers() {
//        viewModel.getCharacters().observe(getViewLifecycleOwner(), result -> {
  //          switch (result.status) {
    //            case SUCCESS: {
      //              binding.fragmentRecycler.setVisibility(View.VISIBLE);
        //            binding.progressCircular.setVisibility(View.GONE);
          //          adapter.setList(result.data.getResults());
            //        break;
              //  }
                //case ERROR: {
                  //  binding.tvError.setText(result.message);
                 //   break;
                //}
                //case LOADING: {
                  //  binding.fragmentRecycler.setVisibility(View.GONE);
                    //binding.progressCircular.setVisibility(View.VISIBLE);
                   // break;
               // }
            //}
       // });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecycler();


    }

    private void setupRecycler() {
        adapter = new CharactersAdapter();
        adapter.setListener(this);
        binding.fragmentRecycler.setAdapter(adapter);
        adapter.setList(dao.getAllCharacters());


    }

    @Override
    public void onClick(int id) {
     navController.navigate(CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailFragment(id));

        }
}