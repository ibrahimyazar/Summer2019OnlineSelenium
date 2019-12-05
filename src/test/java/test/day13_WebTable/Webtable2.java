package test.day13_WebTable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class Webtable2 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().fullscreen();
       driver.navigate().refresh();
        driver.findElement(By.linkText("Sortable Data Tables")).click();
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table2")));

    }

    @Test(description = "print table two data")
    public void test1(){
       WebElement table2 = driver.findElement(By.id("table2"));
        System.out.println(table2.getText());
    }

    @Test(description = "Verify that number of columns in the second table is equals to 6")
    public void test2(){
        //size = amount of elements
        int expectedColumNumber = 6;
        int actualColumNumber = driver.findElements(By.xpath("//table[@id='table2']//th")).size();
        System.out.println("expected Colum Number: " + expectedColumNumber);
        System.out.println("expected Colum Number: " + actualColumNumber);
        Assert.assertEquals(expectedColumNumber, actualColumNumber, "expected column number and actual column number are not equal");
    }

    @Test(description = "verify that number of row int second table is equals to 5 ")
    public void test3(){
        int expectedRowNumber = 5;
        int actualRowNumber = driver.findElements(By.xpath("//table[@id='table2']//tr")).size();
        System.out.println("expected Colum Number: " + expectedRowNumber);
        System.out.println("expected Colum Number: " + actualRowNumber);
        Assert.assertEquals(expectedRowNumber,actualRowNumber);

        if(expectedRowNumber == actualRowNumber){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
    }

    @Test(description = "Print all values from the 2nd row (excluding table header)")
    public void test4(){
        List<WebElement> Row1 = driver.findElements(By.xpath("//table[@id='table1']//tr[1]"));

        for(WebElement list: Row1){
           System.out.println(list.getText());
       }
        List<WebElement> Row2 = driver.findElements(By.xpath("//table[@id='table1']//tr[2]"));

        for(WebElement list2: Row2){
            System.out.println(list2.getText());
        }

        List<WebElement> Row3 = driver.findElements(By.xpath("//table[@id='table1']//tr[3]"));

        for(WebElement list3: Row3){
            System.out.println(list3.getText());
        }

        List<WebElement> Row4 = driver.findElements(By.xpath("//table[@id='table1']//tr[4]"));

        for(WebElement list4: Row4){
            System.out.println(list4.getText());
        }

    }

    /**
     * Use findElements() to find all values from 2nd row
     * Then iterate through the collection of elements with for each loop
     * Print text of every element from new line
     */
    @Test(description = "Print all values from the 2nd row (excluding table header)")
    public void test5(){
        //List<WebElement> Row2 = driver.findElements(By.xpath("//table[@id='table2']//tr[2]"));  // Bach Frank fbach@yahoo.com $51.00 http://www.frank.com edit delete
        List<WebElement> Row2 = driver.findElements(By.xpath("//table[@id='table2']//tbody//tr[2]//td"));
        for (WebElement cell : Row2) {
            System.out.println(cell.getText());
        }

        WebElement Text1 = driver.findElement(By.xpath("//table[@id='table2']//tbody//tr[1]//td[1]"));
        String ActualText = Text1.getText();
        String ExpectedText = "Smith";
        System.out.println(ActualText);
        System.out.println(ExpectedText);
        Assert.assertEquals(ActualText,ExpectedText);

        WebElement Text2 = driver.findElement(By.xpath("//table[@id='table2']//tbody//tr[3]//td[3]"));
        String ActualEmail = Text2.getText();
        String ExpectedEnail = "jdoe@hotmail.com";
        Assert.assertEquals(ActualEmail, ExpectedEnail);



    }








    @AfterMethod
    public void tearDown(){
        driver.close();
    }





}
