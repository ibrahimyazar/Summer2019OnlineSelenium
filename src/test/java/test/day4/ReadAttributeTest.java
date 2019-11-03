package test.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class ReadAttributeTest {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement input = driver.findElement(By.name("email"));

        System.out.println(input.getAttribute("pattern"));
        input.sendKeys("randomemails@email.com");
        System.out.println(input.getAttribute("value"));
        WebElement retreviePasswordButton = driver.findElement(By.id("form_submit"));
        String expectetresult1 = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$";
        String expectedresult2 = "randomemails@email.com";
        if(expectetresult1.equals(input.getAttribute("pattern")) && expectedresult2.equals(input.getAttribute("value"))) {
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
        retreviePasswordButton.submit();
        BrowserUtils.wait(5);
        driver.close();



    }


}
