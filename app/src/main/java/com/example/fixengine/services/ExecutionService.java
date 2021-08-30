package com.example.fixengine.services;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.fixengine.OrderStatusActivity;
import com.example.fixengine.model.ExecutionRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/***
 * This class will represent execution service report using RetrofitRestClient variable,
 * IExecutionServiceAPI variable
 * @author vijayshreejoshi
 */
public class ExecutionService {

    private RetrofitRestClient retrofitRestClient; //variable  to create the new variable  of RetrofitRestClient
    private IExecutionServiceAPI iExecutionServiceAPI; //variable  to create the new variable of iExecutionServiceAPI

    /***
     * Constructor to create new instances of ExecutionService and its field retrofitRestClient,
     * retrofit, iExecutionServiceAPI
     */
    public ExecutionService() {
        retrofitRestClient = new RetrofitRestClient();
        Retrofit retrofit = retrofitRestClient.getBrokerRetrofitRestClient();
        iExecutionServiceAPI = retrofit.create(IExecutionServiceAPI.class);
    }

    /***
     * This method is used to send execution  and override onResponse if success and onFailure
     * when execution failed.
     * @param executionRequest variable to store execution request.
     */
    public void sendExecution(ExecutionRequest executionRequest, Context context, String messageToDisplay) {
        Call<Boolean> executionRequestCall = iExecutionServiceAPI.sendExecution(executionRequest);
        executionRequestCall.enqueue( new Callback<Boolean>() {

            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Failed while sending execution :" +response.message() + "Code :"
                            + response.code());
                    return;
                }
                String message = "Request Body containing: " + response.body();
                Log.println( Log.INFO, "execution", message);
                Toast.makeText( context, messageToDisplay, Toast.LENGTH_SHORT ).show();
                Intent orderStatusIntent = new Intent( context, OrderStatusActivity.class );
                orderStatusIntent.putExtra( "role", "Broker" );
                context.startActivity( orderStatusIntent );
            }
            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                String failureMessage = "Failed to send exception : " + t.getMessage();
                Log.println( Log.INFO, "execution",  failureMessage);
                Toast.makeText( context, "Order execution has been failed.", Toast.LENGTH_SHORT ).show();
            }
        } );
    }

}
