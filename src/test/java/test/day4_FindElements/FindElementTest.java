package test.day4_FindElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FindElementTest {

    public static void main(String[] args) {

        WebDriver driver1 = BrowserFactory.getDriver("Firefox");
        driver1.get("http://practice.cybertekschool.com/forgot_password");
        BrowserUtils.wait(10);
        driver1.close();


        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String expectedTitle = driver.getTitle();
        // step1  open ispector in chrome and find locator for the ekement
        // step2  Create object of Webelemnet
        //  step3  use webelemnet
        WebElement passwordbutton = driver.findElement(By.id("form_submit"));
        // to click on the elemnet
        passwordbutton.click();
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test passed");
        } else {
                System.out.println("Test failed");
                System.out.println("Expected Title: " + expectedTitle);
                System.out.println("Actual Title: " + actualTitle);
            }

        BrowserUtils.wait(10);
        driver.close();








    }

}
