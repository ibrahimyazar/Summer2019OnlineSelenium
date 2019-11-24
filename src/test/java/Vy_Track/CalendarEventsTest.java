package Vy_Track;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class CalendarEventsTest {
    /*
    Test data
url: https://qa1.vytrack.com/
username: storemanager85
password: UserUser123
###Test case #1
Go to https://qa1.vytrack.com/
Login as a store manager
Navigate to Activities -> Calendar Events
Verify that page subtitle "All Calendar Events" is displayed
Collapse

     */

    private WebDriver driver;
    private WebDriverWait wait;  // like implicit wait

    @BeforeMethod
    public void setUp(){

        driver = BrowserFactory.getDriver("Chrome");
        // explicit wait
        wait = new WebDriverWait(driver, 10);
        // implicit Wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();


    }



}
