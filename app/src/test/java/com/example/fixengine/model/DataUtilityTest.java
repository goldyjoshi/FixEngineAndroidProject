package com.example.fixengine.model;

import org.junit.Assert;

public class DataUtilityTest {

    public void getSetTraderLoginDetailsTest() {
        // Given TraderLoginDetails
        String loginStatus = "Success";
        String loginRole = "Trader";
        String employeeId = "EMP1234";

        TraderLoginDetails traderLoginDetails = new TraderLoginDetails(employeeId, loginStatus,
                loginRole);

        // When DataUtility object exist.
        DataUtility dataUtility = new DataUtility();

        // Then check initial value.
        Assert.assertNull(dataUtility.getTraderLoginDetails());

        // When value of TraderLoginDetails modified.
        dataUtility.setTraderLoginDetails( traderLoginDetails );

        // Then check TraderLoginDetails
        Assert.assertNotNull( dataUtility.getTraderLoginDetails() );
        Assert.assertEquals( dataUtility.getTraderLoginDetails().getEmployeeId(), employeeId );
        Assert.assertEquals( dataUtility.getTraderLoginDetails().getLoginRole(), loginRole );
        Assert.assertEquals( dataUtility.getTraderLoginDetails().getLoginStatus(), loginStatus );

    }
}
