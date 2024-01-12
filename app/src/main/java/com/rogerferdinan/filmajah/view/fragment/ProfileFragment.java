package com.rogerferdinan.filmajah.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.rogerferdinan.filmajah.R;
import com.rogerferdinan.filmajah.view.SplashActivity;
import com.rogerferdinan.filmajah.viewmodel.MainViewModel;

public class ProfileFragment extends Fragment {
    public ProfileFragment() { super(R.layout.profile); }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainViewModel viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);

        ImageButton ibBack = view.findViewById(R.id.ibBackButton);
        ibBack.setOnClickListener(v -> {
            if (getActivity().getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });
        TextView tvFullName = view.findViewById(R.id.tvFullName);
        TextView tvEmail = view.findViewById(R.id.tvEmail);
        viewModel.getProfile(viewModel.user.email, viewModel.user.password).observe(getViewLifecycleOwner(), profile -> {
            tvFullName.setText(profile.first_name + " " + profile.last_name);
            tvEmail.setText(profile.email);
        });
        Button btnLogoout = view.findViewById(R.id.btnLogout);
        btnLogoout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent splash = new Intent(getContext(), SplashActivity.class);
                startActivity(splash);
                getActivity().finish();
            }
        });
    }
}
