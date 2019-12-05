package Vy_Track;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import test.TestBase;
import utils.Driver;

public class LoginTest extends TestBase {  // we extends TestBase class to inherit Before and After test methods

    @Test(description = "verifired that page title is a'Dashboard' ")
    public void test1(){
        LoginPage loginPage = new LoginPage();  // we create login page object
        loginPage.login("storemanager225", "UserUser123");
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        Assert.assertEquals(Driver.get().getTitle(), "Dashboard");

        System.out.println(Driver.get().getTitle());
        System.out.println(Driver.get().getCurrentUrl());
        System.out.println(Driver.get().getPageSource());


}



}
