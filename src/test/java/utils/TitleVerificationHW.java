package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerificationHW {

    //private static WebDriver driver;
   // public WebDriver driver;
    /*
    1. Create a new class TitleVerification under utilities package and create a main method.
2. Add this ArrayList declaration to the main method:
3. Open chrome browser
4. Visit all the websites from step 3 and verify that they all have the same title.
5. Verify that all URLs of all pages start with http://practice.cybertekschool.com.
6. Close the browser at the end of the test.
     */

    public static void main(String[] args) {

        List<String> urls =Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

       // driver = BrowserFactory.getDriver("chrome");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");




    }

}
