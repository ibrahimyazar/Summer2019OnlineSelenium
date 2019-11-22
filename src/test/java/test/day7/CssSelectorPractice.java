package test.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class CssSelectorPractice {

    public static void main(String[] args) {
        // WHICH LOCATER TO USE
        // #1 id
        // #2 CSS
        // #3 xpath
        // ## wahtever
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/multiple_buttons");
        // find all the buttom and click by one one
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        // List<WebElement> buttons = driver.findElements(By.cssSelector("[class =' btn btn-primary']"));

        for(WebElement element: buttons) {
            element.click();
            BrowserUtils.wait(1);
            // get the message after click
            WebElement message = driver.findElement(By.cssSelector("#result"));
            System.out.println(message.getText());
        }

        WebElement Header = driver.findElement(By.cssSelector(".container>h3"));
        System.out.println(Header.getText());
        driver.quit();


    }


}
