package test.day8_CheckBox_DropDown_Radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class RadioButtons {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/");
        //<a href="/radio_buttons">Radio Buttons</a> it works only if the elemnets type tag is a
        //linktext works only with <a> elemanets
        driver.findElement(By.linkText("Radio Buttons")).click();


    }

    @Test (description = "Verify taht blue button is selected")
    public void test1(){

        /*//<a href="/radio_buttons">Radio Buttons</a> it works only if the elemnets type tag is a
        //linktext works only with <A> elemanets
        driver.findElement(By.linkText("Radio Buttons")).click();
         */
       WebElement blueButton = driver.findElement(By.id("blue")); // find blue radio button
        // lets verified that radiobutton is selected
        Assert.assertTrue(blueButton.isSelected());  // assert true taht button is selected
       boolean isSelected = blueButton.isSelected();
        System.out.println("Result is for blue button: " + isSelected);

    }
    @Test (description = "Verify taht red button is not selected")
    public void test2(){
        // driver.findElement(By.linkText("Radio Buttons")).click(); ==> we write setup method because we do not need write again and again
        WebElement redButton = driver.findElement(By.id("red"));
        Assert.assertFalse(redButton.isSelected());    // assertfalse will expect that
        boolean isSelected = redButton.isSelected();
        System.out.println("Result is for red button: " + isSelected);

    }

    @Test (description = "Verify taht green button is not available for clickable")
    public void test3(){
        WebElement greenButton = driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled());
        boolean isselect = greenButton.isEnabled();  // isEnable will return true if buttons is available for intereaction
        System.out.println("Result is for green button: " + isselect);


    }
    @Test (description = "click on all radio buttons")
    public void test4(){
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        // lets click only if buttons is not
        for(WebElement buttons: radioButtons){
            if(buttons.isEnabled() && !buttons.isSelected()){
                buttons.click();
                System.out.println("Button clicked: " + buttons.getAttribute("id"));
            }else {
                System.out.println("Button is not clicked: " + buttons.getAttribute("id"));
            }
            BrowserUtils.wait(1); //
        }

    }



    @AfterMethod
    public  void teardown(){
        driver.quit();
    }


}
