package test.exercisis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.sql.SQLOutput;

public class NavigationTest {

    public static void main(String[] args) {
        /*
        Open browser
        2.Go to website https://google.com
        3.Save the title in a string variable
        4.Go to https://etsy.com
        5.Save the title in a string variable
        6.Navigate back to previous page
        7.Verify that title is same is in step 3
        8.Navigate forward to previous page
        9.Verify that title is same is in step 5
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://google.com");
        driver.manage().window().fullscreen();
        String GTitle = driver.getTitle();
        System.out.println("Title of Google: " + GTitle);
        driver.navigate().to("https://etsy.com");
        String ETitle = driver.getTitle();
        System.out.println("Etsy Title: " + ETitle);
        driver.navigate().back();
        String actualTitle = driver.getTitle();


        if (actualTitle.equals(GTitle)){
            System.out.println("Titles are same");
            System.out.println("Test Passed");
        }else{
            System.out.println("Test failed");
            System.out.println("Excepting Result: " + GTitle);
            System.out.println("Actual Title: " + actualTitle);

        }

        driver.navigate().forward();
        driver.getTitle();
        String actualTitle2 = driver.getTitle();
        if(actualTitle2.equals(ETitle)) {
            System.out.println("Titles are same");
            System.out.println("Test Passed");
        }else{
            System.out.println("Test failed");
            System.out.println("Excepting Result: " + ETitle);
            System.out.println("Actual Title: " + actualTitle2);
        }

        driver.close();
    }
}
