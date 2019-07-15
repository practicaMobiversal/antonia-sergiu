package com.mobiversal.movieapp.movieappas.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mobiversal.movieapp.movieappas.model.Keyword;

import java.util.List;

@Dao
public interface KeywordsDao {
    @Query("SELECT * FROM movie")
    public List<Keyword> getAllKeywords();
    @Insert
    public long saveKeyword(Keyword keyword);
}