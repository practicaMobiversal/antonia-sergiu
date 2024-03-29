package com.mobiversal.movieapp.movieappas.Network;
import com.mobiversal.movieapp.movieappas.Network.response.ActorsResponse;
import com.mobiversal.movieapp.movieappas.Network.response.GenresResponse;
import com.mobiversal.movieapp.movieappas.Network.response.MoviesResponse;
import retrofit2.Call;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestManager {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String API_KEY = "03acd6d4929c29304bf08ecf63c25a86";

    private static RequestManager instatce;

    private static ApiClient apiClient;

    private RequestManager() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        apiClient = retrofit.create(ApiClient.class);
    }

    public static RequestManager getInstance() {
        if (instatce == null) {
            instatce = new RequestManager();
        }
        return instatce;
    }

    public Call<MoviesResponse> getTopRatedMovies() {
        return apiClient.getTopRatedMovies(API_KEY);

    }

    public Call<ActorsResponse> getPopularPeople() {
        return apiClient.getPopularPeople(API_KEY);
    }

    public Call<GenresResponse> getMoviesListGenres() {
        return apiClient.getMoviesListGenres(API_KEY);

    }
    public Call<MoviesResponse> getSearchedMovie(String userQuery)
    {return apiClient.getSearchedMovie(API_KEY, userQuery );}

    public Call<MoviesResponse> getDiscoveredMovie(String cast, String genre
    ){return apiClient.getDiscoveredMovie(API_KEY,cast, genre);}
public Call <MoviesResponse>getMovieVideo(){
        return apiClient.getMovieVideo(API_KEY);
}
}



