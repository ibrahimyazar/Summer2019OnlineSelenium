package test.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;

public class WindowSwicthing {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().fullscreen();
    }

    @Test
    public void Test1(){
        driver.findElement(By.linkText("New tab")).click();
        BrowserUtils.wait(5);
        System.out.println(driver.getTitle());

    }


    @Test
    public void Test2(){
        driver.findElement(By.linkText("Dynamic Content")).click();
        BrowserUtils.wait(5);
        System.out.println(driver.getTitle());

    }

    @Test(description = "verify that user is able to see new window")
    public void Test3(){
        driver.findElement(By.linkText("New tab")).click();
        String oldWindow = driver.getWindowHandle();
        BrowserUtils.wait(5);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowhandle: windowHandles){
            if(!windowhandle.equals(oldWindow)){
                driver.switchTo().window(windowhandle);
            }
        }
        // lets verify taht tite

        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Fresh tab", "Tittle is wrong");
        // come back to original page

        String pageTitle = "Practice";
        for(String windowhandle: windowHandles){
            driver.switchTo().window(windowhandle);
            if(driver.getTitle().equals(pageTitle));
                    break;

        }

    }



    @AfterMethod
    public void tearDown(){
    driver.quit();
    }


}
