package test.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TaskPractice {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement inputBox = driver.findElement(By.name("email"));
        inputBox.sendKeys("randomemaila@hotmail.com");
        WebElement passwordButton = driver.findElement(By.id("form_submit"));
        passwordButton.click();

        String expectedurl =  "http://practice.cybertekschool.com/email_sent";
        String actualurl = driver.getCurrentUrl();
        if(expectedurl.equalsIgnoreCase(actualurl)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test faild");
            System.out.println("Expected URL: " + expectedurl);
            System.out.println("Actual URL: " + actualurl);
        }

        BrowserUtils.wait(5);
        driver.close();



    }
}
