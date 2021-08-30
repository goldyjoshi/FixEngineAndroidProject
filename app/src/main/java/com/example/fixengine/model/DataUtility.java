package com.example.fixengine.model;

import java.util.Objects;

/***
 *This class represent the DataUtility to reuse data in another class.
 * @author vijayshreejoshi
 */
public class DataUtility {

    private TraderLoginDetails traderLoginDetails; //Variable to store login details of trader.

    /***
     * This method is used to get trader login details.
     * @return traderLoginDetails of type TraderLoginDetails.
     */
    public TraderLoginDetails getTraderLoginDetails() {
        return traderLoginDetails;
    }

    /***
     * This method is used to set trader login details.
     * @param traderLoginDetails unique value trader login details.
     */
    public void setTraderLoginDetails(TraderLoginDetails traderLoginDetails) {
        traderLoginDetails = traderLoginDetails;
    }

    /***
     * String representation of class.
     * @return value of all fields as a string.
     */
    @Override
    public String toString() {
        return "DataUtility{" +
                "traderLoginDetails=" + traderLoginDetails +
                '}';
    }

    /***
     * To compare quality of two object of DataUtility.
     * @param o to be compare
     * @return true if two object are equal else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataUtility)) return false;
        DataUtility that = (DataUtility) o;
        return Objects.equals( traderLoginDetails, that.traderLoginDetails );
    }

    /***
     * Generate unique code for each object.
     * @return unique hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash( traderLoginDetails );
    }

}
