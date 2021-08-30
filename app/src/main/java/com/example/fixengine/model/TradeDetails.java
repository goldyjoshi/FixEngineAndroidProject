package com.example.fixengine.model;

import java.util.Objects;

/***
 * This class is represent the fields of trade details as traderEmployeeId, traderEmailId,
 * traderPassword, loginRole.
 * @author vijayshreejoshi
 */
public class TradeDetails {

    private String traderEmployeeId; // variable to store trder employee id of type String.
    private String traderEmailId;   // variable to store trder email id of type String.
    private String traderPassword;  // variable to store trder password id of type String.
    private String loginRole;       // variable to store role during signup.

    /***
     * Constructor is to initialize the data field of TradeDetails class.
     * @param traderEmployeeId to represent a unique value of employee id.
     * @param traderEmailId to represent a unique value of email id of trader
     * @param traderPassword to represent a unique value of password.
     */
    public TradeDetails(final String traderEmployeeId, final String traderEmailId,
                        final String traderPassword, final String loginRole) {
        this.traderEmployeeId = traderEmployeeId;
        this.traderEmailId = traderEmailId;
        this.traderPassword = traderPassword;
        this.loginRole = loginRole;
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

    /***
     * This method is used to get value of login role.
     * @return String value of loginRole
     */
    public String getLoginRole() {
        return loginRole;
    }

    /***
     * This setter method is used to set value of loginRole.
     * @param loginRole value
     */
    public void setLoginRole(String loginRole) {
        this.loginRole = loginRole;
    }

    /***
     * String representation of class.
     * @return value of all fields as a string.
     */
    @Override
    public String toString() {
        return "TradeDetails{" +
                "traderEmployeeId='" + traderEmployeeId + '\'' +
                ", traderEmailId='" + traderEmailId + '\'' +
                ", traderPassword='" + traderPassword + '\'' +
                ", loginRole='" + loginRole + '\'' +
                '}';
    }

    /***
     * To compare quality of two object of TraderDetails.
     * @param o to be compare
     * @return true if two object are equal else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TradeDetails)) return false;
        TradeDetails that = (TradeDetails) o;
        return traderEmployeeId.equals( that.traderEmployeeId ) &&
                traderEmailId.equals( that.traderEmailId ) &&
                traderPassword.equals( that.traderPassword ) &&
                loginRole.equals( that.loginRole );
    }

    /***
     * Generate unique code for each object.
     * @return unique hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash( traderEmployeeId, traderEmailId, traderPassword, loginRole );
    }

}
