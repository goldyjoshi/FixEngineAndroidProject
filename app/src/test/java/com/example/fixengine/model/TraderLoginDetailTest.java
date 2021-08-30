package com.example.fixengine.model;

import org.junit.Assert;
import org.junit.Test;

public class TraderLoginDetailTest {

    @Test
    public void traderLoginDetailsGetterAndSetterTest() {
        // Given TraderLoginDetails exist
        String loginStatusInitialValue = "Failed";
        String loginRoleInitialValue = "Trader";
        String employeeIdInitialValue = "EMP1234";

        TraderLoginDetails traderLoginDetails = new TraderLoginDetails(employeeIdInitialValue, loginStatusInitialValue,
                loginRoleInitialValue);

        // Check getter
        Assert.assertEquals(traderLoginDetails.getEmployeeId(), employeeIdInitialValue);
        Assert.assertEquals(traderLoginDetails.getLoginRole(), loginRoleInitialValue);
        Assert.assertEquals(traderLoginDetails.getLoginStatus(), loginStatusInitialValue);

        String loginStatusModifiedValue = "Success";
        String loginRoleModifiedValue = "Broker";
        String employeeIdModifiedValue = "EMP4321";
        // when value modified.
        traderLoginDetails.setLoginRole(loginRoleModifiedValue);
        traderLoginDetails.setLoginStatus(loginStatusModifiedValue);
        traderLoginDetails.setEmployeeId(employeeIdModifiedValue);

        // Check modified value
        Assert.assertEquals(traderLoginDetails.getEmployeeId(), employeeIdModifiedValue);
        Assert.assertEquals(traderLoginDetails.getLoginRole(), loginRoleModifiedValue);
        Assert.assertEquals(traderLoginDetails.getLoginStatus(), loginStatusModifiedValue);
    }

}


