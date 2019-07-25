package com.mobiversal.movieapp.movieappas.movies.ui.main.fragments4saved;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobiversal.movieapp.movieappas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WatchedFragment extends Fragment {


    public WatchedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_watched2, container, false);
    }

}
