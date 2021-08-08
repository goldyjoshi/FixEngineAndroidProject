package com.example.fixengine.services;

import org.junit.Assert;
import org.junit.Test;

import retrofit2.Retrofit;

public class RetrofitRestClientTest {

    @Test
    public void getRetrofitRestClientTest() {
        // Give
        RetrofitRestClient retrofitRestClient = new RetrofitRestClient();

        // When
        Retrofit retrofitClinetForTrader = retrofitRestClient.getRetrofitRestClient();

        // Then
        Assert.assertNotNull(retrofitClinetForTrader);
    }

    @Test
    public void getBrokerRetrofitRestClientTest() {
        // Give
        RetrofitRestClient retrofitRestClient = new RetrofitRestClient();

        // When
        Retrofit retrofitClinetForBroker = retrofitRestClient.getBrokerRetrofitRestClient();

        // Then
        Assert.assertNotNull(retrofitClinetForBroker);

    }
}
