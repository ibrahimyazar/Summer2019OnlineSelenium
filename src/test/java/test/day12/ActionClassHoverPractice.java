package test.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import javax.swing.*;

public class ActionClassHoverPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Hovers")).click();
        driver.manage().window().fullscreen();
    }

    @Test(description = "Verify first image")
    public void test1() {
        //create object of actions class to perform actions (drag and drop, context click, move to specific point, etc...)
        Actions action = new Actions(driver);
        //or [class='figure']:nth-of-type(1) nth means 8th, 7th, 4th child....
        WebElement image1 = driver.findElement(By.cssSelector(".figure:nth-of-type(1)"));
        //just to hover on element not click
        // build() is required when we have more than 1 action in a chain
        //without .perform(); it will not work
        // moveToElement = hover
        // .perform() stands for triggering actions
        action.moveToElement(image1).perform();
        BrowserUtils.wait(4);//for demo
        // h5 is a grand child of .figure:nth-of-type(1) this element that contains image
        WebElement textOfImageElement = driver.findElement(By.cssSelector(".figure:nth-of-type(1) h5"));
        String expectedText = "name: user1";
        BrowserUtils.wait(3);
        String actualText = textOfImageElement.getText();
        Assert.assertEquals(actualText, expectedText);
    }
    @Test(description = "Verify all images")
    public void test2() {
        Actions action = new Actions(driver);
        for (int i = 1; i <= 3; i++) {
            action.moveToElement(driver.findElement(By.cssSelector(".figure:nth-of-type(" + i + ")"))).perform();
            BrowserUtils.wait(4);
            String name = driver.findElement(By.cssSelector(".figure:nth-of-type(" + i + ") h5")).getText();
            BrowserUtils.wait(4);
            System.out.println(name);
            Assert.assertEquals(name, "name: user" + i);
            BrowserUtils.wait(2);
        }
    }

    @Test(description = "Verify first image")
    public void Test1(){
        //create object of actions class to perform actions (drag and drop, context click, move to specific point, etc...)
        Actions action = new Actions(driver);

        WebElement image1 = driver.findElement(By.cssSelector(".figure:nth-of-type(1)"));
        //just to hover on element not click
        // build() is required when we have more than 1 action in a chain
        action.moveToElement(image1).perform();

        BrowserUtils.wait(3);
        String ExpectingText = "name: user1";
        String ActualText = driver.findElement(By.xpath("//*[text()='name: user1']")).getText();
        System.out.println("Actual Result: " + ActualText);
        System.out.println("Expecting Result: " + ExpectingText);
        //Assert.assertEquals(ExpectingText, ActualText);
        Assert.assertEquals(ActualText, ExpectingText);

        BrowserUtils.wait(3);
    }

    @Test(description = "Click With JS executer")
    public void Test3(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading");



    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
