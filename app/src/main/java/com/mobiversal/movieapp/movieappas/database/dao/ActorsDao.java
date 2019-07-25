package com.mobiversal.movieapp.movieappas.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.mobiversal.movieapp.movieappas.model.Actor;

import java.util.List;

@Dao
public interface ActorsDao {

    @Query("SELECT * FROM actor")
    public List<Actor> getAllActors();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveActor(Actor actor);

    @Query("DELETE FROM actor")
    public void deleteAll();
}
