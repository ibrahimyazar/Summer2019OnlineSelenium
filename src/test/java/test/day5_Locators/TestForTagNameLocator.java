package test.day5_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestForTagNameLocator {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.manage().window().fullscreen();
        driver.findElement(By.name("full_name")).sendKeys("Test user");
        driver.findElement(By.name("email")).sendKeys("Tsetemail@gmail.com");
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtils.wait(3);

        WebElement sub_header = driver.findElement(By.tagName("h3"));
        System.out.println(sub_header.getText());

        driver.quit();

    }

}
