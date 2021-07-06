package com.example.fixengine.model;

/***
 * Class represent the TraderLoginDetails and its field traderEmailId and password
 * @author vijayshreejoshi
 */
public class TraderLoginDetails {

    private String traderEmailId;
    private String password;

    /***
     * Constructor to initialize the fields of TraderLoginDetails class.
     * @param traderEmailId  //string value of email id
     * @param password //unique string value of  trader's password
     */
    public TraderLoginDetails(String traderEmailId, String password) {
        this.traderEmailId = traderEmailId;
        this.password = password;
    }

    /***
     * This method is used to get value of trader email id
     * @return Steing value of traderEmailId
     */
    public String getTraderEmailId() {
        return traderEmailId;
    }

    /***
     * This method is used to set value trader's email Id
     * @param traderEmailId unique value of mail id
     */
    public void setTraderEmailId(String traderEmailId) {
        this.traderEmailId = traderEmailId;
    }

    /***
     * Methiod is used to get unique value of password
     * @return String value of password
     */
    public String getPassword() {
        return password;
    }

    /***
     * Methios is used to set unique vlaue of password
     * @param password unique value of trader's password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
