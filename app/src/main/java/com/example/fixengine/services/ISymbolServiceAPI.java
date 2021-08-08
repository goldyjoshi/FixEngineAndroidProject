package com.example.fixengine.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/***
 * This interface is used to get the symbols.
 * @author vijayshreejoshi
 */
public interface ISymbolServiceAPI {

    @GET("symbols")
    Call<List<String>> getSymbols();
}
