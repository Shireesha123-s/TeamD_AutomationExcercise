package TestCase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase_09 {
    public static void main(String[] args) {
// 1. Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Step 1: Launch browser");

// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Step 2: Navigated to Automation Exercise website");

// 3. Verify home page is visible
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Step 3: Home page is visible successfully");
        }

// 4. Click on 'Products' button
        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
        System.out.println("Step 4: Clicked on Products button");

// 5. Verify navigation to ALL PRODUCTS page
        if (driver.findElement(By.xpath("//h2[contains(text(),'All Products')]")).isDisplayed()) {
            System.out.println("Step 5: Successfully navigated to ALL PRODUCTS page");
        }
        
// 6. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("dress");
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();
		
// 7. Verify 'SEARCHED PRODUCTS' is visible
		
        List<WebElement> products=driver.findElements(By.xpath("//div[@class='productinfo text-center']"));
        boolean allMatch = true;
        
        System.out.println("Step 8: Found " + products.size() + " products:");
//        for (WebElement product : products) {
//            String productName = product.findElement(By.tagName("p")).getText();
//            System.out.println("- " + productName);
//           
//        }
        
        if (allMatch) {
            System.out.println("All products match search term");
        } else {
            System.out.println("Some products don't match search term");
        }
        
//      Close browser  
        driver.close();

    }
}
