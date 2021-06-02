import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest {

    final String USERNAME = "Egemen Tokgöz";
    final String userMail = "egementokgoz35@gmail.com";
    final String userPassword = "egomen12";
    final Base base = new Base();
    final WebDriver driver = base.prepare("https://giris.hepsiburada.com/");
    final WebElement userNameTextField = driver.findElement(By.name("username"));
    final WebElement passwordTextField = driver.findElement(By.xpath("//input[@id='txtPassword']"));
    final WebElement loginButton = driver.findElement(By.id("btnLogin"));

    @Test
    public void successfullLogin() throws InterruptedException {
        Thread.sleep(2600);
        userNameTextField.click();
        userNameTextField.sendKeys(userMail);
        passwordTextField.sendKeys(userPassword);
        loginButton.click();

        try {
            Thread.sleep(3000);
            String userText = driver.findElement(By.xpath("//span[text()='Egemen Tokgöz']")).getText();
            if (userText != null) {
                Assert.assertEquals(userText, USERNAME);
                Thread.sleep(3000);
                driver.quit();
            } else {
                System.out.println("Login test failed.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred. Login test failed");
        }
    }

    @Test
    public  void  wrongEmail() throws InterruptedException {
        Thread.sleep(2600);
        userNameTextField.click();
        userNameTextField.sendKeys("usermania12@admin.dev");
        passwordTextField.sendKeys("egomen12");
        loginButton.click();
        Thread.sleep(3000);

        String failText = driver.findElement(By.xpath("//div[text()='Bilgileriniz eksik veya hatalı.']")).getText();
        String expectedOutput = "Bilgileriniz eksik veya hatalı.";
        Assert.assertEquals(failText, expectedOutput);
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public  void  wrongPassword() throws InterruptedException {
        Thread.sleep(2600);
        userNameTextField.click();
        userNameTextField.sendKeys(userMail);
        passwordTextField.sendKeys("123456");
        loginButton.click();
        Thread.sleep(3000);

        String failText = driver.findElement(By.xpath("//div[text()='Bilgileriniz eksik veya hatalı.']")).getText();
        String expectedOutput = "Bilgileriniz eksik veya hatalı.";
        Assert.assertEquals(failText, expectedOutput);
        Thread.sleep(2000);
        driver.quit();
    }










}