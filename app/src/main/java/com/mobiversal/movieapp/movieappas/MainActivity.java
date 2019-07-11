package com.mobiversal.movieapp.movieappas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mobiversal.movieapp.movieappas.Network.RequestManager;
import com.mobiversal.movieapp.movieappas.Network.response.MoviesResponse;
import com.mobiversal.movieapp.movieappas.database.AppDataBase;
import com.mobiversal.movieapp.movieappas.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends ParentActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initClickListeners();
        getSupportFragmentManager().beginTransaction().add(R.id.lyt_favorites, new FavoritesFragment(),"fragment");
        //getMovies();
        getMoviesFromDatabase();
    }
private void initClickListeners ()
{
   findViewById(R.id.btn_favorites).setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           openSavedMoviesActivity();

       }
   });
}
  private void openSavedMoviesActivity ()    {
      Intent savedMoviesIntent =new Intent (this, SavedMoviesActivity.class);
      startActivity(savedMoviesIntent);
  }
  private void getMovies(){
      Call<MoviesResponse> request = RequestManager.getInstance().getTopRatedMovies();
      request.enqueue(new Callback<MoviesResponse>() {
          @Override
          public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
              List<Movie> movies = response.body().getResults();
              for (Movie movie : movies) {
                  Log.d(TAG, movie.getTitle());
                  AppDataBase.getInstance(MainActivity.this).movieDao().saveMovie(movie);
              }
              Log.d(TAG, "Get movies success" + response.body().getResults().toString());
          }

          @Override
          public void onFailure(Call<MoviesResponse> call, Throwable t) {
          Log.d(TAG, "Get movies failure:" + t.getMessage());
          }
      });
  }
 private  void getMoviesFromDatabase() {
        List<Movie> movies = AppDataBase.getInstance(this).movieDao().getAllMovies();
        for (Movie movie : movies){
            Log.d(TAG, movie.getTitle());
        }
 }
  }

