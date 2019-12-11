package test.day7_Annotaion_Css_Multiple_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGPractice {


    @Test
    public void test(){
        Assert.assertEquals("apple", "apple","Word is not correct! should be apple");

    }
    @Test  (description = "Verifyinmg title of tyhe practice website")
    public void VerifyTitle(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        String ExpectedTitle = "Practice";
        String ActualTitle = driver.getTitle();
        Assert.assertEquals(ActualTitle, ExpectedTitle, "Title is not same");
        driver.quit();


    }
    @Test (description = "verify that heading is displayed")
    public void verifyHeadingIsDisplayed(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        WebElement heading = driver.findElement(By.xpath("//span[text() = 'Test Automation Practice']"));
        // to make sure is that elemnet is visible to user
        Assert.assertTrue(heading.isDisplayed(), "heading is not match");
        driver.quit();


    }



}
