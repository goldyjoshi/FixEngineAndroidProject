package com.example.fixengine.services;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fixengine.OrderStatusActivity;
import com.example.fixengine.R;
import com.example.fixengine.SubmitOrderActivity;
import com.example.fixengine.TradeOptionStatusPortofolioActivity;
import com.example.fixengine.model.OrderStatusAdaptor;
import com.example.fixengine.model.SingleOrderRequest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/***
 * This class will represent order service of executed order.
 */
public class OrderService {

    private RetrofitRestClient retrofitRestClient;
    private IOrderSubmissionServiceAPI iOrderSubmissionServiceAPI;

    /***
     * Constructor to initialize instance of class RetrofitRestClient and IOrderSubmissionServiceAPI
     */
    public OrderService() {
        retrofitRestClient = new RetrofitRestClient();
        Retrofit retrofit = retrofitRestClient.getRetrofitRestClient();
        iOrderSubmissionServiceAPI = retrofit.create(IOrderSubmissionServiceAPI.class);

    }

    /***
     * This method is used to set all order in recycler view and order status adaptor and
     * override onResponse if success and onFailure
     *  when execution failed.
     * @param context to set in which contet method is called
     * @param recyclerView of type Recycler view to set orders
     * @param orderStatusAdaptor type of adaptor to store order.
     */
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

    /***
     * This methos is used to submit  single order and override onResponse method
     * success if execution success and onFailure when execution failed.
     * @param singleOrderRequest unique representation of single order request
     * @param context to store the context of method
     * @param loginRole to store the role of user(trader/Broker)
     */
    public void submitOrder(SingleOrderRequest singleOrderRequest, Context context, String loginRole) {
        Call<Boolean> singleOrderRequestCall = iOrderSubmissionServiceAPI.submitOrder
                (singleOrderRequest);
        singleOrderRequestCall.enqueue( new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean>
                    response) {
                if (!response.isSuccessful()) {
                    System.out.println("Failed to submit order :" + singleOrderRequest.toString() + "Code :"
                            + response.code());
                    Toast.makeText( context, "Order Submission has been failed.", Toast.LENGTH_SHORT).show();
                    return;
                }
                String message = "Request Body containing: " + singleOrderRequest.toString();
                Log.println( Log.INFO, "submit order", message);
                Toast.makeText(context, "Order has been submitted successfully.", Toast.LENGTH_SHORT).show();
                Intent newOrderStatusActivity = new Intent( context, OrderStatusActivity.class );
                newOrderStatusActivity.putExtra( "role", loginRole );
                context.startActivity(newOrderStatusActivity);

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                System.out.println("Failed to register with exception : " + t.getMessage());
                Toast.makeText( context, "Request to submit order has been failed.", Toast.LENGTH_SHORT).show();
            }
        } );
    }

}
