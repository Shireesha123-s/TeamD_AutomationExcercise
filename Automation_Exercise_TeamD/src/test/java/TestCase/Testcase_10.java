package TestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase_10 {
    public static void main(String[] args) {
// Test Data
        String email = "testuser" + System.currentTimeMillis() + "@example.com";
        
// 1. Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Step 2: Navigated to website");

// 3. Verify home page is visible
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Step 3: Home page is visible");
        }

// 4. Scroll down to footer
        WebElement footer = driver.findElement(By.tagName("footer"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", footer);
        System.out.println("Step 4: Scrolled to footer");

// 5. Verify text 'SUBSCRIPTION'
        WebElement subscriptionText = driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]"));
        if (subscriptionText.isDisplayed()) {
            System.out.println("Step 5: 'SUBSCRIPTION' text is visible");
        }

// 6. Enter email and subscribe
        WebElement emailInput = driver.findElement(By.id("susbscribe_email"));
        emailInput.sendKeys(email);
        driver.findElement(By.id("subscribe")).click();
        System.out.println("Step 6: Entered email and clicked subscribe");

// 7. Verify success message
        WebElement successMessage = driver.findElement(By.id("success-subscribe"));
        if (successMessage.getText().equals("You have been successfully subscribed!")) {
            System.out.println("Step 7: Success message is visible");
        }

// Close browser
        driver.quit();
        System.out.println("Test completed");
    }
}

