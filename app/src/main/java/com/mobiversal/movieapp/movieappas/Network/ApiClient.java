package com.mobiversal.movieapp.movieappas.Network;


import com.mobiversal.movieapp.movieappas.Network.response.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {
     @GET("movie/top_rated")
     Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);
}
