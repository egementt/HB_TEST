import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SearchTest {

    final Base base = new Base();
    final WebDriver driver = base.prepare("https://www.hepsiburada.com/");
    final WebElement searchBar = driver.findElement(By.xpath("//input[@type='text']"));
    final WebElement searchButton= driver.findElement(By.className("SearchBoxOld-buttonContainer"));
    List<WebElement> products;

        @Test
        public void validSearch() throws InterruptedException {
            searchBar.click();
            searchBar.sendKeys("Klavye");
            searchButton.click();
            Thread.sleep(2000);
            products =  driver.findElements(By.cssSelector("li"));
            System.out.println(products.size() + " items listed.");
            Assert.assertFalse(products.isEmpty());
        }

        @Test
        public void topSellersSearch() throws InterruptedException {


            searchBar.click();
            searchBar.sendKeys("Iphone 12");
            searchButton.click();
            Thread.sleep(2000);
            WebElement topSellers= driver.findElement(By.xpath("//a[contains(@class,'button sorting-label')]"));
            topSellers.click();
            final WebElement productListLayout = driver.findElement(By.xpath("//ul[contains(@class,'product-list results-container')]"));
            products =  productListLayout.findElements(By.xpath("(//div[contains(@class,'box product')])"));
            System.out.println(products.size()+1 + " items listed.");
            Assert.assertFalse(products.isEmpty());
        }

    @Test
    public void invalidSearch() throws InterruptedException {
            searchBar.click();
        searchBar.sendKeys("asddsadasdasdas");
        searchButton.click();
        Thread.sleep(3000);
        final WebElement productListLayout = driver.findElement(By.xpath("//ul[contains(@class,'product-list results-container')]"));
        products =  productListLayout.findElements(By.xpath("(//div[contains(@class,'box product')])"));
        Assert.assertTrue(products.isEmpty());


    }




}
