package com.mobiversal.movieapp.movieappas.movies.ui.main.fragments4search;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.mobiversal.movieapp.movieappas.R;

public class SearchMoviesActivity extends AppCompatActivity {

        private DrawerLayout drawerLayout;
        private NavigationView navigationView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_search_movies_screen);
            showFirstFragment();
            initToolbar();
            initDrawer();
        }

        @SuppressLint("RestrictedApi")
        private void initToolbar() {
            drawerLayout = findViewById(R.id.dl_drawer);
            Toolbar toolbar = findViewById(R.id.tb_toolbar);
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            }
            toolbar.setNavigationOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));
        }

        private void initDrawer() {
            navigationView = findViewById(R.id.nv_navigation);
            ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
            drawerLayout.addDrawerListener(drawerToggle);
            drawerToggle.syncState();
            navigationView.setNavigationItemSelectedListener(menuItem -> {
                handleNavigation(menuItem.getItemId());
                closeDrawer();
                return true;
            });
        }
        private void closeDrawer() {

            drawerLayout.closeDrawers();
        }
        private void showFirstFragment() {
            switchFragment(new MovieListFragment());
        }

        private void showSecondFragment()   {
            switchFragment(new SavedMoviesFragment());
        }


        private void switchFragment(Fragment fragment) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .replace(R.id.fl_container, fragment)
                    .commit();
        }


        private void handleNavigation(int destinationId){

            switch (destinationId){
                case R.id.first:
                    showFirstFragment();
                    break;
                case R.id.second:
                    showSecondFragment();
                    break;
            }
        }
    }
