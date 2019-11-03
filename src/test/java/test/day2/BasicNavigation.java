package test.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) {
        // IF YOU HAVE error cannot load the class that means pacckete name does not mach location with class
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        // to maximize or fullscreen   = .manage().window().maximize();
        driver.manage().window().maximize();  //fullscreen();
        driver.get("http://google.com");
        // we want to navigete to different page  = navigate().to(
        // we not gona open new browser or new tap
        driver.navigate().to("http://amazon.com");
       // driver.close();
        // if i want to comeback to the previus page = navigate().back();
        driver.navigate().back();
        //. if i want to know URL of current weppage
        String url = driver.getCurrentUrl();
        System.out.println(url);

        // selenium cannot close browser automaticly
        // for this we use close method
        driver.close();


    }
}
