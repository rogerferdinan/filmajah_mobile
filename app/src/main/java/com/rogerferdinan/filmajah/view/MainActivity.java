package com.rogerferdinan.filmajah.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rogerferdinan.filmajah.R;
import com.rogerferdinan.filmajah.view.fragment.CollectionFragment;
import com.rogerferdinan.filmajah.view.fragment.HomeFragment;
import com.rogerferdinan.filmajah.view.fragment.MovieInfoFragment;
import com.rogerferdinan.filmajah.view.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeFragment(R.id.fragment_container, HomeFragment.class);
        BottomNavigationView navigationView = findViewById(R.id.bot_nav);
        navigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.home) {
                changeFragment(R.id.fragment_container, MovieInfoFragment.class);
                return true;
            } else if (item.getItemId() == R.id.collection) {
                changeFragment(R.id.fragment_container, CollectionFragment.class);
                return true;
            } else if(item.getItemId() == R.id.profile) {
                changeFragment(R.id.fragment_container, ProfileFragment.class);
                return true;
            }
            return false;
        });
    }
    void changeFragment(int container, Class<? extends Fragment> fragment_class) {
        getSupportFragmentManager().beginTransaction()
                .replace(container, fragment_class, null)
                .commit();
    }
}