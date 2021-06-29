package com.example.fixengine.services;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fixengine.R;
import com.example.fixengine.model.OrderStatusAdaptor;
import com.example.fixengine.model.SingleOrderRequest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OrderService {

    private RetrofitRestClient retrofitRestClient;
    private IOrderSubmissionServiceAPI iOrderSubmissionServiceAPI;

    public OrderService() {
        retrofitRestClient = new RetrofitRestClient();
        Retrofit retrofit = retrofitRestClient.getRetrofitRestClient();
        iOrderSubmissionServiceAPI = retrofit.create(IOrderSubmissionServiceAPI.class);

    }

    public void setOrders(Context context, RecyclerView recyclerView, OrderStatusAdaptor orderStatusAdaptor) {
        Call<List<SingleOrderRequest>> orderListCall = iOrderSubmissionServiceAPI.getOrders();
        orderListCall.enqueue( new Callback<List<SingleOrderRequest>>() {
            @Override
            public void onResponse(Call<List<SingleOrderRequest>> call, Response<List<SingleOrderRequest>> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Failed to get order list :" +response.message() + "Code :"
                            + response.code());
                    return;
                }
               List<SingleOrderRequest> orderRequestList = orderStatusAdaptor.getCurrrentOrderList();
                List<SingleOrderRequest> allOrderList = orderStatusAdaptor.getFullOrderList();
                for (SingleOrderRequest orderRequest : response.body()){
                    orderRequestList.add(orderRequest);
                    allOrderList.add( orderRequest );
                }
                recyclerView.setAdapter(orderStatusAdaptor);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                orderStatusAdaptor.notifyDataSetChanged();
                String message = "Request Body conatining: " + response.body();
                Log.println( Log.INFO, "order status", message);
            }

            @Override
            public void onFailure(Call<List<SingleOrderRequest>> call, Throwable t) {
                String message = "Failed to call orders rest api " + t.getMessage();
                Log.println( Log.INFO, "order status", message);
            }
        } );

    }

    public void submitOrder(SingleOrderRequest singleOrderRequest) {
        Call<SingleOrderRequest> singleOrderRequestCall = iOrderSubmissionServiceAPI.submitOrder
                (singleOrderRequest);
        singleOrderRequestCall.enqueue( new Callback<SingleOrderRequest>() {
            @Override
            public void onResponse(Call<SingleOrderRequest> call, Response<SingleOrderRequest>
                    response) {
                if (!response.isSuccessful()) {
                    System.out.println("Failed to submit order :" +response.message() + "Code :"
                            + response.code());
                return;
                }
                String message = "Request Body conatining: " +response.body();
                Log.println( Log.INFO, "submitorder", message);
            }

            @Override
            public void onFailure(Call<SingleOrderRequest> call, Throwable t) {
                System.out.println("Failed to register with exception : " + t.getMessage());

            }
        } );
    }

}
