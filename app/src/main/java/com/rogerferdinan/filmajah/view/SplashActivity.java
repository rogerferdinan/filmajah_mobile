package com.rogerferdinan.filmajah.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rogerferdinan.filmajah.R;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        Button bLogin = findViewById(R.id.btnLogIn);
        Button bSignup = findViewById(R.id.btnSignUp);
        bLogin.setOnClickListener(view -> {
            Intent login = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(login);
        });

        bSignup.setOnClickListener(view -> {
            Intent signup = new Intent(getApplicationContext(), SignupActivity.class);
            startActivity(signup);
        });
    }
}
