package com.mobiversal.movieapp.movieappas.ui;

import  android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.mobiversal.movieapp.movieappas.MoviesAdapter;
import com.mobiversal.movieapp.movieappas.MoviesLoadThread;
import com.mobiversal.movieapp.movieappas.R;
import com.mobiversal.movieapp.movieappas.model.Movie;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private RecyclerView rvSearchMovies;


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.search, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.rvSearchMovies = view.findViewById(R.id.rv_movies);
        setupRecyclerView();
    }


    private void setupRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(RecyclerView.VERTICAL);

        rvSearchMovies.setLayoutManager(llm);

        new MoviesLoadThread(getContext()) {
            @Override
            protected void onDone(@Nullable List<Movie> movies) {
                MoviesAdapter moviesAdapter = new MoviesAdapter(movies);
                rvSearchMovies.setAdapter(moviesAdapter);

            }
        }.execute(null, null, null);

    }

}