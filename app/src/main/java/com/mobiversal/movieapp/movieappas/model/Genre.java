package com.mobiversal.movieapp.movieappas.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "genre")

public class Genre {
    public Genre(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @PrimaryKey

    @ColumnInfo(name = "id")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @ColumnInfo(name="name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
