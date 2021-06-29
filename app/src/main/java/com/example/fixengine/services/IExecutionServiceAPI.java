package com.example.fixengine.services;

import com.example.fixengine.model.ExecutionRequest;
import com.example.fixengine.model.SingleOrderRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IExecutionServiceAPI {

    @POST("execution")
    Call<ExecutionRequest> sendExecution(@Body ExecutionRequest executionRequest);
}
