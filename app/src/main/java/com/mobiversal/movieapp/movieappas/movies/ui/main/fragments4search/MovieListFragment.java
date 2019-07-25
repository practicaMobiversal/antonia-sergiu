package com.mobiversal.movieapp.movieappas.movies.ui.main.fragments4search;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mobiversal.movieapp.movieappas.Network.RequestManager;
import com.mobiversal.movieapp.movieappas.Network.response.MoviesResponse;
import com.mobiversal.movieapp.movieappas.PreferencesActivity;
import com.mobiversal.movieapp.movieappas.R;
import com.mobiversal.movieapp.movieappas.database.AppDatabase;
import com.mobiversal.movieapp.movieappas.model.Actor;
import com.mobiversal.movieapp.movieappas.model.Genre;
import com.mobiversal.movieapp.movieappas.model.Movie;
import com.mobiversal.movieapp.movieappas.ui.movies.MoviesAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListFragment extends Fragment {

    private RecyclerView rrSearchMovies;
    private static final String TAG = SavedMoviesFragment.class.getSimpleName();
    MoviesAdapter moviesAdapter;
    SearchView sMovies;
    List<Actor> actors;
    List<Genre> genres;
    List<Movie> movies;
   Button filter;
    public MovieListFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
        queryTextListener();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.movie_list_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.rrSearchMovies = view.findViewById(R.id.rr_search_movies);
        this.sMovies = view.findViewById(R.id.s_movies);
        movies = new ArrayList<>();
        actors = new ArrayList<>();
        genres = new ArrayList<>();
        setupRecyclerView();
        getDiscoveredMovie();
    }

    //Recyclerview
    private void setupRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(RecyclerView.VERTICAL);
        rrSearchMovies.setLayoutManager(llm);
        moviesAdapter = new MoviesAdapter(movies);
        rrSearchMovies.setAdapter(moviesAdapter);
    }

    public void queryTextListener() {
        sMovies.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText != null) {
                    getSearchedMovie();
                } else {
                    getDiscoveredMovie();
                }

                return true;
            }
        });

    }

    public String getQuery() {

        String textQuery = "";
        if (sMovies.getQuery() != null)
            textQuery = sMovies.getQuery().toString();
        return textQuery;
    }

    public String getCast() {

        String cast = "";
        actors = AppDatabase.getInstance(getContext()).actorDao().getAllActors();
        for (int i = 0; i < actors.size(); i++) {

            cast += actors.get(i).getId() + "|";
        }
        return cast;
    }

    public String getGenres() {
        String genre = "";
        genres = AppDatabase.getInstance(getContext()).genreDao().getAllGenres();
        for (int i = 0; i < genres.size(); i++) {

            genre += genres.get(i).getId() + "|";
        }

        return genre;
    }

    public void getDiscoveredMovie() {


        Call<MoviesResponse> request = RequestManager.getInstance().getDiscoveredMovie(getCast(), getGenres());
        request.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<Movie> movies = response.body().getResults();
                if (movies != null) {
                    moviesAdapter.setMovies(movies);
                    moviesAdapter.notifyDataSetChanged();
                }
                for (Movie movie : movies) {
                    Log.d(TAG, movie.getTitle());

                }
                Log.d(TAG, "Success" + response.body().getResults().toString());
            }


            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.d(TAG, "Failure" + t.getMessage());

            }
        });
    }

    public void getSearchedMovie() {

        Call<MoviesResponse> request = RequestManager.getInstance().getSearchedMovie(getQuery());
        if (getQuery().length() < 1)
            return;
        request.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<Movie> movies = response.body().getResults();
                if (movies != null) {
                    moviesAdapter.setMovies(movies);
                    moviesAdapter.notifyDataSetChanged();
                }
                for (Movie movie : movies) {
                    Log.d(TAG, movie.getTitle());

                }
                Log.d(TAG, "Success" + response.body().getResults().toString());
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.d(TAG, "Failure" + t.getMessage());
            }
        });
    }

    public void getPreferencesOnClick() {
        filter.setOnClickListener(view -> {
            Intent intent = new Intent(getContext(), PreferencesActivity.class);
            startActivity(intent);
        });
    }
}


