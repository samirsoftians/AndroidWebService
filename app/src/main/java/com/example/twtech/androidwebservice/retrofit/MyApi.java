package com.example.twtech.androidwebservice.retrofit;

import android.telecom.Call;

import java.util.List;

import retrofit2.http.GET;
import java.util.List;


import retrofit2.http.GET;

public interface MyApi {

    String BASEURL="https://simplifiedcoding.net/demos/";

   @GET("marvel")

   retrofit2.Call<List<Hero>> getHeroes();
}
