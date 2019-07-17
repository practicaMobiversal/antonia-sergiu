package com.mobiversal.movieapp.movieappas.ui.actors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.mobiversal.movieapp.movieappas.PreferencesActivity;
import com.mobiversal.movieapp.movieappas.R;
import com.mobiversal.movieapp.movieappas.database.AppDatabase;
import com.mobiversal.movieapp.movieappas.model.Actor;
import com.mobiversal.movieapp.movieappas.model.Keyword;

import java.util.ArrayList;
import java.util.List;

public class ActorsActivity extends AppCompatActivity {
    private RecyclerView rrecyclerview;


    private List<Actor> getDumyList() {
        List<Actor> dummy = new ArrayList<>();

        dummy.add(new Actor(1, "Stan", "Sebastian", "https://whatsondisneyplus.com/wp-content/uploads/2019/05/SebastianStan-WinterSoldier-880x440.jpg"));


        return dummy;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);
        rrecyclerview = findViewById(R.id.rv_actors);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        LinearLayoutManager lln = new LinearLayoutManager(this);
        lln.setOrientation(RecyclerView.VERTICAL);
        ActorsAdapter adapter = new ActorsAdapter(getDumyList());
        rrecyclerview.setAdapter(adapter);
        rrecyclerview.setLayoutManager(lln);
    }


}

