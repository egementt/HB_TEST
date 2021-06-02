import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingTest {

    final Base base = new Base();
    final WebDriver driver = base.prepare("https://www.hepsiburada.com/apple-macbook-air-m1-cip-8gb-256gb-ssd-macos-13-qhd-tasinabilir-bilgisayar-uzay-grisi-mgn63tu-a-p-HBV0000130VND");
    final WebElement addToCartButton = driver.findElement(By.id("addToCart"));


    @Test
    public void CartTest(){
        addToCartButton.click();

        try {
            Thread.sleep(6000);
            WebElement successfulText = driver.findElement(By.className("checkoutui-SalesFrontCash-XeG2a"));
            if (successfulText.isDisplayed()){
                Assert.assertEquals(successfulText.getText(), "Ürün sepetinizde");
                driver.quit();
            }else {
                System.out.println("An error occurred");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }






    }

