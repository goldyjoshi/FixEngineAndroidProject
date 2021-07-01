package com.example.fixengine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fixengine.model.ExecutionRequest;
import com.example.fixengine.model.SingleOrderRequest;
import com.example.fixengine.services.ExecutionService;

public class OrderExecutionActivity extends AppCompatActivity {

    private SingleOrderRequest singleOrderRequest;
    private ExecutionService executionService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_order_execution );
        SingleOrderRequest orderRequest = getIntent().getParcelableExtra( "order" );
        Log.println( Log.INFO, "execution", " Recived order is" + orderRequest.toString() );
        executionService = new ExecutionService();
        setOrderDataOnActivity(orderRequest);
        setActionOnAcceptOrder();
    }

    private void setOrderDataOnActivity(SingleOrderRequest singleOrderRequest) {
        this.singleOrderRequest = singleOrderRequest;
        TextView orderId = findViewById( R.id.execOrderIdTextView );
        TextView status = findViewById( R.id.execStatusTextView );
        TextView accountId = findViewById( R.id.execAccountIdTextView );
        TextView symbol = findViewById( R.id.execSymbolSideTextView );
        TextView totalQtyId = findViewById( R.id.totalOrderQtyTextView );
        TextView execQtyId = findViewById( R.id.execOrderQtyTextView);
        orderId.setText("Id : " + singleOrderRequest.getOrderId());
        status.setText("Status : " + singleOrderRequest.getStatus());
        accountId.setText("Account Id : " + singleOrderRequest.getAccountId());
        symbol.setText(singleOrderRequest.getSide() + "    " + singleOrderRequest.getSymbol() );
        totalQtyId.setText( "Total Quantity : " + String.valueOf( singleOrderRequest.getQuantity()) );
        execQtyId.setText( "Executed Quantity : " + singleOrderRequest.getExecutedQuantity() );
    }

    private void setActionOnAcceptOrder() {
        Button acceptButton = findViewById(R.id.AcceptOrder);
        acceptButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (singleOrderRequest != null) {
                    ExecutionRequest executionRequest = new ExecutionRequest();
                    setExecutionDataFromOrder(executionRequest);
                    executionRequest.setExecType( "new" );
                    executionService.sendExecution( executionRequest );
                }
            }
        } );
    }

    private void setExecutionDataFromOrder(ExecutionRequest executionRequest) {
        executionRequest.setOrderId( singleOrderRequest.getOrderId() );
        executionRequest.setAccountId( singleOrderRequest.getAccountId() );
        executionRequest.setSide( singleOrderRequest.getSide() );
        executionRequest.setSymbol( singleOrderRequest.getSymbol() );
        executionRequest.setTotalQuantity( singleOrderRequest.getQuantity() );
    }

}