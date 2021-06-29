package com.example.fixengine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.fixengine.model.OrderStatusAdaptor;
import com.example.fixengine.model.SingleOrderRequest;
import com.example.fixengine.services.OrderService;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    OrderStatusAdaptor orderStatusAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_order_status );
        recyclerView = findViewById(R.id.order_status_recycler_view);
        setOrderList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate( R.menu.order_menu, menu );
        MenuItem orderSearchItem = menu.findItem( R.id.orderSearch );
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
        return true;
    }

    private void setOrderList() {
        OrderService orderService = new OrderService();
        List<SingleOrderRequest> orderList = new ArrayList<>();
        orderStatusAdaptor = new OrderStatusAdaptor(OrderStatusActivity.this, orderList);
        orderService.setOrders(OrderStatusActivity.this, recyclerView, orderStatusAdaptor);
    }


}