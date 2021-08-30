package com.example.fixengine.model;

import java.util.Objects;

/***
 * Class represent the ExecutionRequest and its field orderId, accountId, totalQuantity, symbol,
 * side, quantityRequestedForExec, previousExecQuantity, executionPrice and execType.
 * @author vijayshreejoshi
 */
public class ExecutionRequest extends Request {

    private double totalQuantity; //to represent the quantity of orders symbol.
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

    /***
     * String representation of class.
     * @return value of all fields as a string.
     */
    @Override
    public String toString() {
        return "ExecutionRequest{" +
                "orderId='" + orderId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", totalQuantity=" + totalQuantity +
                ", symbol='" + symbol + '\'' +
                ", side='" + side + '\'' +
                ", quantityRequestedForExec=" + quantityRequestedForExec +
                ", previousExecQuantity=" + previousExecQuantity +
                ", executionPrice=" + executionPrice +
                ", execType='" + execType + '\'' +
                '}';
    }

    /***
     * To compare quality of two object of ExecutionReport.
     * @param o to be compare
     * @return true if two object are equal else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExecutionRequest)) return false;
        ExecutionRequest that = (ExecutionRequest) o;
        return Double.compare( that.totalQuantity, totalQuantity ) == 0 &&
                Double.compare( that.quantityRequestedForExec, quantityRequestedForExec ) == 0 &&
                Double.compare( that.previousExecQuantity, previousExecQuantity ) == 0 &&
                Double.compare( that.executionPrice, executionPrice ) == 0 &&
                orderId.equals( that.orderId ) &&
                accountId.equals( that.accountId ) &&
                symbol.equals( that.symbol ) &&
                side.equals( that.side ) &&
                execType.equals( that.execType );
    }

    /***
     * Generate unique code for each object.
     * @return unique hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash( orderId, accountId, totalQuantity, symbol, side, quantityRequestedForExec, previousExecQuantity, executionPrice, execType );
    }

}
