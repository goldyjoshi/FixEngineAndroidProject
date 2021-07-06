package com.example.fixengine.model;

/***
 * This class is represent the fields of trade details
 */
public class TradeDetails {
    private String traderEmployeeId; // variable to store trder employee id of type String.
    private String traderEmailId;   // variable to store trder email id of type String.
    private String traderPassword;  // variable to store trder password id of type String.

    /***
     * Constructor is to initialize the data field of TradeDetails class.
     * @param traderEmployeeId to represent a unique value of employee id.
     * @param traderEmailId to represent a unique value of email id of trader
     * @param traderPassword to represent a unique value of password.
     */
    public TradeDetails(final String traderEmployeeId, final String traderEmailId, final String traderPassword) {
        this.traderEmployeeId = traderEmployeeId;
        this.traderEmailId = traderEmailId;
        this.traderPassword = traderPassword;
    }

    /***
     * This method is used to get value of trader employee Id.
     * @return String value of traderEmployeeId
     */
    public String getTraderEmployeeId() {
        return traderEmployeeId;
    }

    /***
     * This setter method is used to set value of traderEmployeeId.
     * @param traderEmployeeId value of trader employee id
     */
    public void setTraderEmployeeId(String traderEmployeeId) {
        this.traderEmployeeId = traderEmployeeId;
    }

    /***
     * This method is used to get value of trader employee email
     * @return string value of traderEmailId
     */
    public String getTraderEmailId() {
        return traderEmailId;
    }

    /***
     * This setter method is used to set value of traderEmailId.
     * @param traderEmailId value of trader email id.
     */
    public void setTraderEmailId(String traderEmailId) {
        this.traderEmailId = traderEmailId;
    }

    /***
     * This method is used to get value of trader employee password.
     * @return String value of traderPassword
     */
    public String getTraderPassword() {
        return traderPassword;
    }

    /***
     * This setter method is used to set value of traderPassword.
     * @param traderPassword value of trader password
     */
    public void setTraderPassword(String traderPassword) {
        this.traderPassword = traderPassword;
    }
}
