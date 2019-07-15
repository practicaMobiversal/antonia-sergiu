package com.mobiversal.movieapp.movieappas.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mobiversal.movieapp.movieappas.database.dao.KeywordsDao;
import com.mobiversal.movieapp.movieappas.database.dao.KeywordsDao;
import com.mobiversal.movieapp.movieappas.database.dao.MovieDao;
import com.mobiversal.movieapp.movieappas.model.Keyword;
import com.mobiversal.movieapp.movieappas.model.Movie;

import java.util.ArrayList;

@Database(entities = {Movie.class, Keyword.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract MovieDao movieDao();
    public abstract KeywordsDao keywordDao();

    public static AppDatabase getInstance(Context context){
        if(instance == null) {
            return Room.databaseBuilder(context, AppDatabase.class,  "app_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}