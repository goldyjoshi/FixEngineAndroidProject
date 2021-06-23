package com.example.fixengine.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SymbolService {
    private RetrofitRestClient retrofitRestClient;
    private ISymbolServiceAPI iSymbolServiceAPI;

    public SymbolService() {
        retrofitRestClient = new RetrofitRestClient();
        Retrofit retrofitBuilder =  retrofitRestClient.getRetrofitRestClient();
        iSymbolServiceAPI = retrofitBuilder.create( ISymbolServiceAPI.class);
    }

    public void addSymbol(List<String> symbolList) {
        Call<List<String>> symbolCall = iSymbolServiceAPI.getSymbols();
        symbolCall.enqueue( new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if(!response.isSuccessful()) {
                    System.out.println("Failed to get the symbol.");
                    return;
                }
                for(String symbol : response.body()) {
                    symbolList.add( symbol );
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                System.out.println("Fail to execute symbol request.");

            }
        } );
    }
}
