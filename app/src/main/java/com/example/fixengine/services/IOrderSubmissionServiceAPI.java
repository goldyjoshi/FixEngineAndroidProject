package com.example.fixengine.services;

import com.example.fixengine.model.SingleOrderRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IOrderSubmissionServiceAPI {

    @POST("submit_order")
    Call<Boolean> submitOrder(@Body SingleOrderRequest singleOrderRequest);

    @GET("orders")
    Call<List<SingleOrderRequest>> getOrders();

}
