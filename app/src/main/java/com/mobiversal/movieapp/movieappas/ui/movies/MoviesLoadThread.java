package com.mobiversal.movieapp.movieappas.ui.movies;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.Nullable;

import com.mobiversal.movieapp.movieappas.database.AppDatabase;
import com.mobiversal.movieapp.movieappas.model.Movie;

import java.util.List;

public abstract class MoviesLoadThread extends AsyncTask<Void, Void, List<Movie>> {
    private Context context;

    public MoviesLoadThread(Context context){
        this.context = context;
    }
    @Override
    protected List<Movie> doInBackground(Void... voids) {
        return AppDatabase.getInstance(context).movieDao().getAllMovies();
    }
    @Override
        protected void onPostExecute(List<Movie>movies){
            super.onPostExecute(movies);
            onDone(movies);

    }
 protected abstract void  onDone(@Nullable List<Movie> movies);
}
