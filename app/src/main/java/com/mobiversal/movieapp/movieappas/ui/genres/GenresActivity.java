package com.mobiversal.movieapp.movieappas.ui.genres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mobiversal.movieapp.movieappas.R;
import com.mobiversal.movieapp.movieappas.model.Genre;
import com.mobiversal.movieapp.movieappas.ui.actors.ActorsAdapter;

import java.util.ArrayList;
import java.util.List;

public class GenresActivity extends AppCompatActivity {
    private RecyclerView rrecyclerview;

    private List<Genre> getGenreList() {
        List<Genre> genre = new ArrayList<>();
        genre.add(new Genre(1,"comedie"));
        return genre;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);
        rrecyclerview = findViewById(R.id.rv_genres);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        LinearLayoutManager lln = new LinearLayoutManager(this);
        lln.setOrientation(RecyclerView.VERTICAL);
        GenresAdapter adapter = new GenresAdapter(getGenreList()
        );
        rrecyclerview.setAdapter(adapter);
        rrecyclerview.setLayoutManager(lln);
    }


}
