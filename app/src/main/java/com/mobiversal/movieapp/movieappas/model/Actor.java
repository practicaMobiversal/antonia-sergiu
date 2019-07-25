package com.mobiversal.movieapp.movieappas.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;


@Entity(tableName="actor")
public class Actor {

    public Actor(int id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("profile_path")
    public String imageUrl;

    public int getId() {
        return id;
    }



    @Ignore
    private boolean selected;


    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl; }

    public void setId(int id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl; }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
