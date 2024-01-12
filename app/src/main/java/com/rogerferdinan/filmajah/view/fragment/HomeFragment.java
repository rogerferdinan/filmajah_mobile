package com.rogerferdinan.filmajah.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rogerferdinan.filmajah.R;
import com.rogerferdinan.filmajah.model.LoginBody;
import com.rogerferdinan.filmajah.view.SearchActivity;
import com.rogerferdinan.filmajah.view.recyclerview.HomeMovieAdapter;
import com.rogerferdinan.filmajah.viewmodel.MainViewModel;

public class HomeFragment extends Fragment {
    public HomeFragment() {
        super(R.layout.home);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainViewModel viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);

        SearchView svSearch = view.findViewById(R.id.svSearch);

        svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent searchIntent = new Intent(getContext(), SearchActivity.class);
                searchIntent.putExtra("query", query);
                searchIntent.putExtra("email", viewModel.user.email);
                searchIntent.putExtra("password", viewModel.user.password);
                startActivity(searchIntent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        RecyclerView rvRecommendation = view.findViewById(R.id.rvRecommendation);
        RecyclerView rvTrending = view.findViewById(R.id.rvTrend);
        LinearLayoutManager layoutRecommendation = new LinearLayoutManager(view.getContext());
        layoutRecommendation.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvRecommendation.setLayoutManager(layoutRecommendation);
        viewModel.getRecommendation().observe(getViewLifecycleOwner(), movieList -> {
            rvRecommendation.setAdapter(new HomeMovieAdapter(movieList, viewModel.user, getActivity()));
        });
        LinearLayoutManager layoutTrending = new LinearLayoutManager(view.getContext());
        layoutTrending.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvTrending.setLayoutManager(layoutTrending);
        viewModel.getTrending().observe(getViewLifecycleOwner(), movieList -> {
            rvTrending.setAdapter(new HomeMovieAdapter(movieList, viewModel.user, getActivity()));
        });
    }
}
