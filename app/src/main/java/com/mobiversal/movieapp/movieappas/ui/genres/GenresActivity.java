package com.mobiversal.movieapp.movieappas.ui.genres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import com.mobiversal.movieapp.movieappas.Network.RequestManager;

import com.mobiversal.movieapp.movieappas.Network.response.GenresResponse;
import com.mobiversal.movieapp.movieappas.R;
import com.mobiversal.movieapp.movieappas.database.AppDatabase;
import com.mobiversal.movieapp.movieappas.model.Genre;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GenresActivity extends AppCompatActivity {

    private RecyclerView rrecyclerview;
    private GenresAdapter adapter;
    private static final String TAG = GenresActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);
        rrecyclerview = findViewById(R.id.rv_genres);
        getGenresOnClick();
        setUpRecyclerView();
        getActorsFromDataBase();
    }

    private void setUpRecyclerView() {
        LinearLayoutManager lln = new LinearLayoutManager(this);
        lln.setOrientation(RecyclerView.VERTICAL);
        adapter = new GenresAdapter(new ArrayList<>());
        rrecyclerview.setAdapter(adapter);
        rrecyclerview.setLayoutManager(lln);
    }
    private void getActorsFromDataBase() {
        Call<GenresResponse> request = RequestManager.getInstance().getMoviesListGenres();
        request.enqueue(new Callback<GenresResponse>() {
            @Override
            public void onResponse(Call<GenresResponse> call, Response<GenresResponse> response) {
//                AppDatabase.getInstance(GenresActivity.this)
//                        .genreDao();

                List<Genre> genres = response.body().getGenres();
                adapter.setGenres(genres);
                adapter.notifyDataSetChanged();

                for (Genre genre : genres) {
                    Log.d(TAG,genre.getGenre());
//                    AppDatabase.getInstance(ActorsActivity.this)
//                            .genreDao()
//                            .saveGenre(genre);
                }
//                onDatabaseUpToDate();

            }

            @Override
            public void onFailure(Call<GenresResponse> call, Throwable t) {
                Log.d(TAG, "Get genres failure:" + t.getMessage());
            }
        });
    }


    public void getGenresOnClick() {
        findViewById(R.id.save_genres).setOnClickListener(view -> {
            AppDatabase.getInstance(GenresActivity.this).genreDao().deleteAll();
            for (Genre genre: adapter.getSelectedGenres() ) {
                AppDatabase.getInstance(GenresActivity.this).genreDao().saveGenre(genre);
                Log.d(TAG, genre.getGenre());
            }
            onBackPressed();
        });

    }
}


