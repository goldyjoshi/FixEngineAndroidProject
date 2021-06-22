package com.example.fixengine.services;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.fixengine.R;
import com.example.fixengine.SubmitOrderActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ClientAccountService {

    private RetrofitRestClient retrofitRestClient;
    private IClientAccountServiceAPI iClientAccountServiceAPI;

    public ClientAccountService() {
        retrofitRestClient = new RetrofitRestClient();
        Retrofit retrofit = retrofitRestClient.getRetrofitRestClient();
        iClientAccountServiceAPI = retrofit.create( IClientAccountServiceAPI.class );
    }

    public void getClientAccountList(List<String> accountsList) {

        Call<List<String>> clientAccountRequestCall = iClientAccountServiceAPI.getClients();
        clientAccountRequestCall.enqueue( new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Failed to get clients :" +response.message() + "Code :"
                            + response.code());
                }
                String message = "Request Body conatining: " + response.body();
                Log.println( Log.INFO, "submitorder", message);
                for (String id : response.body()) {
                    accountsList.add( id );
                }

            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

                System.out.println("Failed to retrieve clients account with exception : " + t.getMessage());

            }
        } );
    }
}