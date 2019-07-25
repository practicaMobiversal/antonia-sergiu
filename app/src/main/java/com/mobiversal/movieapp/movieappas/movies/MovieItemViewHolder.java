package com.mobiversal.movieapp.movieappas.movies;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiversal.movieapp.movieappas.R;
import com.mobiversal.movieapp.movieappas.model.Movie;
import com.mobiversal.movieapp.movieappas.utils.ImageLoader;

import static com.mobiversal.movieapp.movieappas.utils.Constants.BASE_IMAGE_URL;
import static com.mobiversal.movieapp.movieappas.utils.Constants.IMAGE_SIZE;

public class MovieItemViewHolder extends RecyclerView.ViewHolder {

    private ImageView imMovie;
    private TextView tvTitle;

    public MovieItemViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imMovie = itemView.findViewById(R.id.img);
        this.tvTitle = itemView.findViewById(R.id.tv_title);
    }

    public  void onBind(Movie movie) {
        ImageLoader.loadUrl(imMovie, BASE_IMAGE_URL + IMAGE_SIZE + movie.getImageUrl(), imMovie.getContext());
        this.tvTitle.setText(movie.getTitle());

    }
}