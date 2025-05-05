package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Testcase_02 {

    public static void main(String[] args) {
        // Test data
        String email = "sfspalalala@gmail.com";
        String password = "";
        
// 1. Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
// 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        
// 3. Verify that home page is visible successfully
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Home page is visible");
        }
        
// 4. Click on 'Signup / Login' button
        driver.findElement(By.linkText("Signup / Login")).click();
        
// 5. Verify 'Login to your account' is visible
        if (driver.findElement(By.xpath("//h2[contains(.,'Login to your account')]")).isDisplayed()) {
            System.out.println("Login section is visible");
        }
        
// 6. Enter correct email address and password
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        
// 7. Click 'login' button
        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
        
// 8. Verify that 'Logged in as username' is visible
        if (driver.findElement(By.partialLinkText("Logged in as")).isDisplayed()) {
            System.out.println("Login successful");
        }
        
// 9. Click 'Delete Account' button
        driver.findElement(By.linkText("Delete Account")).click();
        
// 10. Verify that 'ACCOUNT DELETED!' is visible
        if (driver.findElement(By.xpath("//h2[contains(.,'Account Deleted!')]")).isDisplayed()) {
            System.out.println("Account deleted successfully");
        }
        
// Close browser
        driver.close();
    }
}
