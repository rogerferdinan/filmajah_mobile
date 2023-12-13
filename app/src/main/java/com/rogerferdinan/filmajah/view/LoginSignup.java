package com.rogerferdinan.filmajah.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rogerferdinan.filmajah.R;

public class LoginSignup extends AppCompatActivity {
    private Button bLogin;
    private Button bSignup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_signup);
        bLogin = findViewById(R.id.btnLogIn);
        bSignup = findViewById(R.id.btnSignUp);
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplicationContext(),Login.class);
                startActivity(login);
            }

        });

        bSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(getApplicationContext(),Signup.class);
                startActivity(signup);
            }

        });
    }
}
