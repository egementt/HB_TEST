import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartTest {

    public static void main(String[] args) {
        Base base = new Base();
        WebDriver driver =
        base.prepare("https://www.hepsiburada.com/apple-macbook-air-m1-cip-8gb-256gb-ssd-macos-13-qhd-tasinabilir-bilgisayar-uzay-grisi-mgn63tu-a-p-HBV0000130VND");
        WebElement addToCartButton = driver.findElement(By.id("addToCart"));
        addToCartButton.click();

        try {
            Thread.sleep(6000);
            WebElement seeCart = driver.findElement(By.xpath("//button[text()='Sepete git']"));
            if (seeCart.isDisplayed()){
                System.out.println("The item added to cart successfully.");
                driver.quit();
            }else {
                System.out.println("An error occurred");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
