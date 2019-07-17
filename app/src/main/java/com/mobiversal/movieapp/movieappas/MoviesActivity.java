package com.mobiversal.movieapp.movieappas;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiversal.movieapp.movieappas.database.AppDatabase;
import com.mobiversal.movieapp.movieappas.model.Movie;

import java.util.List;

public class MoviesActivity extends ParentActivity {
    private RecyclerView rvMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_activity);
        this.rvMovies = findViewById(R.id.rv_movies);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        LinearLayoutManager lln = new LinearLayoutManager(this);
        lln.setOrientation(RecyclerView.VERTICAL);
        rvMovies.setLayoutManager(lln);
        new MoviesLoadThread(this) {
            @Override
            protected void onDone(@Nullable List<Movie> movies) {
                MoviesAdapter moviesAdapter= new MoviesAdapter(movies);
                rvMovies.setAdapter(moviesAdapter);

            }
        }.execute(null, null, null);
      // List<Movie> movies = AppDatabase.getInstance(this).movieDao().getAllMovies();
     //   MoviesAdapter moviesAdapter = new MoviesAdapter(movies);
     //  rvMovies.setAdapter(moviesAdapter);
    }
}
