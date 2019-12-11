package test.day7_Annotaion_Css_Multiple_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class WarmUpFindLinks {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/");
        //how to find all links?
        //every link as a tag name <a>
        // find the links  every links has a tag name <a>
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        //size of the list = number of links
        // findElement vs findElements
        // in case of find element, if there is no element found, you will exception
        // size of the list
        //size of the list = number of links
        // findElement vs findElements
        // in case of find element, if there is no element found, you will exception
        //NoSuchElementException
        // findElement = only 1 webelements
        // findElements = 0 or more elements.
        // if list is empty, that means that element is not there
        // in this way, we can ensure that element doesn't present
        // //a[.='Home'] or //a[text()='Home'] - find link with text name Home
        System.out.println("Number of Links: " + links.size());
        // print the all liks
        //what if I want to print text of all links, one by one
        //loop through the collection of links
        for(WebElement webElement: links){
            // print text of every link
            if(!webElement.getText().isEmpty()){
            System.out.println(webElement.getText());
            }
        }
        driver.quit();

        WebDriver driver1 = BrowserFactory.getDriver("Chrome");
        driver1.get("http://practice.cybertekschool.com/");
        driver1.manage().window().fullscreen();
        BrowserUtils.wait(2);
        List<WebElement> links2 = driver1.findElements(By.xpath("//a"));
        System.out.println("number of links: " + links2.size());
           driver1.quit();
        }

    }





