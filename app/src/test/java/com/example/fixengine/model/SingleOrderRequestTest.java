package com.example.fixengine.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SingleOrderRequestTest {

    private SingleOrderRequest singleOrderRequest;

    @Before
    public void init() {
        singleOrderRequest = new SingleOrderRequest();
    }

    @Test
    public void setAndGetAccountIDTest() {
        final String expectedAccountId = "A456";
        singleOrderRequest.setAccountId( expectedAccountId );
        final String actualAccountId = singleOrderRequest.getAccountId();
        Assert.assertEquals( "Actual and expected employee account ID  are not same,", expectedAccountId, actualAccountId );
    }

    @Test
    public void setAndGetQuantityTest() {
        final double expectedQuantity = 56.2;
        singleOrderRequest.setQuantity( expectedQuantity );
        final double actualQuantity = singleOrderRequest.getQuantity();
        Assert.assertEquals( "Actual and expected quantity  are not same.", expectedQuantity, actualQuantity, 0.0 );
    }

    @Test
    public void setAndGetExecutedQuantity() {
        final double expectedExecutedQuantity = 24.5;
        singleOrderRequest.setExecutedQuantity( expectedExecutedQuantity );
        final double actualExecutedQuantity = singleOrderRequest.getExecutedQuantity();
        Assert.assertEquals( "Actual and expected quantity  are not same.", expectedExecutedQuantity, actualExecutedQuantity, 0.0 );
    }

    @Test
    public void setAndGetSymbolTest() {
        final String expectedSymbol = "Facebook";
        singleOrderRequest.setSymbol( expectedSymbol );
        final String actualSymbol = singleOrderRequest.getSymbol();
        Assert.assertEquals( "Actual and expected symbol  are not same,", expectedSymbol, actualSymbol );
    }


}
