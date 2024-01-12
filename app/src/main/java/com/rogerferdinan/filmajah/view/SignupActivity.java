package com.rogerferdinan.filmajah.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.rogerferdinan.filmajah.R;
import com.rogerferdinan.filmajah.viewmodel.SignupVM;

import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {
    private TextInputLayout tEmail;
    private TextInputLayout tFirstName;
    private TextInputLayout tLastName;
    private TextInputLayout tPass;
    private TextInputLayout tConfirm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        SignupVM signupVM = new SignupVM();
        tEmail = findViewById(R.id.etEmailAddress);
        tFirstName = findViewById(R.id.etFirstName);
        tLastName = findViewById(R.id.etLastName);
        tPass = findViewById(R.id.etPass);
        tConfirm = findViewById(R.id.etConfirmPass);
        Button btnSignup = findViewById(R.id.btnSignUp);
        ImageButton btnBack = findViewById(R.id.ibBackButton_su);
        tEmail.getEditText().setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                tEmail.setError(null);
            }
            return false;
        });
        tFirstName.getEditText().setOnKeyListener((v, keyCode, event) -> {
            if(event.getAction() == KeyEvent.ACTION_DOWN) {
                tFirstName.setError(null);
            }
            return false;
        });

        tLastName.getEditText().setOnKeyListener((v, keyCode, event) -> {
            if(event.getAction() == KeyEvent.ACTION_DOWN) {
                tLastName.setError(null);
            }
            return false;
        });

        tPass.getEditText().setOnKeyListener((v, keyCode, event) -> {
            if(event.getAction() == KeyEvent.ACTION_DOWN){
                tPass.setError(null);
            }
            return false;
        });

        tConfirm.getEditText().setOnKeyListener((v, keyCode, event) -> {
            if(event.getAction() == KeyEvent.ACTION_DOWN){
                tConfirm.setError(null);
            }
            return false;
        });

        btnSignup.setOnClickListener(v -> {
            String email = tEmail.getEditText().getText().toString();
            String first_name = tFirstName.getEditText().getText().toString();
            String last_name = tLastName.getEditText().getText().toString();
            String pass = tPass.getEditText().getText().toString();
            String confirm = tConfirm.getEditText().getText().toString();

            if(email.isEmpty()){
                tEmail.setError("Cannot be empty");
            }else if(!Pattern.matches(".+@.+\\..+", email)) {
                tEmail.setError("Format should be valid");
            } else {
                tEmail.setError(null);
            }

            if(first_name.isEmpty()){
                tFirstName.setError("Cannot be empty");
            }else {
                tFirstName.setError(null);
            }
            if(last_name.isEmpty()) {
                tLastName.setError("Cannot be empty");
            } else {
                tLastName.setError(null);
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

            if(!confirm.equals(pass)) {
                tConfirm.setError("Password doesn't match");
            }else if(!email.isEmpty() &&
                    !first_name.isEmpty() &&
                    !last_name.isEmpty() &&
                    !pass.isEmpty()) {
                signupVM.signup(email, first_name, last_name, pass)
                        .observe(SignupActivity.this, apiResponse -> {
                            if(apiResponse.success) {
                               Intent signup = new Intent(getApplicationContext(), LoginActivity.class);
                               signup.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                               startActivity(signup);
                           }
                        });
            }else {
                Toast.makeText(getApplicationContext(),"Form cannot be empty",Toast.LENGTH_SHORT).show();
            }
        });
        btnBack.setOnClickListener(v -> {
            finish();
        });
    }
}
