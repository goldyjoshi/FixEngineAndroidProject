package com.example.fixengine.services;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/***
 * This class represent generic rest client to call web services.
 * @author vijayshreejoshi
 */
public class RetrofitRestClient {

    private Retrofit retrofitForTrade;  // To connect to initiator middleware module.
    private Retrofit retrofitForBroker; // To connect to acceptor middleware module.

    /***
     * Constructor to prepare generic property of retrofit for web service call.
     */
    public RetrofitRestClient() {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(180, TimeUnit.SECONDS)
                .connectTimeout(180, TimeUnit.SECONDS)
                .build();

        retrofitForTrade = new Retrofit.Builder()
                .baseUrl( "http://192.168.0.94:8091/")
                .addConverterFactory( GsonConverterFactory.create())
                .client( okHttpClient )
                .build();

        retrofitForBroker = new Retrofit.Builder()
                .baseUrl( "http://192.168.0.8:8092/")
                .addConverterFactory( GsonConverterFactory.create())
                .build();
    }

    /***
     * This method is used to access value of retrofitForTrade.
     * @return Retrofit object for Trader.
     */
    public Retrofit getRetrofitRestClient() {
         return retrofitForTrade;
    }

    /***
     * This method is used to access value of retrofitForBroker.
     * @return Retrofit object for Broker.
     */
    public Retrofit getBrokerRetrofitRestClient() {
        return retrofitForBroker;
    }

}
