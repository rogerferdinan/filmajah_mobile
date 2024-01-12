package com.rogerferdinan.filmajah.model;

public class Signup extends Profile {
    String password;

    public Signup(String email, String first_name, String last_name, String password) {
        super(email, first_name, last_name);
        this.password = password;
    }
}
