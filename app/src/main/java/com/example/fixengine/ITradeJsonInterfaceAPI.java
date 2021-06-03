package com.example.fixengine;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ITradeJsonInterfaceAPI {
    @GET("trades")
    Call<List<Trade>> getTrades();

    @POST("submit")
    Call<Trade> submitTrade(@Body Trade trade);
}
