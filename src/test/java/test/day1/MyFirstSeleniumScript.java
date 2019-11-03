package test.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {

    public static void main(String[] args) {
        // we have to set up webdrivern based on the browser that we gona use
        WebDriverManager.chromedriver().setup();
        // we need to create an object ofappropriate calss
        ChromeDriver driver = new ChromeDriver();
        // now open google.com
        // .get() method allows to open some website
        driver .get("http://google.com");

        String actualResult = driver.getTitle();
        String expectedResult = "Google";
        if (actualResult.equals(expectedResult)){
            System.out.println("Test past");

        }else {
            System.out.println("google");
            System.out.println(driver.getTitle());

            System.out.println("Fail");
        }
        driver.close();

    }
}
