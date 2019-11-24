package test.day10_PopUp_fileUploading_SwichWindows;

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
        //after 3 seconds, another website will be opened,in the second window
        //selenium doesn't switch automatically to the new window
        BrowserUtils.wait(5);
        System.out.println(driver.getTitle());

    }

    @Test(description = "verify that user is able to see new window")
    public void Test3(){
        driver.findElement(By.linkText("New tab")).click();
        //record id of original window, that we opened initially
        String oldWindow = driver.getWindowHandle();
        //after 3 seconds, another website will be opened,in the second window
        //selenium doesn't switch automatically to the new window
        BrowserUtils.wait(5);
        //in the selenium every window has an id. That id calls window handle
        //to read window handle we use a method getWindowHandle()
        //after new window was opened, we can get list of all window id's/window handles
        //list - it's a data structure
        //set it's also a data structure, like list, but it doesn't allow duplicates
        //also, you cannot easily access anything from there
        //there is no .get() method
        //that's why, we need to loop through the set, to read a data from there
        //set can store only unique values
        //set can store only unique values
        //getWindowHandles() return collection of window id's that are currently opened by webdriver

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
        for(String windowhandle: windowHandles){  ////keep jumping from window to window
            driver.switchTo().window(windowhandle);  // //once we found a correct page title
            if(driver.getTitle().equals(pageTitle));
            //just exit
            //stop jumping

            break;

        }

    }



    @AfterMethod
    public void tearDown(){
    driver.quit();
    }


}
