package com.rogerferdinan.filmajah.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.rogerferdinan.filmajah.R;

public class Signup extends AppCompatActivity {
    private TextInputLayout tEmail;
    private TextInputLayout tFullname;
    private TextInputLayout tPass;
    private TextInputLayout tConfirm;
    private Button bSignup;
    private ImageButton ibBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        tEmail = findViewById(R.id.etEmailAddress);
        tFullname = findViewById(R.id.etFullname);
        tPass = findViewById(R.id.etPass);
        tConfirm = findViewById(R.id.etConfirmPass);
        bSignup = findViewById(R.id.btnSignUp);
        ibBack = findViewById(R.id.ibBackButton_su);
        tEmail.getEditText().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN){
                    tEmail.setError(null);
                }
                return false;
            }
        });
        tFullname.getEditText().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN){
                    tFullname.setError(null);
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

        tConfirm.getEditText().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN){
                    tConfirm.setError(null);
                }
                return false;
            }
        });

        bSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(getApplicationContext(), Login.class);
                String email = tEmail.getEditText().getText().toString();
                String fullname = tFullname.getEditText().getText().toString();
                String pass = tPass.getEditText().getText().toString();
                String confirm = tConfirm.getEditText().getText().toString();

                if(email.isEmpty()){
                    tEmail.setError("Cannot be empty");
                }else{
                    tEmail.setError(null);
                }

                if(fullname.isEmpty()){
                    tFullname.setError("Cannot be empty");
                }else{
                    tFullname.setError(null);
                }

                if(pass.isEmpty()){
                    tPass.setError("Cannot be empty");
                }else{
                    tPass.setError(null);
                }

                if(confirm.isEmpty()){
                    tConfirm.setError("Cannot be empty");
                }else{
                    tConfirm.setError(null);
                }

                if (!confirm.equals(pass)){
                    tConfirm.setError("Password doesn't match");
                }else if(!email.isEmpty() && !fullname.isEmpty() && !pass.isEmpty()){
                    startActivity(signup);
                }else{
                    Toast.makeText(getApplicationContext(),"Form cannot be empty",Toast.LENGTH_SHORT).show();
                }
            }
        });

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(), LoginSignup.class);
                startActivity(back);
            }
        });

    }
}
