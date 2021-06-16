package com.example.fixengine.model;

public class TraderLoginDetails {

    private String traderEmailId;
    private String password;

    public TraderLoginDetails(String traderEmailId, String password) {
        this.traderEmailId = traderEmailId;
        this.password = password;
    }

    public String getTraderEmailId() {
        return traderEmailId;
    }

    public void setTraderEmailId(String traderEmailId) {
        this.traderEmailId = traderEmailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
