package com.example.fixengine.services;

import android.util.Log;

import com.example.fixengine.model.TradeDetails;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RestSignupLoginService {

    private RetrofitRestClient retrofitRestClient;
    private ISignupLoginServiceAPI iSignupLoginServiceAPI;

    public RestSignupLoginService() {
        retrofitRestClient = new RetrofitRestClient();
        Retrofit retrofit = retrofitRestClient.getRetrofitRestClient();
        iSignupLoginServiceAPI = retrofit.create(ISignupLoginServiceAPI.class);
    }

    public void signup(TradeDetails tradeDetails) {
        Call<TradeDetails> tradeDetailsCall = iSignupLoginServiceAPI.signup(tradeDetails);

        tradeDetailsCall.enqueue( new Callback<TradeDetails>() {
            @Override
            public void onResponse(Call<TradeDetails> call, Response<TradeDetails> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Failed to Register with message :" + response.message() +
                            " Code : " + response.code());
                    return;
                }
                String  msg = "Request Body containing: " + response.body();
                Log.println( Log.INFO, "signup", msg );
            }

            @Override
            public void onFailure(Call<TradeDetails> call, Throwable t) {
                System.out.println("Failed to Register with exception :" + t.getMessage());
            }
        } );
    }
}
