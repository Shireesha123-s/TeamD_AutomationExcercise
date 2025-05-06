package TestCase;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Testcase_06 {
    public static void main(String[] args) throws InterruptedException, AWTException {
// Test Data
        String name = "Devil may cry";
        String email = "devilmaycry@gmail.com";
        String subject = "Test Inquiry";
        String message = "This is a test message for contact form verification.";
//        String filePath = "‪https://images.pexels.com/photos/276267/pexels-photo-276267.jpeg?auto=compress&cs=tinysrgb&w=600";

// 1. Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Navigated to website");

// 3. Verify that home page is visible successfully
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Home page visible");
        }

// 4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[text()=' Contact us']")).click();
        System.out.println("Clicked Contact Us");

// 5. Verify 'GET IN TOUCH' is visible
        if (driver.findElement(By.xpath("//h2[text()='Get In Touch']")).isDisplayed()) {
            System.out.println("Get In Touch visible");
        }

// 6. Enter name, email, subject and message
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("subject")).sendKeys(subject);
        driver.findElement(By.id("message")).sendKeys(message);
        System.out.println("Entered contact details");

// 7. Upload file
        
        StringSelection filePathSelection = new StringSelection("D:\\Uttam's\\Documents\\Steps to download Apache POI.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);  //Copy the path into clipboard then we can use robot class to paste
        
        WebElement fileUp= driver.findElement(By.xpath("//input[@name='upload_file']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", fileUp);
        
        Thread.sleep(3000);
        
        Robot rb= new Robot();
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        
        Thread.sleep(3000);
        
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        
        
        System.out.println("File uploaded");

// 8. Click Submit button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println("Submitted form");

//// 9. Handle alert
        driver.switchTo().alert().accept();
        System.out.println("Accepted alert");

// 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        String successText = driver.findElement(By.cssSelector(".status.alert-success")).getText();
        if (successText.contains("Success! Your details have been submitted successfully.")) {
            System.out.println("Success message verified");
        }

// 11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.cssSelector(".btn-success")).click();
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Returned to home page");
        }

// Close browser
        driver.close();
        System.out.println("Test completed");
    }
}
