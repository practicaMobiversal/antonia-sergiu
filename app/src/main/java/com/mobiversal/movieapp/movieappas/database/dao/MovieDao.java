package com.mobiversal.movieapp.movieappas.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mobiversal.movieapp.movieappas.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM movie")
    public List<Movie> getAllMovies();

    @Insert
    public long saveMovie(Movie movie);

    @Query("DELETE FROM movie")
    public void deleteAll();

}