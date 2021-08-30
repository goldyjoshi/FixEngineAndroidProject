package com.example.fixengine.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SingleOrderRequestTest {

    @Test
    public void singleOrderRequestGetterSetterTest() {
        //Given
        String orderIdModifiedValue = "Test1234";
        String accountIdModifiedValue = "AC12345";
        double quantityModifiedValue = 101.5;
        double executedQuantityModifiedValue = 70.5;
        String statusModifiedValue = "Created";
        String symbolModifiedValue = "Apple";
        String sideModifiedValue = "Buy" ;

        // When object of SingleOrderRequest created,
        SingleOrderRequest singleOrderRequest = new SingleOrderRequest();

        // Then check initial value
        Assert.assertNull(singleOrderRequest.getOrderId());
        Assert.assertNull(singleOrderRequest.getStatus());
        Assert.assertNull(singleOrderRequest.getSide());
        Assert.assertNull(singleOrderRequest.getSymbol());
        Assert.assertNull(singleOrderRequest.getAccountId());
        Assert.assertEquals(singleOrderRequest.getQuantity(), 0.0,0.0);
        Assert.assertEquals(singleOrderRequest.getExecutedQuantity(), 0.0, 0.0);

        // When initial value modified
        singleOrderRequest.setOrderId(orderIdModifiedValue);
        singleOrderRequest.setAccountId(accountIdModifiedValue);
        singleOrderRequest.setStatus(statusModifiedValue);
        singleOrderRequest.setSide(sideModifiedValue);
        singleOrderRequest.setSymbol(symbolModifiedValue);
        singleOrderRequest.setQuantity(quantityModifiedValue);
        singleOrderRequest.setExecutedQuantity(executedQuantityModifiedValue);

        // Then check modified value.
        Assert.assertEquals(singleOrderRequest.getOrderId(), orderIdModifiedValue);
        Assert.assertEquals(singleOrderRequest.getStatus(), statusModifiedValue);
        Assert.assertEquals(singleOrderRequest.getSide(), sideModifiedValue);
        Assert.assertEquals(singleOrderRequest.getSymbol(), symbolModifiedValue);
        Assert.assertEquals(singleOrderRequest.getAccountId(), accountIdModifiedValue);
        Assert.assertEquals(singleOrderRequest.getQuantity(), quantityModifiedValue, 0.0);
        Assert.assertEquals(singleOrderRequest.getExecutedQuantity(), executedQuantityModifiedValue, 0.0);

    }


}
