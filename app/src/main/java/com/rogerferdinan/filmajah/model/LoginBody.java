package com.rogerferdinan.filmajah.model;

public class LoginBody {
    public String email;
    public String password;
    public LoginBody(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
