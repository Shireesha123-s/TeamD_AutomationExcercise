package TestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase_26 {

    public static void main(String[] args) {
// 1. Launch browser
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
// 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        
// 3. Verify that home page is visible successfully
        WebElement homePageElement = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
        if(homePageElement.isDisplayed()) {
            System.out.println("Home page is visible successfully");
        }
        
// Create Actions class instance
        Actions actions = new Actions(driver);
        
// 4. Scroll down page to bottom using Actions
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).perform();
        
// 5. Verify 'SUBSCRIPTION' is visible
        WebElement subscriptionElement = driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]"));
        if(subscriptionElement.isDisplayed()) {
            System.out.println("SUBSCRIPTION is visible");
        }
        
// 6. Scroll up page to top using Actions
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).keyUp(Keys.CONTROL).perform();
        
// 7. Verify that page is scrolled up and text is visible
        WebElement textElement = driver.findElement(By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]"));
        if(textElement.isDisplayed()) {
            System.out.println("Page is scrolled up and text is visible");
        }
        
        driver.close();
    }
}
