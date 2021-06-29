package com.example.fixengine.services;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRestClient {

    private Retrofit retrofitForTrade;
    private Retrofit retrofitForBroker;

    public RetrofitRestClient() {
        retrofitForTrade = new Retrofit.Builder()
                .baseUrl( "http://192.168.0.94:8091/")
                .addConverterFactory( GsonConverterFactory.create())
                .build();

        retrofitForBroker = new Retrofit.Builder()
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
