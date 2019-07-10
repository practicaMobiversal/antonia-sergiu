package com.mobiversal.movieapp.movieappas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends ParentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initClickListeners();
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
