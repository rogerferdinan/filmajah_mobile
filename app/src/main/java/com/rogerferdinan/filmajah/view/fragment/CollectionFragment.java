package com.rogerferdinan.filmajah.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rogerferdinan.filmajah.R;
import com.rogerferdinan.filmajah.model.LoginBody;
import com.rogerferdinan.filmajah.view.recyclerview.HomeMovieAdapter;
import com.rogerferdinan.filmajah.viewmodel.MainViewModel;

public class CollectionFragment extends Fragment {
    public CollectionFragment() {
        super(R.layout.collection);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainViewModel viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);

        RecyclerView rvCollection = view.findViewById(R.id.rvCollection);
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), 2);
        rvCollection.setLayoutManager(layoutManager);
        viewModel.getCollection().observe(getViewLifecycleOwner(), movieList -> {
            rvCollection.setAdapter(new HomeMovieAdapter(movieList, viewModel.user, getActivity()));
        });

        ImageButton ibBack = view.findViewById(R.id.ibBackButton);
        ibBack.setOnClickListener(v -> {
            if (getActivity().getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });
    }
}