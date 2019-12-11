package test.day8_CheckBox_DropDown_Radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class CheckBoxes {

    // command +obtion + l to organize code
    // private because will be used only in this class
    private WebDriver driver;
    private WebDriver driver2;

    @BeforeMethod
    public void setup() {
       driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().fullscreen();
        driver.findElement(By.linkText("Checkboxes")).click();

       driver2 = BrowserFactory.getDriver("Firefox");
        driver2.get("http://practice.cybertekschool.com/");
        driver2.manage().window().fullscreen();
        driver2.findElement(By.linkText("Checkboxes")).click();

    }

    @Test (description = "")
    public void test1(){
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        int index = 0;
        for(WebElement checkbox: checkboxes){
            if(checkbox.isEnabled() && !checkbox.isSelected()){
                checkbox.click();
                System.out.println("Checkbox clicked: " + index);
            }else{
                System.out.println("Checkbox is not clicked: " + index);
            }
            index++;
        }


        List<WebElement> checkboxes2 = driver2.findElements(By.cssSelector("[type='checkbox']"));
       int index2 = 1;
        for(WebElement checkbox2: checkboxes2){
            if(checkbox2.isEnabled() && !checkbox2.isSelected()){
                checkbox2.click();
                System.out.println("Checkbox clicked: " + index2);
            }else{
                System.out.println("Checkbox is not clicked: " + index2);

            }
            index2++;
        }

    }





    @AfterMethod
    public void tearDown() {
        driver.quit();
        driver2.quit();

    }


}
