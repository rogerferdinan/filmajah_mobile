package com.rogerferdinan.filmajah.model.retrofit;

import static androidx.core.content.res.TypedArrayUtils.getString;

import com.rogerferdinan.filmajah.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static ApiService retrofit = null;
    public static String BASE_URL = "https://filmajah.rogerferdinan.com";
    public static ApiService getInstance() {
        if(retrofit != null) return retrofit;
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
        return retrofit;
    }
}
