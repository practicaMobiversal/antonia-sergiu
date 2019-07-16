package com.mobiversal.movieapp.movieappas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


import com.mobiversal.movieapp.movieappas.database.AppDatabase;
import com.mobiversal.movieapp.movieappas.model.Keyword;
import com.mobiversal.movieapp.movieappas.ui.DrawActivity;

public class PreferencesActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        initClickListeners();
        openDrawerActivityOnClick();

    }

    private String getKeywords() {

        EditText keywords = findViewById(R.id.txtKeywords);
        String textKeywords = keywords.getEditableText().toString();
        return textKeywords;
    }

    private void initClickListeners() {
        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveKeywords(getKeywords());
            }
        });

    }


    private void saveKeywords(String name) {
        Keyword keywordEmpty = new Keyword(name);
        AppDatabase.getInstance(PreferencesActivity.this).keywordDao().saveKeyword(keywordEmpty);
        Log.d(PreferencesActivity.class.getSimpleName(), name);
    }

    private void saveOnClick() {
        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveKeywords(getKeywords());
                Intent intent = new Intent (PreferencesActivity.this,MoviesActivity.class);
                startActivity(intent);
            }
        });
    }
    private void openDrawerActivityOnClick() {

        findViewById(R.id.actors_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PreferencesActivity.this, DrawActivity.class);
                startActivity(intent);
            }
        });
    }

}

