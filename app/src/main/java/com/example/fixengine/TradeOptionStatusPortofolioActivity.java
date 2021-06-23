package com.example.fixengine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/***
 * This class is used to open new activity on click listener on different options like see status,
 * portfolio,order status.
 */
public class TradeOptionStatusPortofolioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_trade_option_status_portofolio );
        submitOrder();
        backToMainpage();

    }

    public void backToMainpage() {
        Button backButoon = findViewById( R.id.backFromOptionScreenButton );
        backButoon.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backintent = new Intent(TradeOptionStatusPortofolioActivity.this, MainActivityPage.class);
                startActivity( backintent );
            }
        } );
    }

    public void submitOrder() {
        Button submitOrder = findViewById( R.id.placeOrderButton );
        submitOrder.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitOrder = new Intent(TradeOptionStatusPortofolioActivity.this, SubmitOrderActivity.class);
                startActivity( submitOrder );
            }
        } );
    }
}