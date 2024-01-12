package com.rogerferdinan.filmajah.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.rogerferdinan.filmajah.R;
import com.rogerferdinan.filmajah.viewmodel.LoginVM;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout tEmail;
    private TextInputLayout tPass;
    private Button bLogin;
    private ImageButton ibBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        LoginVM loginVM = new LoginVM();
        tEmail = findViewById(R.id.etEmailAddress);
        tPass = findViewById(R.id.etPass);
        bLogin = findViewById(R.id.btnLogIn);
        ibBack = findViewById(R.id.ibBackButton);
        tEmail.getEditText().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN){
                    tEmail.setError(null);
                }
                return false;
            }
        });
        tPass.getEditText().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN){
                    tPass.setError(null);
                }
                return false;
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplicationContext() , MainActivity.class);
                String email = tEmail.getEditText().getText().toString();
                String pass = tPass.getEditText().getText().toString();

                if (email.isEmpty()){
                    tEmail.setError("Cannot be empty");
                } else if(!Pattern.matches(".+@.+\\..+", email)) {
                    tEmail.setError("Format should be valid");
                } else {
                    tEmail.setError(null);
                }

                if (pass.isEmpty()){
                    tPass.setError("Cannot be empty");
                }else{
                    tPass.setError(null);
                }

                if(!email.isEmpty() && !pass.isEmpty()) {
                    loginVM.login(email, pass).observe(LoginActivity.this, apiResponse -> {
                       if(apiResponse.success) {
                           Intent next = new Intent(getApplicationContext(), MainActivity.class);
                           next.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                           next.putExtra("email", email);
                           next.putExtra("password", pass);
                           startActivity(next);
                           finish();
                       } else {
                           Toast.makeText(getApplicationContext(), apiResponse.message, Toast.LENGTH_LONG).show();
                       }
                    });
                }
            }
        });

        ibBack.setOnClickListener(view -> {
            finish();
        });

    }
}
