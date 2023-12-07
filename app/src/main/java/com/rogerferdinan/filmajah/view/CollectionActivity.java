package com.rogerferdinan.filmajah.view;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rogerferdinan.filmajah.R;
import com.rogerferdinan.filmajah.view.recyclerview.MovieAdapter;
import com.rogerferdinan.filmajah.viewmodel.MovieViewModel;

public class CollectionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection);
    }
}
