package com.rogerferdinan.filmajah.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Movie {
    @SerializedName("movie_name")
    public String name;
    public Float rating;
    @SerializedName("img_url")
    public String image_url;
}
