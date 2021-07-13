package com.example.fixengine.services;

import com.example.fixengine.model.SingleOrderRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/***
 * This interface used to implements abstraction of clients list.
 */
public interface IClientAccountServiceAPI {

    /***
     * This method is used to  get client list
     * @return list of client
     */
    @GET("clients")
    Call<List<String>> getClients();
}
