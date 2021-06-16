package com.example.fixengine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/***
 * This class is used to open new activity on click listener on different options like see status,
 * portfolio,order status.
 */
public class TradeOptionStatusPortofolioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_trade_option_status_portofolio );
    }
}