package com.rogerferdinan.filmajah.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rogerferdinan.filmajah.model.ApiResponse;
import com.rogerferdinan.filmajah.model.Signup;
import com.rogerferdinan.filmajah.model.retrofit.APIClient;
import com.rogerferdinan.filmajah.model.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupVM extends ViewModel {
    ApiService apiService = new APIClient().getInstance();
    MutableLiveData<ApiResponse> apiResponse= new MutableLiveData<>();
    public LiveData<ApiResponse> signup(String email, String first_name, String last_name, String password) {
        Call<ApiResponse> call = apiService.signUpAccount(new Signup(email, first_name, last_name, password));
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if(response.isSuccessful()) {
                    apiResponse.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {  }
        });
        return apiResponse;
    }
}
