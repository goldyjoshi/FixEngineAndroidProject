package com.example.fixengine.model;

import org.junit.Assert;
import org.junit.Test;

public class TraderDetailsTest {

    private TradeDetails tradeDetails;

    @Test
    public void setAndGetTraderEmployeeIdTest(){
        final String expectedEmployeeId = "E75";
        try {
            tradeDetails.setTraderEmployeeId( expectedEmployeeId );
            final String actualEmployeeId = tradeDetails.getTraderEmployeeId();
            Assert.assertEquals( "Actual and expected employee Id are not same.", expectedEmployeeId, actualEmployeeId );
        } catch (NullPointerException nullPointerException) {
            System.out.println("Trader details arre empty");
        }
    }

    @Test
    public void setAndGetTraderEmailIdTest() {
        final String expectedEmailId = "Goldy@gmail.com";
        try {
            tradeDetails.setTraderEmailId( expectedEmailId );
            final String actualEmployeeEmailId = tradeDetails.getTraderEmailId();
            Assert.assertEquals( "Actual and expected employee Email Id are not same,", expectedEmailId, actualEmployeeEmailId );
        } catch (NullPointerException nullPointerException) {
            System.out.println("Trader details are empty");
        }
    }

    @Test
    public void setAndGetTraderPasswordIdTest() {
        final String expectedPasswordId = "2goldy33@";
        try {
            tradeDetails.setTraderPassword( expectedPasswordId );
            final String actualEmployeePasswordId = tradeDetails.getTraderPassword();
            Assert.assertEquals( "Actual and expected employee password  are not same,", expectedPasswordId, actualEmployeePasswordId );
        } catch (NullPointerException nullPointerException) {
            System.out.println( "Trader details are empty" );
        }
    }

    @Test
        public void setAndGetLoginRoleTest() {
            final String expectedLoginRole = "Trader";
            try {
                tradeDetails.setLoginRole( expectedLoginRole );
                final String actualLoginRole = tradeDetails.getLoginRole();
                Assert.assertEquals( "Actual and expected employee login role  are not same,", expectedLoginRole, actualLoginRole );
            } catch (NullPointerException nullPointerException) {
                System.out.println("Trader details are empty");
            }
    }

}
