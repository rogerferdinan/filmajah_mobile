package com.rogerferdinan.filmajah.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.rogerferdinan.filmajah.R;
import com.rogerferdinan.filmajah.model.Movie;
import com.rogerferdinan.filmajah.viewmodel.MovieViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MovieViewModel movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        movieViewModel.getMovieList().observe(this, mList -> {
            for(Movie m: mList) {
                Log.d("Testing", m.name.toString());
            }
        });
    }
}