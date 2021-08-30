package com.example.fixengine;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/***
 * This class is used to open new activity on click listener on different options like see status,
 * portfolio,order status.
 * @author vijayshreejoshi
 */
public class TradeOptionStatusPortofolioActivity extends AppCompatActivity {
    Button submitOrder; //Variable to represent the submitOrder button.
    String loginRole; //Variable to represent the loginRole of type String.

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

    /***
     * This method is used to start new order status activity on click.
     */
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

    /***
     * This method is used to start new activity on click of submitOrder button.
     */
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

    /***
     * This method is used to logout from application and notify with message on successful logout.
     */
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