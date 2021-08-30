package com.example.fixengine.model;

import org.junit.Assert;
import org.junit.Test;

public class RequestTest {

    @Test
    public void requestGetterSetterTest() {
        //Given
        String orderIdModifiedValue = "Test1234";
        String accountIdModifiedValue = "ACC123";
        String symbolModifiedValue = "Apple";
        String sideModifiedValue = "Sell";

        // When object of Request created,
        Request request = new Request();

        // Then check initial value
        Assert.assertNull(request.getOrderId());
        Assert.assertNull(request.getAccountId());
        Assert.assertNull(request.getSide());
        Assert.assertNull(request.getSymbol());

        // When initial value modified
        request.setOrderId(orderIdModifiedValue);
        request.setAccountId(accountIdModifiedValue);
        request.setSymbol(symbolModifiedValue);
        request.setSide(sideModifiedValue);

        // Then check modified value.
        Assert.assertEquals(request.getOrderId(), orderIdModifiedValue);
        Assert.assertEquals(request.getSide(), sideModifiedValue);
        Assert.assertEquals(request.getSymbol(), symbolModifiedValue);
        Assert.assertEquals(request.getAccountId(), accountIdModifiedValue);
    }
}
