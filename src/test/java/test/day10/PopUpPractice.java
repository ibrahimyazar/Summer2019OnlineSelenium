package test.day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PopUpPractice {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().fullscreen();

    }
    @Test(description = "Click on button 1 and click ok in pop up message")
    public void test1(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[1]")).click();
        BrowserUtils.wait(3);
        // driver.switchTo().alert().accept();  //or
        Alert alert = driver.switchTo().alert();
        String ActualResult = alert.getText();
        System.out.println(alert.getText());
        alert.accept();   // to click
        BrowserUtils.wait(2);
        String expectedResult = "You successfuly clicked an alert";





    }
    @Test(description = "Click on button 2 and click cancel in pop up message")
    public void test2(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click(); // //button[2]  or //button[text()='Click for JS Confirm'] or
        BrowserUtils.wait(2);
       // driver.switchTo().alert().dismiss();  //or
        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());
        alert.dismiss();
        BrowserUtils.wait(3);
        String expectedResult = "You clicked: Cancel";
        String actualResult = driver.findElement(By.id("result")).getText();
        System.out.println(actualResult);
        System.out.println(expectedResult);
        Assert.assertEquals(actualResult, expectedResult, "Test failed");


    }


    @AfterMethod
    public  void tearDown(){
        driver.quit();

    }


}
