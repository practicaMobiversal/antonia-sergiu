package com.mobiversal.movieapp.movieappas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.mobiversal.movieapp.movieappas.Network.RequestManager;
import com.mobiversal.movieapp.movieappas.Network.response.MoviesResponse;

import com.mobiversal.movieapp.movieappas.database.AppDatabase;
import com.mobiversal.movieapp.movieappas.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends ParentActivity {
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getMovies();
        getMoviesFromDatabase();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(MainActivity.this, PreferencesActivity.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }


    private void getMovies() {
        Call<MoviesResponse> request = RequestManager.getInstance().getTopRatedMovies();
        request.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                AppDatabase.getInstance(MainActivity.this)
                        .movieDao();

                List<Movie> movies = response.body().getResults();
                for (Movie movie : movies) {
                    Log.d(TAG, movie.getTitle());
                    AppDatabase.getInstance(MainActivity.this).movieDao().saveMovie(movie);
                }
                Log.d(TAG, "Get movies success" + response.body().getResults().toString());
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.d(TAG, "Get movies failure:" + t.getMessage());
            }
        });
    }

    private void getMoviesFromDatabase() {
        List<Movie> movies = AppDatabase.getInstance(this).movieDao().getAllMovies();
        for (Movie movie : movies) {
            Log.d(TAG, movie.getTitle());
        }

    }
}

