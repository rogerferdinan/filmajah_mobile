package com.rogerferdinan.filmajah.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.rogerferdinan.filmajah.R;
import com.rogerferdinan.filmajah.model.Movie;
import com.rogerferdinan.filmajah.view.recyclerview.MovieAdapter;
import com.rogerferdinan.filmajah.viewmodel.MovieViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MovieViewModel movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        movieViewModel.getMovieList().observe(this, mList -> {
            RecyclerView rvTrend = findViewById(R.id.rvTrend);
            rvTrend.setAdapter(new MovieAdapter(mList));
            LinearLayoutManager layout = new LinearLayoutManager(this);
            layout.setOrientation(LinearLayout.HORIZONTAL);
            rvTrend.setLayoutManager(layout);
        });
    }
}