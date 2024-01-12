package com.rogerferdinan.filmajah.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rogerferdinan.filmajah.R;
import com.rogerferdinan.filmajah.model.LoginBody;
import com.rogerferdinan.filmajah.view.fragment.CollectionFragment;
import com.rogerferdinan.filmajah.view.fragment.HomeFragment;
import com.rogerferdinan.filmajah.view.fragment.ProfileFragment;
import com.rogerferdinan.filmajah.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.user = new LoginBody(
                getIntent().getStringExtra("email"),
                getIntent().getStringExtra("password")
        );
        // Init Fragment
        changeFragment(R.id.fragment_container, HomeFragment.class);
        BottomNavigationView navigationView = findViewById(R.id.bot_nav);
        navigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.home) {
                changeFragment(R.id.fragment_container, HomeFragment.class);
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
                .add(container, fragment_class, null)
                .addToBackStack(null)
                .commit();
    }
}