import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessfulLogin {
    public static void main(String[] args) throws InterruptedException {
        Base base = new Base();
        WebDriver driver =
        base.prepare("https://giris.hepsiburada.com/");
        Thread.sleep(2600);
        WebElement userName = driver.findElement(By.name("username"));
        userName.click();
        userName.sendKeys("egementokgoz35@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("egomen12");

        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();

        try {
            Thread.sleep(3000);
            String userText = driver.findElement(By.xpath("//span[text()='Egemen Tokgöz']")).getText();
            if(userText.equals("Egemen Tokgöz")){
                System.out.println("Login test successful");
                Thread.sleep(1000);
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("An error occurred. Login test failed");
        }


    }
}
