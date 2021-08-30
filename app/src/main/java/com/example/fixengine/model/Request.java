package com.example.fixengine.model;

import java.util.Objects;

/***
 * This model class represent Request and parent of ExecutionRequest and SingleOrderRequest class.
 * @author vijayshreejoshi
 */
public class Request {

    protected String orderId; //Variable to  store order Id
    protected String accountId; //Variable to store account Id.
    protected String symbol; //Variable to store the names of symbol.
    protected String side; //To represent the trader side buy or sell.

    /***
     * This method is used to get Id of order has been placed.
     * @return String value of order Id.
     */
    public String getOrderId() {
        return orderId;
    }

    /***
     * This method is used to set value of orderId.
     * @param orderId unique value of id of order
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /***
     * This method is used to get Id of account.
     * @return String value of account Id.
     */
    public String getAccountId() {
        return accountId;
    }

    /***
     * This method is used to set value of account id.
     * @param accountId to represent the Id of  client account
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /***
     * Method is used to get name of symbol.
     * @return String value of symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /***
     * This function is used to set symbol value.
     * @param symbol variable o store name of symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /***
     * This function is used to get side(type) of order means is it buy or sell.
     * @return String value of side(buy/sell)
     */
    public String getSide() {
        return side;
    }

    /***
     * This method is used to set value of Side as buy or sell.
     * @param side to represent the side of user(buy/sell)
     */
    public void setSide(String side) {
        this.side = side;
    }

    /***
     * String representation of class.
     * @return value of all fields as a string.
     */
    @Override
    public String toString() {
        return "Request{" +
                "orderId='" + orderId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", symbol='" + symbol + '\'' +
                ", side='" + side + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return orderId.equals( request.orderId ) &&
                accountId.equals( request.accountId ) &&
                symbol.equals( request.symbol ) &&
                side.equals( request.side );
    }

    /***
     * Generate unique code for each object.
     * @return unique hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash( orderId, accountId, symbol, side );
    }

}
