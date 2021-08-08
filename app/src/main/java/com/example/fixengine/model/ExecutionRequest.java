package com.example.fixengine.model;

/***
 * Class represent the ExecutionRequest and its field orderId, accountId, totalQuantity, symbol,
 * side, quantityRequestedForExec, previousExecQuantity, executionPrice and execType.
 * @author vijayshreejoshi
 */
public class ExecutionRequest {
    private String orderId; //Variable to  store order Id
    private String accountId; //Variable to store account Id.
    private double totalQuantity; //to represent the quantity of orders symbol.
    private String symbol; //Variable to store the names of symbol.
    private String side; //To represent the trader side buy or sell.
    private double quantityRequestedForExec; // current request for execution.
    private double previousExecQuantity;   // total of previously executed quantity.
    private double executionPrice; //Variable to represent the price of execution of order.
    private String execType; //To represent the type of execution of order.


    /***
     * This method is used to get quantity for current execution request.
     * @return  double value of quantityRequestedForExec.
     */
    public double getQuantityRequestedForExec() {
        return quantityRequestedForExec;
    }

    /***
     * This method is used to set value of quantityRequestedForExec.
     * @param quantityRequestedForExec to represent requested quantity for order
     */
    public void setQuantityRequestedForExec(double quantityRequestedForExec) {
        this.quantityRequestedForExec = quantityRequestedForExec;
    }

    /***
     * This method is used to get previously executed quantity on order.
     * @return  double value of previousExecQuantity.
     */
    public double getPreviousExecQuantity() {
        return previousExecQuantity;
    }

    /***
     * This method is used to set value of previousExecQuantity.
     * @param previousExecQuantity to represent the previous executed quantity
     */
    public void setPreviousExecQuantity(double previousExecQuantity) {
        this.previousExecQuantity = previousExecQuantity;
    }

    /***
     * This method is used to get type of execution.
     * @return  string value of execType.
     */
    public String getExecType() {
        return execType;
    }

    /***
     * This method is used to set type of execution either it is partial or full
     * @param execType to represent the either the order is partially executed or completely.
     */
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
     * This method is used to get value of price of execution order
     * @return String value of executionPrice
     */
    public double getExecutionPrice() {
        return executionPrice;
    }

    /***
     * This method is used to set value of price of executed order
     * @param executionPrice to represent the price for symbol to be executed
     */
    public void setExecutionPrice(double executionPrice) {
        this.executionPrice = executionPrice;
    }
}
