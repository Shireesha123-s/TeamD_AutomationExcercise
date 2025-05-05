package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Testcase_04 {
    public static void main(String[] args) {
        // Test data
        String email = "sfspalalala@gmail.com";
        String password = "123456789";
        
// 1. Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Navigated to Automation Exercise website");
        
// 3. Verify home page is visible
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Home page is visible successfully");
        } else {
            System.out.println("Home page verification failed");
        }
        
        // 4. Click on Signup/Login button
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        System.out.println("Clicked on Signup/Login button");
        
// 5. Verify login section is visible
        if (driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]")).isDisplayed()) {
            System.out.println("Login section is visible");
        } else {
            System.out.println("Login section not found");
        }
        
// 6. Enter credentials
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys(password);
        System.out.println("Entered email and password");
        
// 7. Click login button
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        System.out.println("Clicked login button");
        
// 8. Verify logged in status
        if (driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed()) {
            System.out.println("Successfully logged in as user");
        } else {
            System.out.println("Login verification failed");
        }
        
// 9. Click logout button
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
        System.out.println("Clicked logout button");
        
// 10. Verify navigation to login page
        if (driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]")).isDisplayed()) {
            System.out.println("Successfully navigated to login page after logout");
        } else {
            System.out.println("Logout verification failed");
        }
        
// Close browser
        driver.quit();
        System.out.println("Browser closed - Test completed");
    }
}
