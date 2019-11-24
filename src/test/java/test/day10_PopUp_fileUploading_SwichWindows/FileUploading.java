package test.day10_PopUp_fileUploading_SwichWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FileUploading {
    // 183 -109
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().fullscreen();

    }

    @Test(description = "verify that file was uploaded")
    public void test1(){
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/Users/banu/Desktop/Screen Shot 2019-09-26 at 4.34.15 PM.png");
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(5);

        String expectedresult = "Screen Shot 2019-09-26 at 4.34.15 PM.png";
        String ActulaResult =  driver.findElement(By.id("uploaded-files")).getText();
        System.out.println("Actual result: " + ActulaResult);
        System.out.println("Expected result: " + expectedresult);
        Assert.assertEquals(expectedresult, ActulaResult);


    }

    @AfterMethod
    public  void tearDown(){
        driver.quit();

    }


}
