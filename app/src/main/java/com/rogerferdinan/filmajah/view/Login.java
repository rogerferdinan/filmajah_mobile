package com.rogerferdinan.filmajah.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.rogerferdinan.filmajah.R;

public class Login extends AppCompatActivity {
    private TextInputLayout tEmail;
    private TextInputLayout tPass;

    private TextView tvForgot;
    private Button bLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        tEmail = findViewById(R.id.etEmailAddress);
        tPass = findViewById(R.id.etPass);
        bLogin = findViewById(R.id.btnLogIn);
        tvForgot = findViewById(R.id.tvForgotPass);

    }
}
