package com.example.fixengine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.fixengine.model.SingleOrderRequest;
import com.example.fixengine.services.ClientAccountService;
import com.example.fixengine.services.OrderService;
import com.example.fixengine.services.SymbolService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SubmitOrderActivity extends AppCompatActivity {

    private OrderService orderService;
    private ClientAccountService clientAccountService;
    private SymbolService symbolService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_submit_order );
        orderService = new OrderService();
        symbolService = new SymbolService();
        clientAccountService = new ClientAccountService();
        addAccountsOnSpinner();
        addSymbolsOnSpinner();
        addSubmitButtonActionListner();

        backToMainpage();
    }

    private void addSymbolsOnSpinner() {
        List<String> symbol = new ArrayList<>();
        symbolService.addSymbol( symbol );
        Spinner symbolSpinner = findViewById( R.id.spinnerSymbol );
        symbolSpinner.setAdapter( new ArrayAdapter<>(SubmitOrderActivity.this,
                android.R.layout.simple_spinner_dropdown_item, symbol ) );
    }

    private void addAccountsOnSpinner() {
        Spinner accountSpinner = findViewById(R.id.spinnerAccountID);
        List<String> account = new ArrayList<>();
        clientAccountService.getClientAccountList(account);
        // now retriving data from database
//                new ArrayList<>();
//        account.add( "A123" );
//        account.add( "B321" );
            accountSpinner.setAdapter( new ArrayAdapter<>( SubmitOrderActivity.this,
                    android.R.layout.simple_spinner_dropdown_item, account ) );

    }

    public void addSubmitButtonActionListner() {
        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner accountSpinner = findViewById(R.id.spinnerAccountID);
                Spinner symbolSpinner = findViewById( R.id.spinnerSymbol );
                RadioButton buyRadiobutton = findViewById(R.id.buyRadioButton);
                String side = "Sell";
                if (buyRadiobutton.isChecked()) {
                    side = "Buy";
                }
                EditText quantityEdittext = findViewById( R.id.quantityEditText );
                accountSpinner.getSelectedItem();
                SingleOrderRequest singleOrderRequest = new SingleOrderRequest();
                String orderId = UUID.randomUUID().toString();
                singleOrderRequest.setOrderId(orderId);
                singleOrderRequest.setAccountId(accountSpinner.getSelectedItem().toString());
                singleOrderRequest.setQuantity(Double.valueOf(quantityEdittext.getText().toString()));
                singleOrderRequest.setSide(side);
                singleOrderRequest.setSymbol(symbolSpinner.getSelectedItem().toString());
                singleOrderRequest.setExecutedQuantity( 0 );
                singleOrderRequest.setStatus( "Created" );
                orderService.submitOrder( singleOrderRequest );
            }
        } );
    }

    public void backToMainpage() {
        Button backButoon = findViewById( R.id.backButtonFromSubmitOrder );
        backButoon.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backintent = new Intent(SubmitOrderActivity.this, TradeOptionStatusPortofolioActivity.class);
                startActivity( backintent );
            }
        } );
    }
}