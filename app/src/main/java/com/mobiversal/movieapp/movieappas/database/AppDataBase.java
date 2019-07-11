package com.mobiversal.movieapp.movieappas.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mobiversal.movieapp.movieappas.database.dao.MovieDao;
import com.mobiversal.movieapp.movieappas.model.Movie;

@Database(entities = {Movie.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract MovieDao movieDao();

    private static AppDataBase INSTANCE;

    public static AppDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            return Room.databaseBuilder(context, AppDataBase.class, "app_database").allowMainThreadQueries()
        .build();
        }
        return INSTANCE;
    }
}