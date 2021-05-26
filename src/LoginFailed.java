import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginFailed {
    public static void main(String[] args) throws InterruptedException {
        Base base = new Base();
        WebDriver driver =
                base.prepare("https://giris.hepsiburada.com/");


        WebElement userName = driver.findElement(By.xpath("//input[@type='email']"));
        userName.click();
        userName.sendKeys("egementokgoz35@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("123456789");

        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();

        Thread.sleep(3000);
        String failText = driver.findElement(By.xpath("//div[text()='Bilgileriniz eksik veya hatalı.']")).getText();

        if(failText.equals("Bilgileriniz eksik veya hatalı.")){
            System.out.println("Login test failed. \nIncorrect error or password. ");
            Thread.sleep(2000);
            driver.quit();
        }

    }


}
