package com.example.fixengine.model;

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
}
