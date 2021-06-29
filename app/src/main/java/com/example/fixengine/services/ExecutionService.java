package com.example.fixengine.services;

import android.util.Log;

import com.example.fixengine.model.ExecutionRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ExecutionService {

    private RetrofitRestClient retrofitRestClient;
    private IExecutionServiceAPI iExecutionServiceAPI;

    public ExecutionService() {
        retrofitRestClient = new RetrofitRestClient();
        Retrofit retrofit = retrofitRestClient.getBrokerRetrofitRestClient();
        iExecutionServiceAPI = retrofit.create(IExecutionServiceAPI.class);
    }

    public void sendExecution(ExecutionRequest executionRequest) {
        Call<ExecutionRequest> executionRequestCall = iExecutionServiceAPI.sendExecution(executionRequest);
        executionRequestCall.enqueue( new Callback<ExecutionRequest>() {

            @Override
            public void onResponse(Call<ExecutionRequest> call, Response<ExecutionRequest> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Failed while sending execution :" +response.message() + "Code :"
                            + response.code());
                    return;
                }
                String message = "Request Body conatining: " + response.body();
                Log.println( Log.INFO, "execution", message);
            }

            @Override
            public void onFailure(Call<ExecutionRequest> call, Throwable t) {
                String failureMessage = "Failed to send exception : " + t.getMessage();
                Log.println( Log.INFO, "execution",  failureMessage);
            }
        } );
    }
}
