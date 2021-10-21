package com.example.android31.ui.characters_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android31.data.models.character.CharacterDto;
import com.example.android31.databinding.ListCharactersBinding;

import java.util.ArrayList;
import java.util.List;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.ViewHolder> {
    private List<CharacterDto> list = new ArrayList<>();
    private OnCharacterClick listener;

    public void setListener(OnCharacterClick listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CharactersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(ListCharactersBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    public void setList(List<CharacterDto> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
        holder.itemView.setOnClickListener(v -> {
            listener.onClick(list.get(position).getId());

        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, status;
        private ImageView imageView;
        private ListCharactersBinding binding;

        public ViewHolder(@NonNull ListCharactersBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

        }

        public void onBind(CharacterDto models) {
            binding.tvName.setText(models.getName());
            binding.tvStatus.setText(models.getStatus());
            Glide.with(binding.getRoot()).load(models.getImage()).centerCrop().into(binding.imgCharacters);

        }
    }
    interface OnCharacterClick{
        void onClick(int id);
    }
}
