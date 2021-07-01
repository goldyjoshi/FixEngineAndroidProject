package com.example.fixengine.model;

public class ExecutionRequest {
    private String orderId; //Variable to  store order Id
    private String accountId; //Variable to store account Id.
    private double totalQuantity; //to represent the quantity of orders symbol.
    private String symbol; //Variable to store the names of symbol.
    private String side; //To represent the trader side buy or sell.
    private int executedQuantity; //To represent the how much Quantity executed of order
    private double executionPrice; //Variable to represent the price of execution of order.
    private String execType; //To represent the type of execution of order.

    /***
     * This method is used to get type of execution.
     * @return  string value of execType.
     */
    public String getExecType() {
        return execType;
    }

    public void setExecType(String execType) {
        this.execType = execType;
    }

    /***
     * This method is used to get Id of order has been placed.
     * @return String value of order Id.
     */
    public String getOrderId() {
        return orderId;
    }

    /***
     * This method is used to set value of orderId.
     * @param orderId
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
     * @param accountId
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /***
     * This method is used to get quantity of symbol shares in order of execution
     * @return int value of totalQuantity
     */
    public double getTotalQuantity() {
        return totalQuantity;
    }

    /***
     * This method is used to set value of total quantity of order for execution.
     * @param totalQuantity
     */
    public void setTotalQuantity(double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    /***
     * Method is used to get name of symbol.
     * @return String value of symbol
     */
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /***
     * this function is used to get side(type) of order means is it buy or sell.
     * @return String value of side(buy/sell)
     */
    public String getSide() {
        return side;
    }

    /***
     * This method is used to set value of Side as buy or sell.
     * @param side
     */
    public void setSide(String side) {
        this.side = side;
    }

    /***
     * This method is used to get value of quantity of executed order.
     * @return String value of executedQuantity
     */
    public int getExecutedQuantity() {
        return executedQuantity;
    }

    /***
     * This method is used to set value of executed quantity.
     * @param executedQuantity
     */
    public void setExecutedQuantity(int executedQuantity) {
        this.executedQuantity = executedQuantity;
    }

    /***
     * This method is used to get value of price of execution order
     * @return String value of executionPrice
     */
    public double getExecutionPrice() {
        return executionPrice;
    }

    /***
     * This method is used to set value of price of executed order
     * @param executionPrice
     */
    public void setExecutionPrice(double executionPrice) {
        this.executionPrice = executionPrice;
    }
}
