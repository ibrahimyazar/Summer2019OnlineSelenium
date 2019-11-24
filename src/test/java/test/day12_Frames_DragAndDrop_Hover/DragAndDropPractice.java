package test.day12_Frames_DragAndDrop_Hover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DragAndDropPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().fullscreen();
    }

    @Test
    public void Test(){

        Actions action = new Actions(driver);
        WebElement SmallBall = driver.findElement(By.id("draggable"));
        WebElement BigBall = driver.findElement(By.id("droptarget"));
        action.dragAndDrop(SmallBall, BigBall).perform();

        BrowserUtils.wait(3);
        driver.quit();


    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
