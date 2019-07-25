package com.mobiversal.movieapp.movieappas.ui.movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiversal.movieapp.movieappas.ItemClickListener;
import com.mobiversal.movieapp.movieappas.R;
import com.mobiversal.movieapp.movieappas.model.Movie;
import com.mobiversal.movieapp.movieappas.movies.MovieItemViewHolder;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MovieItemViewHolder> {
    private ItemClickListener<Movie> itemClickListener;
    private List<Movie> movies;

    private Context context;

    public MoviesAdapter(List<Movie> movies, ItemClickListener<Movie> itemClickListener) {
        this.movies = movies;
        this.itemClickListener = itemClickListener;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    private ItemClickListener listener;

    @NonNull
    @Override
    public MovieItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.view_movie_item, parent, false);
        return new MovieItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieItemViewHolder holder, int position) {
        Movie movie = this.movies.get(position);
        holder.onBind(movie);
        itemListener(movie);
    }

    @Override
    public int getItemCount() {

        return movies.size();

    }

    public void itemListener(Movie movie){

        itemView.setOnClickListener((View.OnClickListener) view -> itemClickListener.onItemClick(movie));
    }

}
