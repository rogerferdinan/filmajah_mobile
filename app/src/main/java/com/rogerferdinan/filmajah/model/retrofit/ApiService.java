package com.rogerferdinan.filmajah.model.retrofit;

import com.google.gson.annotations.SerializedName;
import com.rogerferdinan.filmajah.model.ApiResponse;
import com.rogerferdinan.filmajah.model.CollectionBody;
import com.rogerferdinan.filmajah.model.LoginBody;
import com.rogerferdinan.filmajah.model.Movie;
import com.rogerferdinan.filmajah.model.MovieInfo;
import com.rogerferdinan.filmajah.model.MovieInfoBody;
import com.rogerferdinan.filmajah.model.Profile;
import com.rogerferdinan.filmajah.model.Query;
import com.rogerferdinan.filmajah.model.Signup;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("api/recommendation")
    Call<List<Movie>> getRecommendation();
    @GET("api/trending")
    Call<List<Movie>> getTrending();
    @POST("api/get_collection")
    Call<List<Movie>> getCollection(@Body LoginBody user);
    @POST("api/add_collection")
    Call<ApiResponse> addCollection(@Body CollectionBody collection);
    @POST("api/movie_info")
    Call<MovieInfo> getMovieInfo(@Body MovieInfoBody body);
    @POST("api/login")
    Call<ApiResponse> loginAccount(@Body LoginBody user);
    @POST("api/signup")
    Call<ApiResponse> signUpAccount(@Body Signup user);
    @POST("api/get_profile")
    Call<Profile> getProfileAccount(@Body LoginBody user);
    @POST("api/search_movie")
    Call<List<Movie>> searchMovie(@Body Query query);
}
