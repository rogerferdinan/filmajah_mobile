package com.rogerferdinan.filmajah.model.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://filmajah.rogerferdinan.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public ApiService getApi() {
        return retrofit.create(ApiService.class);
    }
}
