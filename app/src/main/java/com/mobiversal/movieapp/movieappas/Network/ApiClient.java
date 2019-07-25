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

    @GET("search/movie")
    Call<MoviesResponse> getSearchedMovie(@Query("api_key") String apiKey, @Query("query") String query);

    @GET("discover/movie")
    Call<MoviesResponse> getDiscoveredMovie(@Query("api_key") String apiKey, @Query("with_cast") String cast, @Query("with_genres") String genre);
@GET ("movie/{movie_id}/videos")
    Call<MoviesResponse> getMovieVideo(@Query("api_key") String apiKey);
}
