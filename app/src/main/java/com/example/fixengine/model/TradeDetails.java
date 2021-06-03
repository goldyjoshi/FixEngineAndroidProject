package com.example.fixengine.model;

public class TradeDetails {
    private String traderEmployeeId;
    private String traderEmailId;
    private String traderPassword;

    public TradeDetails(final String traderEmployeeId, final String traderEmailId, final String traderPassword) {
        this.traderEmployeeId = traderEmployeeId;
        this.traderEmailId = traderEmailId;
        this.traderPassword = traderPassword;
    }

    public String getTraderEmployeeId() {
        return traderEmployeeId;
    }

    public void setTraderEmployeeId(String traderEmployeeId) {
        this.traderEmployeeId = traderEmployeeId;
    }

    public String getTraderEmailId() {
        return traderEmailId;
    }

    public void setTraderEmailId(String traderEmailId) {
        this.traderEmailId = traderEmailId;
    }

    public String getTraderPassword() {
        return traderPassword;
    }

    public void setTraderPassword(String traderPassword) {
        this.traderPassword = traderPassword;
    }
}
