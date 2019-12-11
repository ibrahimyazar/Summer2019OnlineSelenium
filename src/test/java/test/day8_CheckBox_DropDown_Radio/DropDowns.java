package test.day8_CheckBox_DropDown_Radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class DropDowns {

    private WebDriver driver;  // instance variable

    //<select id="dropdown">
    //      <option value="" disabled="disabled" selected="selected">Please select an option</option>
    //      <option value="1">Option 1</option>
    //      <option value="2">Option 2</option>
    //    </select>

    //

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Dropdown")).click();
    }

    @Test (description = "select option 2 from the dropdown")
    public void test1(){
        /*
        <select id="dropdown">
      <option value="" disabled="disabled" selected="selected">Please select an option</option>
      <option value="1">Option 1</option>
      <option value="2">Option 2</option>
    </select>
         */
        // to work with select dropdown, we need to use select class in selenium
        //step 1: find dropdown and create wepelement
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        // step 2: create a sellect object
        Select select = new Select(dropdown); // we need to create object
        // to select any option by visible text
        select.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);

        // how to veriyf that option 2 is selectes
        // select.getFirstSelectedOption()   ==> to get select option
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Option 2");
        System.out.println();

    }

    @Test(description = "Print list of states")
    public void State() {
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
        List<WebElement> states = select.getOptions();//will return available options to select
        //how to print every option, as a text, one by one?
        for (WebElement option : states) {
            System.out.println(option.getText());
        }
    }
    @Test(description = "Select your state and verify that state is selected")
    public void test3() {
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
//        <option value="MD">Maryland</option>
        //we can use tes, value or index for selection
        select.selectByValue("PA");
        BrowserUtils.wait(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Pennsylvania");
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }




}
