package com.example.fixengine.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/***
 * This interface used to implements abstraction of clients list.
 * @author vijayshreejoshi
 */
public interface IClientAccountServiceAPI {

    /***
     * This method is used to  get client list
     * @return list of client
     */
    @GET("clients")
    Call<List<String>> getClients();

}
