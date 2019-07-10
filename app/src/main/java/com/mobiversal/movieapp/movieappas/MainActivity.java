package com.mobiversal.movieapp.movieappas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends ParentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initClickListeners();
        getSupportFragmentManager().beginTransaction().add(R.id.lyt_favorites, new FavoritesFragment(),"fragment");

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
}
