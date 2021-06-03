package com.example.fixengine.services;

import com.example.fixengine.Trade;
import com.example.fixengine.model.TradeDetails;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ISignupLoginServiceAPI {

    @POST("signup")
    Call<TradeDetails> signup(@Body TradeDetails tradeDetails);
}
