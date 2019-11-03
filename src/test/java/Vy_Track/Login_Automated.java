package Vy_Track;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import javax.swing.*;
import java.sql.SQLOutput;

public class Login_Automated {

    public static void main(String[] args) {


//• Go to the login page of VyTrack ==> https://qa2.vytrack.com/user/login
//• Enter valid credential (can be any role) •  storemanager225 , storemanager226 , storemanager227 password UserUser123
      //  user name salesmanager288 , salesmanager289 , salesmanager290  ,user189 , user190
// Click login button
//• Verify that the user login successfully

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");  //  why we use the get method navigation that o?????? get method loaded the all page and continiu
        driver.manage().window().fullscreen();
        WebElement usernameBox = driver.findElement(By.name("_username"));
        usernameBox.sendKeys("storemanager225");
        BrowserUtils.wait(2);
        WebElement passwordBox = driver.findElement(By.name("_password"));
        passwordBox.sendKeys("UserUser123");
        BrowserUtils.wait(2);
        WebElement loginbottun = driver.findElement(By.id("_submit"));
        loginbottun.click();
        String expectingresult = "https://qa2.vytrack.com/";
        String actualResult = driver.getCurrentUrl();
        if(actualResult.equals(expectingresult)){
            System.out.println("Test passed");
            System.out.println("URL is: " + actualResult);
        }else {
            System.out.println("Test Failed");
            System.out.println("Expected Result: " + expectingresult);
            System.out.println("Actual Result: " + actualResult);
        }

        String expectedtitle = "Dashboard";
        String actualtitle = driver.getTitle();
        if(actualtitle.equals(expectedtitle)){
            System.out.println("Test passed");
           // System.out.println("URL is: " + actualResult);
        }else {
            System.out.println("Test Failed");
            System.out.println("Expected Title: " + expectedtitle);
            System.out.println("Actual Title: " + actualtitle);
        }


        BrowserUtils.wait(3);
        driver.close();

    }
}
