package Vy_Track;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import test.TestBase;

public class CalenderEventTest_PO extends TestBase {

    @Test(description = "Verify that page subtitle is equals to 'ALL Calendar Events'")
    public void test1() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("storemanager85", "UserUser123");
        loginPage.navigateTo("Activities", "Calendar Events");
        String expectedSubtitle = "All Calendar Events";
        String actualSubTitle = loginPage.getPageSubTitle();
        Assert.assertEquals(actualSubTitle, expectedSubtitle);
    }
}
