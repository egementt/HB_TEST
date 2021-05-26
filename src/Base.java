import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class Base {

    // The main goal of Base.java class is, preparing webdriver and selenium to test given url from user.
    public WebDriver prepare(String url){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\egeme\\Desktop\\selenium& driver\\chromedriver.exe"); //Open package from given path
        WebDriver driver = new ChromeDriver(); //Creating new webdriver object from ChromeDriver Class.
        driver.manage().window().maximize(); //It makes chrome browser that covers the whole screen.
        driver.get(url); // Open the given url
        return driver; // Returns driver
    }
}
