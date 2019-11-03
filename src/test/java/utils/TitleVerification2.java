package utils;

import org.openqa.selenium.WebDriver;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://lulugandgeorgia.com",
                "https://wayfair.com/", "https://walmart.com", "https:// westelm.com/");

        /*
3. Visit all websites one by one.
4. Verify that URL of the website contains the title of the website. Ignore spaces and case
in comparison. For example, title of in the first website title is Lulu and Giorgia and the
URL is https://lulugandgeorgia.com. So, this test case must pass.
5. Close the browser at the end of the test.
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://lulugandgeorgia.com");
        driver.manage().window().fullscreen();
        String Url1 = driver.getCurrentUrl();
        String Title1 = driver.getTitle().replace(" ", "").toLowerCase();
        BrowserUtils.wait(2);
        driver.get("https://wayfair.com/");
        String Url2 = driver.getCurrentUrl();
        String Title2 = driver.getTitle().replace(" ", "").toLowerCase();
       // Stirng Title22 = Title2.dublicated()
        BrowserUtils.wait(2);
        driver.get("https://walmart.com");
        String Url3 = driver.getCurrentUrl();
        String  Title3 = driver.getTitle().replace(" ", "").toLowerCase();
        BrowserUtils.wait(2);
        driver.get("https://westelm.com/");
        String Url4 = driver.getCurrentUrl();
        String Title4 = driver.getTitle().replace(" ", "").toLowerCase();

        if(Url1.contains(Title1)){
            System.out.println("Test Passed");
            System.out.println(Url1);
            System.out.println(Title1);
        }else{
            System.out.println("Test failed");
            System.out.println(Url1);
            System.out.println(Title1);
        }
        if(Url2.contains(Title2)){
            System.out.println("Test Passed");
            System.out.println(Url2);
            System.out.println(Title2);
        }else{
            System.out.println("Test failed");
            System.out.println(Url2);
            System.out.println(Title2);
        }
        if(Url3.contains(Title3)){
            System.out.println("Test Passed");
            System.out.println(Url3);
            System.out.println(Title3);
        }else{
            System.out.println("Test Failed");
            System.out.println(Url3);
            System.out.println(Title3);
        }
        if(Url4.contains(Title4)){
            System.out.println("Test Passed");
            System.out.println(Url4);
            System.out.println(Title4);
        }else{
            System.out.println("Test failed");
            System.out.println(Url4);
            System.out.println(Title4);
        }

        BrowserUtils.wait(2);
        driver.close();


    }

}
