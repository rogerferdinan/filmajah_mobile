package com.rogerferdinan.filmajah.view;

import static android.app.PendingIntent.getActivity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rogerferdinan.filmajah.R;
import com.rogerferdinan.filmajah.model.LoginBody;
import com.rogerferdinan.filmajah.view.recyclerview.HomeMovieAdapter;
import com.rogerferdinan.filmajah.view.recyclerview.SearchMovieAdapter;
import com.rogerferdinan.filmajah.viewmodel.MainViewModel;
import com.rogerferdinan.filmajah.viewmodel.SearchVM;

public class SearchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        SearchVM viewModel = new ViewModelProvider(this).get(SearchVM.class);

        String query = getIntent().getStringExtra("query");
        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");
//        Toast.makeText(this, query, Toast.LENGTH_LONG).show();
        LoginBody user = new LoginBody(email, password);
        RecyclerView rvSearch = findViewById(R.id.rvSearch);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        rvSearch.setLayoutManager(layout);
        viewModel.search_movie(query).observe(SearchActivity.this, list -> {
            rvSearch.setAdapter(new SearchMovieAdapter(list, user, this));
        });
        SearchView svSearch = findViewById(R.id.svSearch);
        svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                viewModel.search_movie(query).observe(SearchActivity.this, list -> {
                    rvSearch.setAdapter(new SearchMovieAdapter(list, user, getParent()));
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}