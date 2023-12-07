package com.rogerferdinan.filmajah.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rogerferdinan.filmajah.R;
import com.rogerferdinan.filmajah.view.recyclerview.MovieAdapter;
import com.rogerferdinan.filmajah.viewmodel.MovieViewModel;

public class CollectionFragment extends Fragment {
    public CollectionFragment() {
        super(R.layout.collection);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MovieViewModel viewModel = new MovieViewModel();
        RecyclerView rvCollection = view.findViewById(R.id.rvCollection);
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), 2);
        rvCollection.setLayoutManager(layoutManager);
        viewModel.getMovieList().observe(getViewLifecycleOwner(), movieList -> {
            rvCollection.setAdapter(new MovieAdapter(movieList));
        });
    }
}
