package com.example.fixengine.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SingleOrderRequest implements Parcelable {
    private String orderId;
    private String accountId;
    private double quantity;
    private String symbol;
    private String side;
    private double executedQuantity;
    private String status;

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

    public double getExecutedQuantity() {
        return executedQuantity;
    }

    public void setExecutedQuantity(double executedQuantity) {
        this.executedQuantity = executedQuantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    protected SingleOrderRequest(Parcel in) {
//        orderId = in.readString();
//        accountId = in.readString();
//        quantity = in.readDouble();
//        symbol = in.readString();
//        side = in.readString();
//        executedQuantity = in.readDouble();
//        status = in.readString();
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString( orderId );
//        dest.writeString( accountId );
//        dest.writeDouble( quantity );
//        dest.writeString( symbol );
//        dest.writeString( side );
//        dest.writeDouble( executedQuantity );
//        dest.writeString( status );
//    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    public static final Creator<SingleOrderRequest> CREATOR = new Creator<SingleOrderRequest>() {
//        @Override
//        public SingleOrderRequest createFromParcel(Parcel in) {
//            return new SingleOrderRequest( in );
//        }
//
//        @Override
//        public SingleOrderRequest[] newArray(int size) {
//            return new SingleOrderRequest[size];
//        }
//    };

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }


}
