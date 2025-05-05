package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Testcase_05 {
    public static void main(String[] args) {
// Test data
        String name = "Ronoroa";
        String existingEmail = "sfspalalala@gmail.com";
        
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
            System.out.println("Step 3: Home page verification failed");
        }
        
// 4. Click on Signup/Login button
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        System.out.println("Clicked on Signup/Login button");
        
// 5. Verify 'New User Signup!' is visible
        if (driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]")).isDisplayed()) {
            System.out.println("'New User Signup!' section is visible");
        } else {
            System.out.println("New User Signup section not found");
        }
        
// 6. Enter name and existing email
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(existingEmail);
        System.out.println("Entered name and existing email address");
        
// 7. Click signup button
        driver.findElement(By.xpath("//button[contains(text(),'Signup')]")).click();
        System.out.println("Clicked signup button");
        
// 8. Verify error message
        String errorMessage = driver.findElement(By.xpath("//p[contains(text(),'Email Address already exist!')]")).getText();
        if (errorMessage.equals("Email Address already exist!")) {
            System.out.println("Error message verified: '" + errorMessage + "'");
        } else {
            System.out.println("Error message verification failed");
        }
        
// Close browser
        driver.quit();
        System.out.println("Browser closed - Test completed");
    }
}