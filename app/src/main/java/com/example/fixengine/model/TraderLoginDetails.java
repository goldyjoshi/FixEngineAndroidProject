package com.example.fixengine.model;

import java.util.Objects;

/***
 * Class represent the TraderLoginDetails and its field traderEmailId and password
 * @author vijayshreejoshi
 */
public class TraderLoginDetails {

    private String loginStatus; //Variable to store unique value of login status of user.
    private String loginRole; //Variable to store unique value of login role of user (Trader/Broker).
    private String employeeId; //Variable to store unique value of employee Id.

    /***
     * Constructor to initialize the fields of TraderLoginDetails class.
     * @param employeeId string value of employee id
     * @param loginRole unique string value of  trader's password
     * @param loginStatus current status of login.
     * @
     */
    public TraderLoginDetails(final String employeeId, final String loginStatus, final String loginRole ) {
        this.employeeId = employeeId;
        this.loginStatus = loginStatus;
        this.loginRole = loginRole;
    }

    /***
     * This method is used to get value of employee id
     * @return String value of employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /***
     * This method is used to set value employee Id
     * @param employeeId unique value of employee id
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /***
     * This method is used to get value of trader email id
     * @return String value of traderEmailId
     */
    public String getLoginStatus() {
        return loginStatus;
    }

    /***
     * This method is used to set value trader's email Id
     * @param loginStatus unique value of mail id
     */
    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    /***
     * Method is used to get unique value of password
     * @return String value of password
     */
    public String getLoginRole() {
        return loginRole;
    }

    /***
     * Method is used to set unique value of password
     * @param loginRole unique value of trader's password
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
        return "TraderLoginDetails{" +
                "loginStatus='" + loginStatus + '\'' +
                ", loginRole='" + loginRole + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }

    /***
     * To compare quality of two object of TraderLoginDetails.
     * @param o to be compare
     * @return true if two object are equal else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TraderLoginDetails)) return false;
        TraderLoginDetails that = (TraderLoginDetails) o;
        return Objects.equals( loginStatus, that.loginStatus ) &&
                Objects.equals( loginRole, that.loginRole ) &&
                Objects.equals( employeeId, that.employeeId );
    }

    /***
     * Generate unique code for each object.
     * @return unique hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash( loginStatus, loginRole, employeeId );
    }

}
