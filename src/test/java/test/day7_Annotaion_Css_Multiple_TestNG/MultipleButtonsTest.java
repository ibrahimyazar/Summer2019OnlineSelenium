package test.day7_Annotaion_Css_Multiple_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class MultipleButtonsTest {

    private WebDriver driver;  // we need to crate instance variable.

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().fullscreen();
        BrowserUtils.wait(2);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){
        driver.findElement(By.linkText("Multiple Buttons")).click();
        driver.findElement(By.xpath("//*[text()='Button 1']")).click();
        String Expectedresult = "Clicked on button one!";
        String Actualresult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(Actualresult, Expectedresult, "Expected result is not correct");
    }


}
