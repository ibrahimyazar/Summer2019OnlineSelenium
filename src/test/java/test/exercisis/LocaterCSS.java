package test.exercisis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class LocaterCSS {
   private WebDriver driver;
   private WebDriverWait wait;

   @BeforeMethod
    public void setup() throws InterruptedException {
       driver = BrowserFactory.getDriver("chrome");
       driver.get("http://practice.cybertekschool.com/");
       driver.manage().window().fullscreen();
       Thread.sleep(1000);
   }

   @Test
   public void Test1(){
       driver.findElement(By.linkText("Registration Form")).click();
       driver.findElement(By.cssSelector("input[name = 'firstname']")).sendKeys("Ibrahim");
       driver.findElement(By.cssSelector("input[name = 'lastname']")).sendKeys("yazar");
       driver.findElement(By.cssSelector("input[name = 'username']")).sendKeys("iyazar");
       driver.findElement(By.cssSelector("input[name = 'email']")).sendKeys("iyazar@email.com");
       driver.findElement(By.cssSelector("input[name = 'password']")).sendKeys("12345");
       driver.findElement(By.cssSelector("input[name = 'phone']")).sendKeys("0987654321");
       driver.findElement(By.cssSelector("input[value = 'male']")).click();
       driver.findElement(By.cssSelector("input[name = 'birthday']")).sendKeys("01/01/2000");
       Select select = new Select(driver.findElement(By.cssSelector("select[name = 'department']")));
                select.selectByVisibleText("Tresurer's Office");
       Select select2 = new Select(driver.findElement(By.cssSelector("select[name = 'job_title']")));
                select2.selectByVisibleText("SDET");
        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
   }




   @AfterMethod
    public void teardown(){
       driver.close();
   }

}
