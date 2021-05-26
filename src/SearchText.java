import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchText {

    public static void main(String[] args) throws InterruptedException {

        Base base = new Base();
        WebDriver driver = base.prepare("http://hepsiburada.com"); // web sayfası açmak için v1
        WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
        search.click();
        search.sendKeys("Klavye");
        WebElement searchButton= driver.findElement(By.className("SearchBoxOld-buttonContainer"));
        searchButton.click();
        Thread.sleep(2000);
        WebElement topSellers= driver.findElement(By.xpath("//a[contains(@class,'button sorting-label')]"));
        topSellers.click();

    }
}
