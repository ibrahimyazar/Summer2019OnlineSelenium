package test.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestForLinkText {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/");

        //<a href="/autocomplete">Autocomplete</a>
        driver.findElement(By.linkText("Autocomplete")).click();

        BrowserUtils.wait(3);

       // Thread.sleep(3000);

        driver.quit();

    }
}
