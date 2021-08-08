package com.example.fixengine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fixengine.model.DataUtility;

/***
 * This class is used to open new activity on click listener on different options like see status,
 * portfolio,order status.
 */
public class TradeOptionStatusPortofolioActivity extends AppCompatActivity {

    Button submitOrder;
    String loginRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_trade_option_status_portofolio );
        submitOrder = findViewById( R.id.placeOrderButton );
        loginRole = getIntent().getExtras().get( "role" ).toString();
        if ("Broker".equalsIgnoreCase( loginRole )) {
            submitOrder.setBackgroundColor(Color.GRAY);
            submitOrder.setEnabled( false );
        }
        submitOrder();
        openOrderStatusActivity();
        logoutActivity();
    }

    public void openOrderStatusActivity() {
        Button orderStatusButton = findViewById( R.id.orderStatusButton );
        orderStatusButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orderStatusIntent = new Intent( TradeOptionStatusPortofolioActivity.this, OrderStatusActivity.class );
                orderStatusIntent.putExtra( "role", loginRole );
                startActivity( orderStatusIntent );
                System.out.println("In order status activity");
            }
        } );
    }



    public void submitOrder() {
        submitOrder.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitOrder = new Intent(TradeOptionStatusPortofolioActivity.this, SubmitOrderActivity.class);
                submitOrder.putExtra( "role", loginRole );
                startActivity( submitOrder );
            }
        } );
    }

    public void logoutActivity() {
        Button logout = findViewById( R.id.logoutButton );
        logout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( TradeOptionStatusPortofolioActivity.this, "Logout Succesful", Toast.LENGTH_SHORT ).show();
                Intent logoutIntent = new Intent( TradeOptionStatusPortofolioActivity.this, MainActivityPage.class );
                startActivity( logoutIntent );
            }

        } );
    }
}