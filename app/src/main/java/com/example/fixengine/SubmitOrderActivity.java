package com.example.fixengine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.fixengine.model.SingleOrderRequest;
import com.example.fixengine.services.OrderService;

import java.util.ArrayList;
import java.util.List;

public class SubmitOrderActivity extends AppCompatActivity {

    private OrderService orderService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_submit_order );
        orderService = new OrderService();
        addAccountDetails();
        addSubmitButtonActionListner();
    }

    private void addAccountDetails() {
        Spinner accountSpinner = findViewById(R.id.spinnerAccountID);
        List<String> account = new ArrayList<>();
        account.add( "A123" );
        account.add( "B321" );
        accountSpinner.setAdapter( new ArrayAdapter<>(SubmitOrderActivity.this,
                android.R.layout.simple_spinner_dropdown_item , account
        ) );
        accountSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText( SubmitOrderActivity.this, "on selection", Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );

    }

    public void addSubmitButtonActionListner() {
        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner accountSpinner = findViewById(R.id.spinnerAccountID);
                Spinner symbolSpinner = findViewById( R.id.spinnerSymbol );
//                RadioButton buySellRadiobutton = findViewById( R.id. )
                EditText quantityEdittext = findViewById( R.id.quantityEditText );
                accountSpinner.getSelectedItem();
                SingleOrderRequest singleOrderRequest = new SingleOrderRequest();
                singleOrderRequest.setAccountId("A12345");
                singleOrderRequest.setQuantity(Integer.valueOf(quantityEdittext.getText().toString()));
                singleOrderRequest.setSide("Buy");
                singleOrderRequest.setSymbol("facebook");
                orderService.submitOrder( singleOrderRequest );
            }
        } );


    }
}