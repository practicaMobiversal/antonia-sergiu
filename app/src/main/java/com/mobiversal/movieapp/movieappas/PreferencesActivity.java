package com.mobiversal.movieapp.movieappas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


import com.mobiversal.movieapp.movieappas.database.AppDatabase;
import com.mobiversal.movieapp.movieappas.model.Keyword;
import com.mobiversal.movieapp.movieappas.movies.SavedMoviesActivity;
import com.mobiversal.movieapp.movieappas.ui.DrawerActivity;
import com.mobiversal.movieapp.movieappas.ui.actors.ActorsActivity;
import com.mobiversal.movieapp.movieappas.ui.genres.GenresActivity;

public class PreferencesActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        initClickListeners();
       // openDrawerActivityOnClick();
        initClickListenersActors();
        initClickListenersGenres();
        saveOnClick();
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
    private void initClickListeners() {
        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveKeywords(getKeywords());
            }
        });

    }


 //save button method

    private void saveOnClick() {
        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveKeywords(getKeywords());
                Intent intent = new Intent(PreferencesActivity.this, SavedMoviesActivity.class);
                startActivity(intent);
            }
        });
    }

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


}