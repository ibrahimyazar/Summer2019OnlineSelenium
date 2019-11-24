package test.day10_PopUp_fileUploading_SwichWindows;

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
        //to deal with popup, we can create object of Alert
        //Switches to the currently active modal dialog
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
        //[2] means second button out of available, since there are 3 buttons
        //I use [index]
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

    @Test(description = "Click on button 3, enter some text and then click OK")
    public void test3() throws InterruptedException {

        driver.findElement(By.linkText("JavaScript Alerts")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();  // or By.Xpatxt  "button[onclick='jsPrompt()']"
        BrowserUtils.wait(3);
        driver.switchTo().alert().sendKeys("hello ibrahim");
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        //to print text of result
        //should be Java is fun!
        System.out.println(driver.findElement(By.id("result")).getText());
        BrowserUtils.wait(2);



    }


    @AfterMethod
    public  void tearDown(){
        driver.quit();

    }


}
