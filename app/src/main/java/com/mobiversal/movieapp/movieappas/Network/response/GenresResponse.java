package com.mobiversal.movieapp.movieappas.Network.response;
import com.google.gson.annotations.SerializedName;
import com.mobiversal.movieapp.movieappas.model.Genre;

import java.util.List;

public class GenresResponse {
@SerializedName("genres")
    private List<Genre> genres;


    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }


}


