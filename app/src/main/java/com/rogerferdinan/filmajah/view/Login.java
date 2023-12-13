package com.rogerferdinan.filmajah.view;

import static android.view.inputmethod.EditorInfo.IME_ACTION_DONE;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.rogerferdinan.filmajah.R;
import com.rogerferdinan.filmajah.view.fragment.HomeFragment;

public class Login extends AppCompatActivity {
    private TextInputLayout tEmail;
    private TextInputLayout tPass;
    private Button bLogin;
    private ImageButton ibBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

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
                }else{
                    tEmail.setError(null);
                }

                if (pass.isEmpty()){
                    tPass.setError("Cannot be empty");
                }else{
                    tPass.setError(null);
                }

                if (email.equals("roger@gmail.com") && pass.equals("roger123")){
                    startActivity(login);
                }else{
                    Toast.makeText(getApplicationContext(),"invalid email or password",Toast.LENGTH_SHORT).show();
                }
            }
        });

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(),LoginSignup.class);
                startActivity(back);
            }
        });

    }
}
