package test.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TaskPracticURL {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement inputBox = driver.findElement(By.name("email"));
        inputBox.sendKeys("hadrfgyhusa@hotmail.com");
        WebElement passwordButton = driver.findElement(By.id("form_submit"));
        passwordButton.click();

        String expectedUrl = "http://practice.cybertekschool.com/email_sent";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.equals(expectedUrl)){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
            System.out.println("Expected Url: " + expectedUrl);
            System.out.println("Actual Url: " + actualUrl);
        }
        BrowserUtils.wait(5);

        driver.quit();

        WebDriver driver1 = BrowserFactory.getDriver("chrome");
        driver1.get("http://youtube.com");
        WebElement input = driver1.findElement(By.name("search_query"));
        BrowserUtils.wait(3);
        input.sendKeys("dandini dandini dastana", Keys.ENTER);
        BrowserUtils.wait(5);
        String expectedurl = "https://www.youtube.com/results?search_query=dandini+dandini+dastana";
        String actualurl = driver1.getCurrentUrl();
        if(expectedurl.equalsIgnoreCase(actualurl)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test faild");
            System.out.println("Expected URL: " + expectedurl);
            System.out.println("Actual URL: " + actualurl);
        }

        WebElement tik = driver1.findElement(By.id("video-title"));
        tik.click();
        BrowserUtils.wait(2);
        //driver1.quit();



    }
}
