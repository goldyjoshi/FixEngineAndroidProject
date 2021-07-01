package com.example.fixengine.model;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.StackView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fixengine.OrderExecutionActivity;
import com.example.fixengine.R;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusAdaptor extends RecyclerView.Adapter<OrderStatusAdaptor.OrderStatusViewHolder>
        implements Filterable {

    private Context context; //Variable of type Context
    private List<SingleOrderRequest> orderList; //Variable to store the list of type single order request.
    private List<SingleOrderRequest> listOfAllOrders;

    /***
     * Constructor to initialized OrderStatusAdaptor data fields and its parent Adaptor and implements Filterable
     * @param context unique value of context
     * @param orderList unique representation of list of order
     */
    public OrderStatusAdaptor(Context context, List<SingleOrderRequest> orderList) {
        this.context=context;
        this.orderList = orderList;
        this.listOfAllOrders = new ArrayList<>(orderList);
    }

    /***
     * This method is override from implements  Filterable class and its inflate the layout
     * @param parent
     * @param viewType
     * @return viewHolder of type OrderStatusViewHolder
     */
    @NonNull
    @Override
    public OrderStatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.order_info_row, parent,false);
        OrderStatusViewHolder viewHolder = new OrderStatusViewHolder(view);
        return viewHolder;
    }

    /***
     *
     * @param holder
     * @param position unique value of type int
     */
    @Override
    public void onBindViewHolder(@NonNull OrderStatusViewHolder holder, int position) {
        SingleOrderRequest orderRequest = orderList.get(position);
        holder.orderId.setText(orderRequest.getOrderId());
        String accountText = "Account Id : " + orderRequest.getAccountId();
        holder.accountId.setText(accountText);
        String quantityText = "Requested Quantity : " + String.valueOf(orderRequest.getQuantity());
        holder.quantity.setText(quantityText);
        String executedQtyText = "Executed Quantity : " + orderRequest.getExecutedQuantity() ;
        holder.execQuantity.setText(executedQtyText);
        holder.symbol.setText(orderRequest.getSymbol());
        holder.side.setText(orderRequest.getSide());
        holder.status.setText( orderRequest.getStatus() );
        /***
         * This setOnClickListener is used to make function on execute Button
         */
        holder.execButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.println( Log.INFO, "in view holder", "on Click of button order id is  :"
                        + orderRequest );
                /***
                 * Intent is used to start new activity
                 */
                Intent execOrderActivity = new Intent(context, OrderExecutionActivity.class );
                execOrderActivity.putExtra( "order", orderRequest);
                context.startActivity(execOrderActivity);
            }
        } );
    }

    /***
     * This method is used to get size of list of order.
     * @return
     */
    @Override
    public int getItemCount(){
        return orderList.size();
    }

    /***
     * This method is used to filter the Recyclerview  of list
     * @return orderFilter of type Filter
     */
    @Override
    public Filter getFilter() {
        return orderFilter;
    }

    private Filter orderFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<SingleOrderRequest> filteredList = new ArrayList<>();
            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(listOfAllOrders);
            } else {
                String filterString = charSequence.toString().toLowerCase().trim();
                String accountId;
                for (SingleOrderRequest singleOrderRequest : listOfAllOrders) {
                    accountId = singleOrderRequest.getAccountId();
                    if (accountId.contains(filterString)) {
                        filteredList.add(singleOrderRequest);
                    }
                }
            }
            FilterResults orderFilterResult = new FilterResults();
            orderFilterResult.values = filteredList;
            return orderFilterResult;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            orderList.clear();
            orderList.addAll( (List) filterResults.values );
            notifyDataSetChanged();
        }
    };


    public class OrderStatusViewHolder extends RecyclerView.ViewHolder {
        TextView orderId;
        TextView status;
        TextView accountId;
        TextView side;
        TextView symbol;
        TextView quantity;
        TextView execQuantity;
        Button execButton;

        public OrderStatusViewHolder(@NonNull View itemView) {
            super( itemView );
            orderId = itemView.findViewById( R.id.orderId);
            status = itemView.findViewById( R.id.status);
            accountId = itemView.findViewById( R.id.accountId);
            quantity = itemView.findViewById( R.id.quantity );
            side = itemView.findViewById( R.id.side );
            symbol = itemView.findViewById( R.id.symbol );
            execQuantity = itemView.findViewById( R.id.execQuantity);
            execButton = itemView.findViewById( R.id.execButton);
        }
    }

    public List<SingleOrderRequest> getCurrrentOrderList() {
        return orderList;
    }

    public List<SingleOrderRequest> getFullOrderList() {
        return listOfAllOrders;
    }
}
