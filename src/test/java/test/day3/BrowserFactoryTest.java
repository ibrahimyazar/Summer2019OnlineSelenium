package test.day3;


import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class BrowserFactoryTest {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        // how we print source
        System.out.println(driver.getPageSource());
        // to finish test execution
        driver.quit();




    }
}
