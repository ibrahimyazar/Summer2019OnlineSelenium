package Vy_Track;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import test.TestBase;

public class SmokeTest extends TestBase {

    @Test(dataProvider = "navigationInfo")
    public void smokeTest(String moduleName, String subModuleName, String pageSubTitle){
        extentTest = extentReports.createTest("Verify that page subtitle is equals to "+pageSubTitle);

        LoginPage loginPage = new LoginPage();
        loginPage.login("storemanager85", "UserUser123");

        // video  // 12/12/2019  time is 15:15 pm
        loginPage.navigateTo(moduleName, subModuleName);  // it is there coming from base page    WebElement subModule = Driver.get().findElement(By.xpath(subModuleLocator));

        // //wait for page subtitle
        loginPage.waitUntilLoaderMaskDisappear();
        //  video 12/12/2019  time is 15:14 pm
        loginPage.waitForPageSubTitle(pageSubTitle);  // it is wait until the text it is there coming from base page  public void waitForPageSubTitle(String pageSubtitleText) {

        Assert.assertEquals(loginPage.getPageSubTitle(), pageSubTitle);
        System.out.println("Page Title is: " + pageSubTitle);

        extentTest.pass("Verified that page subtitle '"+pageSubTitle+"' is displayed");

    }

    @DataProvider(name = "navigationInfo")
    public Object[][] navigationInfo(){
        return new Object[][]{
                {"Dashboards", "Dashboard", "Dashboard"},
                {"Dashboards", "Manage Dashboards", "All Manage Dashboards"},
                {"Fleet", "Vehicles", "All Cars"},
                {"Customers", "Accounts", "All Accounts"},
                {"Activities", "Calls", "All Calls"},
                {"Activities", "Calendar Events", "All Calendar Events"},
                {"Sales", "Opportunities", "Open Opportunities"},
                {"Marketing", "Campaigns", "All Campaigns"},
                {"Marketing", "Email Campaigns", "All Email Campaigns"},
        };
    }


}
