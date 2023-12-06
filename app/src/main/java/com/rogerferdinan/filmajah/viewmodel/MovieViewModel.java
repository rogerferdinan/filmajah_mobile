package com.rogerferdinan.filmajah.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rogerferdinan.filmajah.model.Movie;
import com.rogerferdinan.filmajah.model.retrofit.APIClient;
import com.rogerferdinan.filmajah.model.retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {
    ApiService apiService = new APIClient().getApi();
    MutableLiveData<List<Movie>> movieList = new MutableLiveData<>();

    public LiveData<List<Movie>> getMovieList() {
        Call<List<Movie>> call = apiService.getMovieList();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.isSuccessful()) {
                    movieList.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
            }
        });
        return movieList;
    }
}
