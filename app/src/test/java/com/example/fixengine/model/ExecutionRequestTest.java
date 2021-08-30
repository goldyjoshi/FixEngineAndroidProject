package com.example.fixengine.model;

import org.junit.Assert;
import org.junit.Test;

public class ExecutionRequestTest {

    @Test
    public void executionRequestGetterSetterTest() {
        //Given
        String orderIdModifiedValue = "Test1234";
        String accountIdModifiedValue = "ACC123";
        String symbolModifiedValue = "Apple";
        String sideModifiedValue = "Sell";
        String execTypeModifiedValue = "Partial";
        double totalQuantityModifiedValue = 120.75;
        double quantityRequestedForExecModifiedValue =70.2;
        double previousExecQuantityModifiedValue = 40.1;
        double executionPriceModifiedValue = 47.8;


        // When object of SRequest created,
        ExecutionRequest executionRequest = new ExecutionRequest();

        // Then check initial value
        Assert.assertNull(executionRequest.getOrderId());
        Assert.assertNull(executionRequest.getAccountId());
        Assert.assertNull(executionRequest.getSide());
        Assert.assertNull(executionRequest.getSymbol());
        Assert.assertNull(executionRequest.getExecType());
        Assert.assertEquals(executionRequest.getTotalQuantity(), 0.0, 0.0);
        Assert.assertEquals(executionRequest.getQuantityRequestedForExec(), 0.0, 0.0);
        Assert.assertEquals(executionRequest.getPreviousExecQuantity(), 0.0, 0.0);
        Assert.assertEquals(executionRequest.getExecutionPrice(), 0.0, 0.0);

        // When initial value modified
        executionRequest.setOrderId(orderIdModifiedValue);
        executionRequest.setAccountId(accountIdModifiedValue);
        executionRequest.setSymbol(symbolModifiedValue);
        executionRequest.setSide(sideModifiedValue);
        executionRequest.setExecType(execTypeModifiedValue);
        executionRequest.setTotalQuantity(totalQuantityModifiedValue);
        executionRequest.setQuantityRequestedForExec(quantityRequestedForExecModifiedValue);
        executionRequest.setPreviousExecQuantity(previousExecQuantityModifiedValue);
        executionRequest.setExecutionPrice(executionPriceModifiedValue);

        // Then check modified value.
        Assert.assertEquals(executionRequest.getOrderId(), orderIdModifiedValue);
        Assert.assertEquals(executionRequest.getSide(), sideModifiedValue);
        Assert.assertEquals(executionRequest.getSymbol(), symbolModifiedValue);
        Assert.assertEquals(executionRequest.getAccountId(), accountIdModifiedValue);
        Assert.assertEquals(executionRequest.getExecType(), execTypeModifiedValue);
        Assert.assertEquals(executionRequest.getTotalQuantity(), totalQuantityModifiedValue, 0.0);
        Assert.assertEquals(executionRequest.getQuantityRequestedForExec(),
                quantityRequestedForExecModifiedValue, 0.0);
        Assert.assertEquals(executionRequest.getPreviousExecQuantity(),
                previousExecQuantityModifiedValue, 0.0);
        Assert.assertEquals(executionRequest.getExecutionPrice(), executionPriceModifiedValue, 0.0);
    }

}
