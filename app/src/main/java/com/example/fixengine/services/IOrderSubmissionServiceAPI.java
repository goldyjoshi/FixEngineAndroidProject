package com.example.fixengine.services;

import com.example.fixengine.model.SingleOrderRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/***
 * This interface is used to post order to submit..
 *
 */
public interface IOrderSubmissionServiceAPI {

    /***
     * This is post method to send execution to java middleware app rest.
     * @param singleOrderRequest to store order details
     * @return
     */
    @POST("submit_order")
    Call<Boolean> submitOrder(@Body SingleOrderRequest singleOrderRequest);

    /***
     * This is post method to send execution to java middleware app rest.
     * @return
     */
    @GET("orders")
    Call<List<SingleOrderRequest>> getOrders();

}
