package com.rogerferdinan.filmajah.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieInfo {
    public String movie_name;
    public Integer length;
    public Integer release_year;
    public String producer_name;
    public Float rating;
    public String synopsis;
    public ArrayList<String> genres;
    public ArrayList<String> casts;
    public String image_url;
    public Boolean add_collection;
}
