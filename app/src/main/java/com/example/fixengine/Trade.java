package com.example.fixengine;

public class Trade {

    private  String tradeId;
    private  String accountId;
    private  Long quantity;
    private  String instrumentName;

    public Trade(final String tradeId, final String accountId,final  Long quantity, final String instrumentName) {
        this.tradeId = tradeId;
        this.accountId = accountId;
        this.quantity = quantity;
        this.instrumentName = instrumentName;
    }

    public Trade() {

    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getTradeId() {
        return tradeId;
    }

    public String getAccountId() {
        return accountId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public String getInstrumentName() {
        return instrumentName;
    }
}

