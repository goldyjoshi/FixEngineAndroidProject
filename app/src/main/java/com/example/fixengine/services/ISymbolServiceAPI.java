package com.example.fixengine.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ISymbolServiceAPI {

    @GET("symbols")
    Call<List<String>> getSymbols();
}
