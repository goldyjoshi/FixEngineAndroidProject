package com.example.fixengine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fixengine.model.ExecutionRequest;
import com.example.fixengine.model.SingleOrderRequest;
import com.example.fixengine.services.ExecutionService;

/***
 * This class is represent an order execution functionality.
 */
public class OrderExecutionActivity extends AppCompatActivity {

    private SingleOrderRequest singleOrderRequest; //Variable to store the single order request
    private ExecutionService executionService; // Variable to store the object of ExecutionService
    EditText execQuantityEditText;// Variable to store the edited quantity of executed order
    EditText execPriceEditText; //Variable to store the edited price of executed order
    Button acceptButton; //Variable of type Button to click on and can accept an order
    Button executeOrderButton; //Variable of type Button to click on and can execute an order

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_order_execution );
        SingleOrderRequest orderRequest = getIntent().getParcelableExtra( "order" );
        Log.println( Log.INFO, "execution", " Recived order is" + orderRequest.toString() );
        execQuantityEditText = findViewById( R.id.execQuantityEditText );
        execPriceEditText = findViewById( R.id.execPriceEditText );
        acceptButton = findViewById(R.id.AcceptOrder);
        executeOrderButton = findViewById(R.id.ExecuteOrder);
        executionService = new ExecutionService();
        setOrderDataOnActivity(orderRequest);
        if ("Order Pending for Execution".equalsIgnoreCase( orderRequest.getStatus() ) ||
                "Sent for Execution".equalsIgnoreCase( orderRequest.getStatus() ) ||
         "Created".equalsIgnoreCase(orderRequest.getStatus())) {
            acceptButton.setBackgroundColor(Color.parseColor("#3949AB"));
            acceptButton.setEnabled( true );
            executeOrderButton.setBackgroundColor( Color.GRAY);
            executeOrderButton.setEnabled( false );
            execQuantityEditText.setVisibility(View.INVISIBLE  );
            execPriceEditText.setVisibility( View.INVISIBLE );
        } else {
            acceptButton.setBackgroundColor(Color.GRAY);
            acceptButton.setEnabled( false );
            executeOrderButton.setBackgroundColor(Color.parseColor("#3949AB"));
            executeOrderButton.setEnabled( true );
            execQuantityEditText.setVisibility(View.VISIBLE  );
            execPriceEditText.setVisibility( View.VISIBLE );
        }
        setActionOnAcceptOrder();
        setActionOnExecuteOrder();
    }

    /***
     * This method is used to set value of SingleOrderRequest variables which filled by user on UI
     * @param singleOrderRequest variable to store data of type SingleOrderRequest
     */
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
        acceptButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (singleOrderRequest != null) {
                    ExecutionRequest executionRequest = new ExecutionRequest();
                    setExecutionDataFromOrder(executionRequest);
                    executionRequest.setExecType( "New" );
                    executionRequest.setQuantityRequestedForExec( 0.0 );
                    executionRequest.setExecutionPrice( 0.0 );
                    executionService.sendExecution( executionRequest,
                            OrderExecutionActivity.this,
                            "Order has been accepted successfully." );
                }
            }
        } );
    }

    private void setActionOnExecuteOrder() {
        executeOrderButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (singleOrderRequest != null) {
                    ExecutionRequest executionRequest = new ExecutionRequest();
                    setExecutionDataFromOrder(executionRequest);
                    double quantityExecuted = 0.0;
                    double priceForExecution = 0.0;
                    try {
                        quantityExecuted = Double.valueOf(execQuantityEditText.getText().toString());
                        executionRequest.setQuantityRequestedForExec( quantityExecuted );
                        priceForExecution = Double.valueOf(execPriceEditText.getText().toString());
                        executionRequest.setExecutionPrice( priceForExecution );
                    } catch (NumberFormatException numberFormatException) {
                        Log.println( Log.ERROR, "formate", "Failed to retrieve quantity or price." );
                    }

                    String execType = "Partial";
                    if (quantityExecuted == executionRequest.getTotalQuantity()) {
                        execType = "Full";
                    }
                    executionRequest.setExecType(execType);
                    double totalExecQuantity = quantityExecuted + executionRequest.getPreviousExecQuantity();
                    double orderQtantity = singleOrderRequest.getQuantity();
                    if (quantityExecuted == 0.0) {
                        Toast.makeText( OrderExecutionActivity.this,
                                "Please Enter valid quantity for execution.", Toast.LENGTH_LONG).show();
                    } else if (priceForExecution == 0.0) {
                        Toast.makeText( OrderExecutionActivity.this,
                                "Please Enter valid price for execution.", Toast.LENGTH_LONG).show();
                    } else if (totalExecQuantity > orderQtantity) {
                        Toast.makeText( OrderExecutionActivity.this,
                                "Please Enter valid quantity for execution.", Toast.LENGTH_LONG).show();
                    } else {
                        executionService.sendExecution( executionRequest,
                                OrderExecutionActivity.this,
                                "Order has been Executed successfully." );
                    }
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
        executionRequest.setPreviousExecQuantity( singleOrderRequest.getExecutedQuantity() );
    }

}