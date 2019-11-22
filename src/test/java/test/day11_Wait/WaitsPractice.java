package test.day11_Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitsPractice {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().fullscreen();
    }

    @Test(description = "Implicit Wait")
    public void test(){
        // this line should be before all findelemnet methods
        // we apply it onece and it always works
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Dynamic Loading")).click();

        driver.findElement(By.partialLinkText("Example 2")).click();

        driver.findElement(By.tagName("button")).click();  // click on start button

        // this is for "Hello World"
        WebElement finishElement = driver.findElement(By.id("finish"));

        System.out.println(finishElement.getText());

    }

    @Test(description = "Expilicit Wait")
    public  void Test2(){

        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 1:")).click();  //  select example 1     partial links like contains
        driver.findElement(By.tagName("button")).click();  // click on start button

        // we find element firs but, elemnets can be present but not visibnle
        WebElement userNameInputBox = driver.findElement(By.id("username"));

        // we must privide Webdriver bject and period of time.
        WebDriverWait Wait = new WebDriverWait(driver, 10);  // we create the object for applied explicit wait
        // ho=w to applied condition

        Wait.until(ExpectedConditions.visibilityOf(userNameInputBox));
        userNameInputBox.sendKeys("tomsmith");  // enter username

        WebElement passwordInputBox = driver.findElement(By.id("pwd"));

       //  WebDriverWait Wait = new WebDriverWait(driver, 10); we create allready and we do not need create again
        Wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");

        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));   // by cssselecteor button[type='submit']
        Wait.until(ExpectedConditions.visibilityOf(submit));
        submit.click();

        String ExpectingMessage = "Welcome to the Secure Area. When you are done click logout below.";
        WebElement Maessage =  driver.findElement(By.tagName("h4"));
        Wait.until(ExpectedConditions.visibilityOf(Maessage));
        String ActualMessage =  Maessage.getText();

       System.out.println("Actual message is: " + ActualMessage);

       // Assert.assertEquals(ExpectingMessage, ActualMaessage);

        Assert.assertEquals(ActualMessage, ExpectingMessage);



    }


    @Test(description = "Fluent wait example")
    public void test4() {
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 2")).click();
        driver.findElement(By.tagName("button")).click();
        Wait wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class);
        WebElement message = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("finish"));
            }
        });
    }





    @AfterMethod
    public void teardown(){
        driver.quit();
    }



}
