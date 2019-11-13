package test.exercisis;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EllaIcinNinni {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://youtube.com");
        WebElement input = driver.findElement(By.name("search_query"));
        BrowserUtils.wait(3);
        input.sendKeys("dandini dandini dastana", Keys.ENTER);
        BrowserUtils.wait(5);
        String expectedurl = "https://www.youtube.com/results?search_query=dandini+dandini+dastana";
        String actualurl = driver.getCurrentUrl();
        if(expectedurl.equalsIgnoreCase(actualurl)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test faild");
            System.out.println("Expected URL: " + expectedurl);
            System.out.println("Actual URL: " + actualurl);
            System.out.println(actualurl);
    
        }

        WebElement tesla = driver.findElement(By.id("video-title"));
        tesla.click();

        //
        // BrowserUtils.wait(2);



    }
}
