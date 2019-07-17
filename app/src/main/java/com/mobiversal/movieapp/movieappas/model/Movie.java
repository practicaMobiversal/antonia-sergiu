package com.mobiversal.movieapp.movieappas.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movie")
public class Movie {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
@PrimaryKey
    @ColumnInfo(name = "id")
    private long id;
    @ColumnInfo(name = "title")
   private String title;

   public  String getTitle(){

       return title;
   }
   public void setTitle(String title){

       this.title = title;
   }

}

