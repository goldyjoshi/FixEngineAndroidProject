package com.example.fixengine.services;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRestClient {

    private Retrofit retrofitForTrade;
    private Retrofit retrofitForBroker;

    public RetrofitRestClient() {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(180, TimeUnit.SECONDS)
                .connectTimeout(180, TimeUnit.SECONDS)
                .build();

        retrofitForTrade = new Retrofit.Builder()
                .baseUrl( "http://192.168.0.94:8091/")
//        .baseUrl( "http://192.168.1.95:8091/")

                .addConverterFactory( GsonConverterFactory.create())
                .client( okHttpClient )
                .build();

        retrofitForBroker = new Retrofit.Builder()
//                .baseUrl( "http://192.168.0.8:8092/")
                .baseUrl( "http://192.168.0.94:8092/")
                .addConverterFactory( GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofitRestClient() {
         return retrofitForTrade;
    }

    public Retrofit getBrokerRetrofitRestClient() {
        return retrofitForBroker;
    }
}
