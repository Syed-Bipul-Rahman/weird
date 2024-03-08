package com.example.santo.services.network;

import com.example.santo.services.models.WeiredResponse;

import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiService {

    //student list
    @GET("api/animals")
    Call<WeiredResponse> getanimals();



}