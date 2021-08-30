package com.example.fixengine.model;

import org.junit.Assert;
import org.junit.Test;

public class TraderDetailsTest {

    @Test
    public void traderDetailsGetterSetterTest() {
        //Given
        String traderEmployeeIdInitialValue = "ET740";
        String traderEmailIdInitialValue = "abc@gmail.com";
        String traderPasswordInitialValue = "password";
        String loginRoleInitialValue = "Broker";

        // When
        TradeDetails traderDetails = new TradeDetails(traderEmployeeIdInitialValue
                , traderEmailIdInitialValue
                , traderPasswordInitialValue
                , loginRoleInitialValue);

        // Then check initial value.
        Assert.assertEquals(traderDetails.getTraderEmailId(), traderEmailIdInitialValue);
        Assert.assertEquals(traderDetails.getTraderEmployeeId(), traderEmployeeIdInitialValue);
        Assert.assertEquals(traderDetails.getTraderPassword(), traderPasswordInitialValue);
        Assert.assertEquals(traderDetails.getLoginRole(), loginRoleInitialValue);

        // When value changed.
        String traderEmployeeIdModifiedValue = "ET777";
        String traderEmailIdModifiedValue = "pqr@gmail.com";
        String traderPasswordModifiedValue = "password@modified";
        String loginRoleModifiedValue = "Trader";

        traderDetails.setTraderEmployeeId(traderEmployeeIdModifiedValue);
        traderDetails.setTraderEmailId(traderEmailIdModifiedValue);
        traderDetails.setTraderPassword(traderPasswordModifiedValue);
        traderDetails.setLoginRole(loginRoleModifiedValue);

        // Then check modified value.
        Assert.assertEquals(traderDetails.getTraderEmailId(), traderEmailIdModifiedValue);
        Assert.assertEquals(traderDetails.getTraderEmployeeId(), traderEmployeeIdModifiedValue);
        Assert.assertEquals(traderDetails.getTraderPassword(), traderPasswordModifiedValue);
        Assert.assertEquals(traderDetails.getLoginRole(), loginRoleModifiedValue);

    }

}
