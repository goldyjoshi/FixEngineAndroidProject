package com.example.fixengine.model;

/***
 * Class represent the TraderLoginDetails and its field traderEmailId and password
 * @author vijayshreejoshi
 */
public class TraderLoginDetails {

    private String loginStatus;
    private String loginRole;
    private String employeeId;

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
     * Method is used to set unique vlaue of password
     * @param loginRole unique value of trader's password
     */
    public void setLoginRole(String loginRole) {
        this.loginRole = loginRole;
    }

    @Override
    public String toString() {
        return "TraderLoginDetails{" +
                "traderEmailId='" + loginStatus + '\'' +
                ", traderPassword='" + loginRole + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}
