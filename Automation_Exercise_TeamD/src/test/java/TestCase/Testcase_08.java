package TestCase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase_08 {

	public static void main(String[] args) {
// 1. Launch browser
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2. Navigate to url
        driver.get("http://automationexercise.com");
        System.out.println("Navigated to Automation Exercise website");

// 3. Verify home page is visible
        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Home page is visible successfully");
        }

// 4. Click on 'Products' button
        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
        System.out.println("Clicked on Products button");

// 5. Verify navigation to ALL PRODUCTS page
        if (driver.findElement(By.xpath("//h2[contains(text(),'All Products')]")).isDisplayed()) {
            System.out.println("Successfully navigated to ALL PRODUCTS page");
        }
// 6. The products list is visible
        List<WebElement> products = driver.findElements(By.className("product-image-wrapper"));
        if (!products.isEmpty()) {
            System.out.println("Products list is visible with " + products.size() + " products");
        }
        
// 7. Click on 'View Product' of first product
        driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]")).click();
        System.out.println("Clicked on first product's View Product button");

// 8. Verify landed on product detail page
        if (driver.getCurrentUrl().contains("product_details")) {
            System.out.println("Successfully landed on product detail page");
        }

// 9. Verify product details
        System.out.println("Verifying product details...");
        
        WebElement productName = driver.findElement(By.xpath("//h2[text()='Blue Top']"));
        System.out.println("Product Name: " + productName.getText());
        
        WebElement category = driver.findElement(By.xpath("//p[contains(text(),'Category')]"));
        System.out.println(category.getText());
        
        WebElement price = driver.findElement(By.xpath("//span[text()='Rs. 500']"));
        System.out.println("Price: " + price.getText());
        
        WebElement availability = driver.findElement(By.xpath("//p[text()=' In Stock']"));
        System.out.println(availability.getText());
        
        WebElement condition = driver.findElement(By.xpath("//p[text()=' New']"));
        System.out.println(condition.getText());
        
        WebElement brand = driver.findElement(By.xpath("//p[text()=' Polo']"));
        System.out.println(brand.getText());

// Close browser
        driver.close();
        System.out.println("Test completed successfully");
    }     

}
