package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Testcase_03 {
    public static void main(String[] args) {
// 1. Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");

// 3. Verify home page is visible
        String pageTitle = driver.getTitle();
        if (pageTitle.equals("Automation Exercise")) {
            System.out.println("Home page is visible successfully");
        }

// 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

// 5. Verify 'Login to your account' is visible
        if (driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]")).isDisplayed()) {
            System.out.println("Login section is visible");
        }

// 6. Enter incorrect email and password
        driver.findElement(By.name("email")).sendKeys("wrong@example.com");
        driver.findElement(By.name("password")).sendKeys("wrongpassword");

// 7. Click 'login' button
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

// 8. Verify error 'Your email or password is incorrect!' is visible
        String errorMessage = driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).getText();
        if (errorMessage.equals("Your email or password is incorrect!")) {
            System.out.println("Error message is visible: " + errorMessage);
        }

// Close browser
        driver.close();
    }
}
