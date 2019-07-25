package com.mobiversal.movieapp.movieappas.ui.genres;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.Nullable;

import com.mobiversal.movieapp.movieappas.database.AppDatabase;
import com.mobiversal.movieapp.movieappas.model.Genre;

import java.util.List;

public abstract class GenresLoadThread extends AsyncTask<Void, Void, List<Genre>> {
    private Context context;

    public GenresLoadThread(Context context) {
        this.context = context;
    }

    @Override
    protected List<Genre> doInBackground(Void... voids) {
        return AppDatabase.getInstance(context).genreDao().getAllGenres();
    }

    @Override
    protected void onPostExecute(List<Genre> genres) {
        super.onPostExecute(genres);
        onDone(genres);

    }

    protected abstract void onDone(@Nullable List<Genre> genres);
}