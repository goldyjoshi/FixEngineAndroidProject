package com.example.fixengine.services;

import android.util.Log;

import com.example.fixengine.model.SingleOrderRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OrderService {

    private RetrofitRestClient retrofitRestClient;
    private IOrderSubmissionServiceAPI iOrderSubmissionServiceAPI;

    public OrderService() {
        retrofitRestClient = new RetrofitRestClient();
        Retrofit retrofit = retrofitRestClient.getRetrofitRestClient();
        iOrderSubmissionServiceAPI = retrofit.create(IOrderSubmissionServiceAPI.class);

    }

    public void submitOrder(SingleOrderRequest singleOrderRequest) {
        Call<SingleOrderRequest> singleOrderRequestCall = iOrderSubmissionServiceAPI.submitOrder
                (singleOrderRequest);
        singleOrderRequestCall.enqueue( new Callback<SingleOrderRequest>() {
            @Override
            public void onResponse(Call<SingleOrderRequest> call, Response<SingleOrderRequest>
                    response) {
                if (!response.isSuccessful()) {
                    System.out.println("Failed to submit order :" +response.message() + "Code :"
                            + response.code());
                return;
                }
                String message = "Request Body conatining: " +response.body();
                Log.println( Log.INFO, "submitorder", message);
            }

            @Override
            public void onFailure(Call<SingleOrderRequest> call, Throwable t) {
                System.out.println("Failed to register with exception : " + t.getMessage());

            }
        } );
    }

}
