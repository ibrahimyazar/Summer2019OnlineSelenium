package Vy_Track;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import test.TestBase;
import utils.BrowserUtils;

public class CalenderEventTest_PO extends TestBase {

    @Test(description = "Verify that page subtitle is equals to 'ALL Calendar Events'")
    public void test1() {

        // this step is required for every test
        // othrvise you will get nullpiontr  exception
        // you must create a test at the beginiong
        extentTest = extentReports.createTest("Verify that page subtitle is equals to 'ALL Calendar Events");

        LoginPage loginPage = new LoginPage();

        loginPage.login("storemanager85", "UserUser123");
        loginPage.navigateTo("Activities", "Calendar Events");

        String expectedSubtitle = "All Calendar Events";
        String actualSubTitle = loginPage.getPageSubTitle();
        Assert.assertEquals(actualSubTitle, expectedSubtitle);

        extentTest.pass("Verify that page subtitle is equals to 'ALL Calendar Events");  // indicate that test succesfull
    }
}
