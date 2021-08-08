package com.example.fixengine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
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
    private ImageButton imageHomeButton;
    EditText quantityEdittext;
    String loginRole;
    Spinner accountSpinner;
    Spinner symbolSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_submit_order );
        orderService = new OrderService();
        symbolService = new SymbolService();
        clientAccountService = new ClientAccountService();
        quantityEdittext = findViewById( R.id.quantityEditText );
        Spinner accountSpinner = findViewById(R.id.spinnerAccountID);
        Spinner symbolSpinner = findViewById( R.id.spinnerSymbol );
        loginRole = getIntent().getExtras().get( "role" ).toString();
        addAccountsOnSpinner();
        addSymbolsOnSpinner();
        addSubmitButtonActionListner();
        cancelOrder();
        addHomeButtonClickListner();
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
            accountSpinner.setAdapter( new ArrayAdapter<>( SubmitOrderActivity.this,
                    android.R.layout.simple_spinner_dropdown_item, account ) );
    }

    public void addSubmitButtonActionListner() {
        Button submitButton = findViewById(R.id.submitButton2 );
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner accountSpinner = findViewById(R.id.spinnerAccountID);
                Spinner symbolSpinner = findViewById( R.id.spinnerSymbol );
                RadioButton buyRadiobutton = findViewById(R.id.buyRadioButton);
                RadioButton sellRadiobutton = findViewById(R.id.sellRadioButton);
                String side = "";
                if (buyRadiobutton.isChecked()) {
                    side = "Buy";
                } else if (sellRadiobutton.isChecked()) {
                    side = "Sell";
                }
                EditText quantityEdittext = findViewById( R.id.quantityEditText );
                String account = accountSpinner.getSelectedItem().toString();
                String quantity = quantityEdittext.getText().toString();
                String symbol = symbolSpinner.getSelectedItem().toString();
                SingleOrderRequest singleOrderRequest = new SingleOrderRequest();
                String orderId = UUID.randomUUID().toString();
                singleOrderRequest.setOrderId(orderId);
                singleOrderRequest.setAccountId(account);
                singleOrderRequest.setQuantity(Double.valueOf(quantity));
                singleOrderRequest.setSide(side);
                singleOrderRequest.setSymbol(symbol);
                singleOrderRequest.setExecutedQuantity( 0 );
                singleOrderRequest.setStatus( "Created" );
                if (account.isEmpty() || symbol.isEmpty() || side.isEmpty() || quantity.isEmpty() ) {
                    Toast.makeText( SubmitOrderActivity.this, "Please complete all fields " +
                            "for order submission.", Toast.LENGTH_SHORT).show();
                } else {
                    orderService.submitOrder( singleOrderRequest, SubmitOrderActivity.this, loginRole );
                }
            }
        } );
    }

    public void cancelOrder() {
        Button backButoon = findViewById( R.id.cancelButton );
        backButoon.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               quantityEdittext.getText().clear();
               symbolSpinner.setSelection(0);
               accountSpinner.setSelection(0);



//                Intent cancelIntent = new Intent(SubmitOrderActivity.this, TradeOptionStatusPortofolioActivity.class);
//                startActivity( cancelIntent );
            }
        } );
    }

    public void addHomeButtonClickListner() {
        imageHomeButton = findViewById(R.id.homeImageButton);
        imageHomeButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(SubmitOrderActivity.this, TradeOptionStatusPortofolioActivity.class);
                startActivity( homeIntent );
            }
        } );
    }
}