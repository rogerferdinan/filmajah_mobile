package com.rogerferdinan.filmajah.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rogerferdinan.filmajah.model.Movie;
import com.rogerferdinan.filmajah.model.Query;
import com.rogerferdinan.filmajah.model.retrofit.APIClient;
import com.rogerferdinan.filmajah.model.retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchVM extends ViewModel {
    ApiService apiService = APIClient.getInstance();
    MutableLiveData<List<Movie>> movie_list = new MutableLiveData<>();
    public LiveData<List<Movie>> search_movie(String query) {
        apiService.searchMovie(new Query(query)).enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.isSuccessful()) {
                    Log.d("AAA", response.body().toString());
                    movie_list.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.d("AAA",t.toString());
            }
        });
        return movie_list;
    }
}
