package com.example.fixengine.services;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.fixengine.MainActivityPage;
import com.example.fixengine.SignupActivity;
import com.example.fixengine.TradeOptionStatusPortofolioActivity;
import com.example.fixengine.model.DataUtility;
import com.example.fixengine.model.TradeDetails;
import com.example.fixengine.model.TraderLoginDetails;

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

    public void signup(TradeDetails tradeDetails, Context context) {
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
                Toast.makeText( context, "You have successfully signup.", Toast.LENGTH_SHORT ).show();
                Intent intentLoginScreen = new Intent(context, MainActivityPage.class);
                context.startActivity(intentLoginScreen);
                Log.println( Log.INFO, "signup", msg );
            }

            @Override
            public void onFailure(Call<TradeDetails> call, Throwable t) {
                Toast.makeText( context, "Signup request has been failed. Please try again.", Toast.LENGTH_SHORT ).show();
                System.out.println("Failed to Register with exception :" + t.getMessage());
            }
        } );
    }


    /***..........***/

    public void login(final String  authHeaderValue, final Context context) {
        Call<TraderLoginDetails> traderLoginDetailsCall = iSignupLoginServiceAPI.login( authHeaderValue );
        traderLoginDetailsCall.enqueue( (new Callback<TraderLoginDetails>() {
            @Override
            public void onResponse(Call<TraderLoginDetails> call, Response<TraderLoginDetails> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Unsuccessful login with message :" + response.message() +
                            " Code : " + response.code());
                    return;
                }
                String  msg = "Request Body containing: " + response.body();
                if ("failed".equalsIgnoreCase(  response.body().getLoginStatus())) {
                    Toast.makeText( context,
                            "Login failed. One of the credential is not correct.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Intent loginIntent = new Intent( context, TradeOptionStatusPortofolioActivity.class );
                    loginIntent.putExtra( "role", response.body().getLoginRole() );
                    context.startActivity( loginIntent );
                }
                Log.println( Log.INFO, "login", msg );
            }

            @Override
            public void onFailure(Call<TraderLoginDetails> call, Throwable t) {
                System.out.println("Failed to login with exception :" + t.getMessage());
            }
        }) );
    }
}
