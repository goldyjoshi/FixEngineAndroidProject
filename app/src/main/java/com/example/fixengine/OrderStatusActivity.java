package com.example.fixengine;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fixengine.model.OrderStatusAdaptor;
import com.example.fixengine.model.SingleOrderRequest;
import com.example.fixengine.services.OrderService;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is to represent the OrderStatusActivity and its fields.
 * @author vijayshreejoshi
 */
public class OrderStatusActivity extends AppCompatActivity {

    RecyclerView recyclerView; //To represent the variable of RecyclerView
    OrderStatusAdaptor orderStatusAdaptor;//To represent the variable of type orderStatusAdaptor
    String loginRole;//To represent the value of variable of type String.

    /***
     * Method get called when activity starts.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_order_status );
        loginRole = getIntent().getExtras().get( "role" ).toString();
        recyclerView = findViewById(R.id.order_status_recycler_view);
        setOrderList();
    }

    /***
     * Method get called when options menu get initialized on startup of activity.
     * @param menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate( R.menu.order_menu, menu );
        MenuItem orderSearchItem = menu.findItem( R.id.orderSearch );
        MenuItem homeMenuItem = menu.findItem( R.id.homeMenuItem );
        SearchView orderSearchView = (SearchView) orderSearchItem.getActionView();

        orderSearchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String searchText) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String searchText) {
                String message = "Search String is : " + searchText;
                Log.println( Log.INFO, "order_search", message);
                if (searchText != null && orderStatusAdaptor != null) {
                    Log.println( Log.INFO, "order_search", "under search");
                    orderStatusAdaptor.getFilter().filter( searchText );
                }
                return false;
            }
        } );
        Button homeItemImageButton = (Button) homeMenuItem.getActionView();
        homeItemImageButton.setText( "Home" );
        homeItemImageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(OrderStatusActivity.this, TradeOptionStatusPortofolioActivity.class);
                homeIntent.putExtra( "role", loginRole );
                startActivity( homeIntent );
            }
        } );

        return true;
    }

    /***
     * This methios is used to set list of order.
     */
    private void setOrderList() {
        OrderService orderService = new OrderService();
        List<SingleOrderRequest> orderList = new ArrayList<>();
        orderStatusAdaptor = new OrderStatusAdaptor(OrderStatusActivity.this, orderList, loginRole);
        orderService.setOrders(OrderStatusActivity.this, recyclerView, orderStatusAdaptor);
    }

}