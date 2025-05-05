package TestCase;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Testcase_11 {
    public static void main(String[] args) {
// 1. Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Navigated to website");

// 3. Verify home page is visible
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Home page is visible");
        }

// 4. Click 'Cart' button
        driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
        System.out.println("Clicked Cart button");

// 5. Scroll down to footer
        WebElement footer = driver.findElement(By.tagName("footer"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", footer);
        System.out.println("Scrolled to footer");

// 6. Verify text 'SUBSCRIPTION'
        WebElement subscription = driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]"));
        if (subscription.isDisplayed()) {
            System.out.println("'SUBSCRIPTION' text is visible");
        }

// 7. Enter email and subscribe
        driver.findElement(By.id("susbscribe_email")).sendKeys("demoemail@gmail.com");
        driver.findElement(By.id("subscribe")).click();
        System.out.println("Entered email and subscribed");

// 8. Verify success message
        WebElement successMsg = driver.findElement(By.id("success-subscribe"));
        if (successMsg.getText().contains("You have been successfully subscribed!")) {
            System.out.println("Success message is visible");
        }

// Close browser
        driver.quit();
        System.out.println("Test completed");
    }
}