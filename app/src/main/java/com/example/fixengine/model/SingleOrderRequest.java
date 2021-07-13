package com.example.fixengine.model;

import android.os.Parcel;
import android.os.Parcelable;

/***
 * Class represent the SingleOrderRequest and its field orderId, accountId, quantity, symbol
 * side, executedQuantity and status
 * @author vijayshreejoshi
 */
public class SingleOrderRequest implements Parcelable {
    private String orderId; //Variable to store unique value of order id
    private String accountId; // Variable to store unique value of account id
    private double quantity; //Variable to store quantity of order
    private String symbol; //Variable to store name of symbol
    private String side; //Variable to represent the value of side
    private double executedQuantity; //Variable to represent the quantity of executed order
    private String status; // variable to represent the status of order

    /***
     * Empty construct for a class to create new instances
     */
    public SingleOrderRequest() {

    }

    protected SingleOrderRequest(Parcel in) {
        orderId = in.readString();
        accountId = in.readString();
        quantity = in.readDouble();
        symbol = in.readString();
        side = in.readString();
        executedQuantity = in.readDouble();
        status = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString( orderId );
        dest.writeString( accountId );
        dest.writeDouble( quantity );
        dest.writeString( symbol );
        dest.writeString( side );
        dest.writeDouble( executedQuantity );
        dest.writeString( status );
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SingleOrderRequest> CREATOR = new Creator<SingleOrderRequest>() {
        @Override
        public SingleOrderRequest createFromParcel(Parcel in) {
            return new SingleOrderRequest( in );
        }

        @Override
        public SingleOrderRequest[] newArray(int size) {
            return new SingleOrderRequest[size];
        }
    };

    /***
     * This method is used to get executed quantity of order.
     * @return value of executedQuantity of type double
     */
    public double getExecutedQuantity() {
        return executedQuantity;
    }

    /***
     * This method is used to set execu†ed quantity of order.
     * @param executedQuantity variable to store unique value of executedQuantity
     */
    public void setExecutedQuantity(double executedQuantity) {
        this.executedQuantity = executedQuantity;
    }

    /***
     * This method is used to get Status of submit order.
     * @return
     */
    public String getStatus() {
        return status;
    }

    /***
     * This method is used to set value of status of order.
     * @param status variable to store status of order.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /***
     *  This method is used to get Id of order
     * @return String vlaue of orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /***
     * This method is used to set Id of order
     * @param orderId unique value of orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /***
     *  This method is used to get unique account id
     * @return String value of accountId
     */
    public String getAccountId() {
        return accountId;
    }


    /***
     *  This method is used to set account id
      * @param accountId unique represent the accountId
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /***
     *  This method is used to get quantity of order
     * @return value of order quantity of double type
     */
    public double getQuantity() {
        return quantity;
    }

    /***
     * This method is used to set quantity of order
     * @param quantity to store the value
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /***
     *  This method is used to get name of symbol
     * @return String value of symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /***
     * This method is used to set value of Symbol
     * @param symbol represent uniquely
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /***
     *  This method is used to get value of side
     * @return String value of side
     */
    public String getSide() {
        return side;
    }

    /***
     * This method is used to set value of side
     * @param side unique representation of side(buy or sell)
     */
    public void setSide(String side) {
        this.side = side;
    }


}
