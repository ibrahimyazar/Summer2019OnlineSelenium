package test.day4_FindElements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TaskPracticeCopnfirmation {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement inputBox = driver.findElement(By.name("email"));
        inputBox.sendKeys("hadrfgyhusa@hotmail.com", Keys.ENTER);
        //WebElement passwordButton = driver.findElement(By.id("form_submit"));  // Keys.ENTER);   easy wayu
      //  passwordButton.click();

        WebElement confirmationmessage = driver.findElement(By.name("confirmation_message"));


        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = confirmationmessage.getText();
        if(actualMessage.equals(expectedMessage)){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
            System.out.println("Expected Url: " + expectedMessage);
            System.out.println("Actual Url: " + actualMessage);
        }
        BrowserUtils.wait(5);

       driver.close();



    }
}
