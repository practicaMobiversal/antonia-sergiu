package com.mobiversal.movieapp.movieappas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.mobiversal.movieapp.movieappas.database.AppDatabase;
import com.mobiversal.movieapp.movieappas.model.Actor;
import com.mobiversal.movieapp.movieappas.model.Genre;
import com.mobiversal.movieapp.movieappas.model.Keyword;
import com.mobiversal.movieapp.movieappas.movies.ui.main.fragments4search.SearchMoviesActivity;
import com.mobiversal.movieapp.movieappas.ui.actors.ActorsActivity;
import com.mobiversal.movieapp.movieappas.ui.genres.GenresActivity;

import java.util.List;

public class PreferencesActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        getActorsOnClick();
        getGenresOnClick();
      openSearchMoviesActivityOnClick();
        initClickListenersActors();
        initClickListenersGenres();
        //saveOnClick();
        AppDatabase.getInstance(PreferencesActivity.this).actorDao().deleteAll();
        AppDatabase.getInstance(PreferencesActivity.this).genreDao().deleteAll();

    }
    @Override
    protected void onResume() {
        super.onResume();
        showActor();
        showGenres();

    }

    public void showActor() {

        List<Actor> selectedActor = AppDatabase.getInstance(PreferencesActivity.this).actorDao().getAllActors();
        String actorNames = "Actors:";
        TextView actorTv = findViewById(R.id.actors_btn);
        for (Actor actor: selectedActor)
            actorNames += actor.getName()+" "+"," ;
        actorTv.setText(actorNames);

    }

    public void showGenres() {

        List<Genre> selectedGenres = AppDatabase.getInstance(PreferencesActivity.this).genreDao().getAllGenres();
        String genreNames = "Genres:";
        TextView genreTv = findViewById(R.id.btnGenres);
        for (Genre genre: selectedGenres)
            genreNames += genre.getGenre()+"," ;
        genreTv.setText(genreNames);

    }


    private String getKeywords() {

        EditText keywords = findViewById(R.id.txtKeywords);
        String textKeywords = keywords.getEditableText().toString();
        return textKeywords;
    }
    private void saveKeywords(String name) {
        Keyword keywordEmpty = new Keyword(name);
        AppDatabase.getInstance(PreferencesActivity.this).keywordDao().saveKeyword(keywordEmpty);
        Log.d(PreferencesActivity.class.getSimpleName(), name);

    }
    //actors  methods start
    private void getActorsOnClick() {
        findViewById(R.id.actors_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PreferencesActivity.this, ActorsActivity.class);
                startActivity(intent);
            }
        });
    }
    //actors  methods start
    private void getGenresOnClick() {
        findViewById(R.id.btnGenres).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PreferencesActivity.this, ActorsActivity.class);
                startActivity(intent);
            }
        });
    }



//
//    private void openDrawerActivityOnClick() {
//
//        findViewById(R.id.actors_btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(PreferencesActivity.this, DrawerActivity.class);
//                startActivity(intent);
//            }
//        });
//    }

    /// actors
    private void initClickListenersActors() {
        findViewById(R.id.actors_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PreferencesActivity.this, ActorsActivity.class);
                startActivity(intent);
            }
        });
    }
    /// actors
    private void initClickListenersGenres() {
        findViewById(R.id.btnGenres).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PreferencesActivity.this, GenresActivity.class);
                startActivity(intent);
            }
        });
    }
    private void openSearchMoviesActivityOnClick() {

        saveKeywords(getKeywords());
        //if (AppDatabase.getInstance())
        findViewById(R.id.btnSave).setOnClickListener(view -> {
            Intent intent = new Intent(PreferencesActivity.this, SearchMoviesActivity.class);
            startActivity(intent);
        });


    }

}