package com.example.fixengine.services;

import android.content.Context;
import android.widget.Toast;

import com.example.fixengine.ITradeJsonInterfaceAPI;
import com.example.fixengine.MainActivityPage;
import com.example.fixengine.Trade;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//not in use this class
public class RestTradeService {

    private String tradesAsString = "";
    private String submitStatus = "";

    private ITradeJsonInterfaceAPI retrofitImplementation() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( "http://192.168.0.94:8091/")
                .addConverterFactory( GsonConverterFactory.create()).build();
        ITradeJsonInterfaceAPI iTradeJsonInterfaceAPI = retrofit.create((ITradeJsonInterfaceAPI.class));
        return iTradeJsonInterfaceAPI;
    }

    public String submitTrade() {
        ITradeJsonInterfaceAPI iTradeJsonInterfaceAPI = retrofitImplementation();
        Trade tradeToSubmit = new Trade("TA2", "AC1", 20L, "FB");
        Call<Trade> tradeSubmitCall = iTradeJsonInterfaceAPI.submitTrade(tradeToSubmit);

        tradeSubmitCall.enqueue( new Callback<Trade>() {
            @Override
            public void onResponse(Call<Trade> call, Response<Trade> response) {
                if (!response.isSuccessful()) {
                    System.out.println(" Unsuccessfull to submit trade! " + response.message());
                    return;
                }
                 submitStatus = "Trade has been submited successfully " + response.body();
                System.out.println(submitStatus);
            }

            @Override
            public void onFailure(Call<Trade> call, Throwable t) {
                System.out.println(" Unsuccessfull to submit trade! " + t.getMessage());
            }
        } );
        return submitStatus;
    }

    public String getTradeService() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl( "http://192.168.0.94:8091/")
//                .addConverterFactory( GsonConverterFactory.create()).build();
//        ITradeJsonInterfaceAPI iTradeJsonInterfaceAPI = retrofit.create((ITradeJsonInterfaceAPI.class));
        ITradeJsonInterfaceAPI iTradeJsonInterfaceAPI = retrofitImplementation();

        Call<List<Trade>> tradeCall = iTradeJsonInterfaceAPI.getTrades();

        tradeCall.enqueue( new Callback<List<Trade>>() {
            @Override
            public void onResponse(Call<List<Trade>> call, Response<List<Trade>> response) {
                if (response.isSuccessful()) {
                    System.out.println("Trade detilas has been retrived succesfully ");
                    List<Trade> trades = response.body();
                    System.out.println(response.body());
                    String tradeDeatails = "";

                    for (Trade trade : trades) {
                        tradeDeatails = tradeDeatails + trade;
                    }
                    tradesAsString = tradeDeatails.toString();
                }
            }

            @Override
            public void onFailure(Call<List<Trade>> call, Throwable t) {
                System.out.println("Fail to call trade : "+t);

            }
        } );
        return tradesAsString;
    }

}
