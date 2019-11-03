package utils;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        /*
3. Open chrome browser
4. Visit all the websites from step 3 and verify that they all have the same title.
5. Verify that all URLs of all pages start with http://practice.cybertekschool.com.
6. Close the browser at the end of the test.
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().fullscreen();
        driver.get("http://practice.cybertekschool.com/");
        String Url1 = driver.getCurrentUrl();
        int end1 = Url1.lastIndexOf("/");
        BrowserUtils.wait(2);
        driver.get("http://practice.cybertekschool.com/dropdown");
        String Url2 = driver.getCurrentUrl();
        int end2 = Url2.lastIndexOf("/");
        BrowserUtils.wait(2);
        driver.get("http://practice.cybertekschool.com/login");
        String Url3 = driver.getCurrentUrl();
        int end3 = Url3.lastIndexOf("/");
        BrowserUtils.wait(2);

        String ExpectedUrl = "http://practice.cybertekschool.com";

        if (ExpectedUrl.equals(Url1.substring(0, end1)) && ExpectedUrl.equals(Url2.substring(0, end2)) && ExpectedUrl.equals(Url3.substring(0,end3)) ) {
            System.out.println("Test Passed");
        }

        BrowserUtils.wait(2);
        driver.close();


    }
}
