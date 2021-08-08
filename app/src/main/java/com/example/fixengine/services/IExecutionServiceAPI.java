package com.example.fixengine.services;

import com.example.fixengine.model.ExecutionRequest;
import com.example.fixengine.model.SingleOrderRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/***
 * This interface is used to post the execution report.
 * @author vijayshreejoshi
 */
public interface IExecutionServiceAPI {

    /***
     * This is post method to send execution to java middleware app rest.
     * @param executionRequest of type ExecutionRequest.
     * @return
     */
    @POST("execution")
    Call<Boolean> sendExecution(@Body ExecutionRequest executionRequest);
}
