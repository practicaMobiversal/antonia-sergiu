package com.mobiversal.movieapp.movieappas.Network;

import com.mobiversal.movieapp.movieappas.Network.response.ActorsResponse;
import com.mobiversal.movieapp.movieappas.Network.response.GenresResponse;
import com.mobiversal.movieapp.movieappas.Network.response.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {
    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);


    @GET("person/popular")
    Call<ActorsResponse> getPopularPeople(@Query("api_key") String apiKey);

    @GET("genre/movie/list")
    Call<GenresResponse> getMoviesListGenres(@Query("api_key") String apiKey);


}