package com.example.fixengine.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

/***
 * Class represent the SingleOrderRequest and its field orderId, accountId, quantity, symbol
 * side, executedQuantity and status
 * @author vijayshreejoshi
 */
public class SingleOrderRequest extends Request implements Parcelable {

    private double quantity; //Variable to store the unique value of quantity of requested order.
    private double executedQuantity; //Variable to store the unique value of executed quantity of requested order.
    private String status; //Variable to represent the unique value of status of order.

    /***
     * Empty construct for a class to create new instances
     */
    public SingleOrderRequest() {

    }

    /***
     * Constructor is used by Parcelable to share object between activity.
     * @param in reference to parcel object.
     */
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
     * String representation of class.
     * @return value of all fields as a string.
     */
    @Override
    public String toString() {
        return "SingleOrderRequest{" +
                "orderId='" + orderId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", quantity=" + quantity +
                ", executedQuantity=" + executedQuantity +
                ", status='" + status + '\'' +
                ", symbol='" + symbol + '\'' +
                ", side='" + side + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SingleOrderRequest)) return false;
        if (!super.equals( o )) return false;
        SingleOrderRequest that = (SingleOrderRequest) o;
        return Double.compare( that.quantity, quantity ) == 0 &&
                Double.compare( that.executedQuantity, executedQuantity ) == 0 &&
                status.equals( that.status );
    }

    /***
     * Generate unique code for each object.
     * @return unique hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash( super.hashCode(), quantity, executedQuantity, status );
    }

}
