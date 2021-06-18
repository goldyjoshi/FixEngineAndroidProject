package com.example.fixengine.services;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRestClient {

    private Retrofit retrofit;

    public RetrofitRestClient() {
        retrofit = retrofit = new Retrofit.Builder()
                .baseUrl( "http://192.168.0.94:8091/")
                .addConverterFactory( GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofitRestClient() {
         return retrofit;
    }
}
