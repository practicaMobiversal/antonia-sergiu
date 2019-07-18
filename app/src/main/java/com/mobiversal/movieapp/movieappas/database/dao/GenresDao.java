package com.mobiversal.movieapp.movieappas.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mobiversal.movieapp.movieappas.model.Genre;

import java.util.List;

@Dao
public interface GenresDao {

    @Query("SELECT * FROM genre")
    public List<Genre> getAllGenres();

    @Insert
    void saveGenre(Genre genre);

    @Query("DELETE FROM genre")
    public void deleteAll();

}
