package test.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class AbsoluteXpathTest {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().fullscreen();
        BrowserUtils.wait(2);
        driver.findElement(By.id("prependedInput")).sendKeys("sdf");
        driver.findElement(By.id("prependedInput2")).sendKeys("sdd");
        driver.findElement(By.id("_submit")).click();
        BrowserUtils.wait(2);
       WebElement WarmmiongMesage =  driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/form/fieldset/div[1]/div"));

        System.out.println( WarmmiongMesage.getText());

       driver.close();




    }


}
