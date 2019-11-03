package test.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class StudyMySelf {

    public static void main(String[] args) {
        /*
        we need to create main methiod because that
        it is a dreger for running the program
         */
        WebDriverManager.chromedriver().setup(); // we need to set up webdriver manager
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://amazon.com");
        //Thread.sleep(3000);
        driver.navigate().to("http://youtube.com");
        driver.manage().window().fullscreen();
        driver.get("http://google.com");

        driver.quit();

    }
}
