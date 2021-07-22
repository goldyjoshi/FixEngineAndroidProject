package com.example.fixengine.services;

import com.example.fixengine.model.ExecutionRequest;
import com.example.fixengine.model.SingleOrderRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/***
 * This interface is used to post the execution report.
 */
public interface IExecutionServiceAPI {

    /***
     *
     * @param executionRequest
     * @return
     */
    @POST("execution")
    Call<Boolean> sendExecution(@Body ExecutionRequest executionRequest);
}
