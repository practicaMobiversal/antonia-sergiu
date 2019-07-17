package com.mobiversal.movieapp.movieappas.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName="actor")
public class Actor {

    public Actor(int id, String lastName, String firstName, String imageUrl) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.imageUrl = imageUrl;
    }

    @PrimaryKey
    @ColumnInfo(name="id")
    private int id;


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo(name="lastName")
    private String lastName;

    @ColumnInfo(name="firstName")
    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String imageUrl;
}
