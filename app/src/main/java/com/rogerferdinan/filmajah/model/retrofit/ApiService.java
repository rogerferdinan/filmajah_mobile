package com.rogerferdinan.filmajah.model.retrofit;

import androidx.lifecycle.LiveData;

import com.rogerferdinan.filmajah.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("/")
    Call<List<Movie>> getMovieList();
}
