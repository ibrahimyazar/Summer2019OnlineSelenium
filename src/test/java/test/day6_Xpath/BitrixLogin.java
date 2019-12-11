package test.day6_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserUtils;

public class BitrixLogin {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        driver.manage().window().fullscreen();
        // find Userename box
       WebElement UserNameBox = driver.findElement(By.xpath("//input[@type = 'text']"));
       // find password box
       WebElement PassWordBox = driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']"));
       // enter email
       UserNameBox.sendKeys("yazarusa@hotmail.com");
       // enter password
       PassWordBox.sendKeys("12345");
       // find submit box
       WebElement SubmitBottun = driver.findElement(By.xpath("//input[@type = 'submit']"));
       // click the submit box
       SubmitBottun.click();
        BrowserUtils.wait(2);

        String ActualFResult = "Incorrect login or password";
        WebElement Error = driver.findElement(By.xpath("//div[contains(text(),'Incorrect')]"));
        String Errortext = Error.getText();
        System.out.println(Errortext);
        if (ActualFResult.equals(Errortext)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println(ActualFResult);
            System.out.println(Errortext);
        }

       driver.quit();

    }
}
