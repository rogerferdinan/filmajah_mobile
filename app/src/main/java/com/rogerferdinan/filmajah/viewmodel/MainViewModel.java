package com.rogerferdinan.filmajah.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rogerferdinan.filmajah.model.ApiResponse;
import com.rogerferdinan.filmajah.model.CollectionBody;
import com.rogerferdinan.filmajah.model.LoginBody;
import com.rogerferdinan.filmajah.model.Movie;
import com.rogerferdinan.filmajah.model.Movie;
import com.rogerferdinan.filmajah.model.MovieInfo;
import com.rogerferdinan.filmajah.model.MovieInfoBody;
import com.rogerferdinan.filmajah.model.Profile;
import com.rogerferdinan.filmajah.model.retrofit.APIClient;
import com.rogerferdinan.filmajah.model.retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    ApiService apiService = APIClient.getInstance();
    public LoginBody user = new LoginBody("", "");
    MutableLiveData<List<Movie>> recommendation_list = new MutableLiveData<>();
    MutableLiveData<List<Movie>> trending_list = new MutableLiveData<>();
    MutableLiveData<List<Movie>> movieList = new MutableLiveData<>();
    MutableLiveData<Boolean> add_collection_status = new MutableLiveData<>();
    MutableLiveData<Profile> profileLiveData = new MutableLiveData<>();
    MutableLiveData<MovieInfo> movie_info = new MutableLiveData<>();
    public LiveData<List<Movie>> getRecommendation() {
        Call<List<Movie>> call = apiService.getRecommendation();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.isSuccessful()) {
                    recommendation_list.postValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.d("AAA", t.getMessage().toString());
            }
        });
        return recommendation_list;
    }
    public LiveData<List<Movie>> getTrending() {
        Call<List<Movie>> call = apiService.getTrending();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.isSuccessful()) {
                    trending_list.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.d("AAA", t.getMessage().toString());
            }
        });
        return trending_list;
    }
    public LiveData<List<Movie>> getCollection() {
        Call<List<Movie>> call = apiService.getCollection(new LoginBody(user.email, user.password));
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.isSuccessful()) {
                    movieList.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.d("AAA", t.getMessage().toString());
            }
        });
        return movieList;
    }

    public LiveData<Boolean> addCollection(String movie_name) {
        Call<ApiResponse> call = apiService.addCollection(new CollectionBody(user.email, user.password, movie_name));
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if(response.isSuccessful()) {
                    add_collection_status.setValue(response.body().success);
                    Log.d("AAA",response.body().message.toString());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.d("AAA", t.getMessage().toString());
            }
        });
        return add_collection_status;
    }
    public LiveData<Profile> getProfile(String email, String password) {
        Call<Profile> call = apiService.getProfileAccount(new LoginBody(email, password));
        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if(response.isSuccessful()) {
                    profileLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

            }
        });
        return profileLiveData;
    }

    public LiveData<MovieInfo> getMovieInfo(String movie_name, String email) {
        apiService.getMovieInfo(new MovieInfoBody(movie_name, email)).enqueue(new Callback<MovieInfo>() {
            @Override
            public void onResponse(Call<MovieInfo> call, Response<MovieInfo> response) {
                if(response.isSuccessful()) {
                    Log.d("AAA", response.body().image_url);
                    movie_info.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<MovieInfo> call, Throwable t) {

            }
        });
        return movie_info;
    }
}
