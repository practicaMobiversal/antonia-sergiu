package com.mobiversal.movieapp.movieappas.ui.genres;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiversal.movieapp.movieappas.R;
import com.mobiversal.movieapp.movieappas.model.Genre;

import com.mobiversal.movieapp.movieappas.ui.genres.GenresAdapter;


import java.util.List;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.GenresViewHolder> {
    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    List<Genre> genres;

    public GenresAdapter(List<Genre> genres) {
        this.genres = genres;
    }


    @NonNull
    @Override
    public GenresAdapter.GenresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.view_genres_item, parent, false);
        return new GenresAdapter.GenresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenresAdapter.GenresViewHolder holder, int position) {
        holder.onBind(genres.get(position));
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }

    class GenresViewHolder extends RecyclerView.ViewHolder {


        TextView genretext;
        CheckBox genrecheckbox;


        public GenresViewHolder(@NonNull View itemView) {
            super(itemView);

            genretext = itemView.findViewById(R.id.tv_genreText);
            genrecheckbox = itemView.findViewById(R.id.check_genre);

        }

        public void onBind(Genre genre) {
            genretext.setText(genre.getName());


        }
    }

}







