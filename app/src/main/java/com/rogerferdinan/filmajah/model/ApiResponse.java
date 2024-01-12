package com.rogerferdinan.filmajah.model;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    @SerializedName("is_success")
    public Boolean success;
    public String message;
}
