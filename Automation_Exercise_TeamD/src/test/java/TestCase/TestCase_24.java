package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


public class TestCase_24 {

    public static void main(String[] args) {
// 1. Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
// 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        
// 3. Verify that home page is visible successfully
        WebElement homePageElement = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
        if(homePageElement.isDisplayed()) {
            System.out.println("Home page is visible successfully");
        }
        
// 4. Add products to cart
        // Hover over first product and click "Add to cart"
        WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[1]"));
        WebElement addToCartBtn1 = firstProduct.findElement(By.xpath(".//a[contains(text(),'Add to cart')]"));
        addToCartBtn1.click();
        
        // Click "Continue Shopping" on the modal
        WebElement continueShoppingBtn = driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]"));
        continueShoppingBtn.click();
        
        
// 5. Click 'Cart' button
        WebElement cartButton = driver.findElement(By.xpath("//a[contains(text(),'Cart')]"));
        cartButton.click();
        
// 6. Verify that cart page is displayed
        WebElement cartPageHeader = driver.findElement(By.xpath("//li[contains(text(),'Shopping Cart')]"));
        if(cartPageHeader.isDisplayed()) {
            System.out.println("Cart page is displayed successfully");
        }
        
// 7. Click Proceed To Checkout
        WebElement proceedToCheckoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]"));
        proceedToCheckoutBtn.click();
        
// 8. Click 'Register / Login' button
        driver.findElement(By.xpath("//u[text()='Register / Login']")).click();
// 9. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("yoyoHoneySingh");
        driver.findElement(By.xpath("(//input[@name='email']) [2]")).sendKeys("abc_monkey235@gmail.com");
        driver.findElement(By.xpath("//button[text()='Signup']")).click();
//        
//		enter signup details
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.id("password")).sendKeys("Hello123");
		
		WebElement days=driver.findElement(By.id("days"));
		Select s1= new Select(days);
		s1.selectByVisibleText("3");
		WebElement months= driver.findElement(By.id("months"));
		s1 = new Select(months);
		s1.selectByVisibleText("February");
		WebElement year=driver.findElement(By.id("years"));
		s1=new Select(year);
		s1.selectByVisibleText("2001");
		
		driver.findElement(By.id("first_name")).sendKeys("Uttam");
		driver.findElement(By.id("last_name")).sendKeys("Kumar");
		driver.findElement(By.id("address1")).sendKeys("this is demo address");
		
		WebElement countries=driver.findElement(By.id("country"));
		s1=new Select(countries);
		s1.selectByVisibleText("India");
		
		driver.findElement(By.id("state")).sendKeys("West bangal");
		driver.findElement(By.id("city")).sendKeys("kolkata");
		driver.findElement(By.id("zipcode")).sendKeys("123456");
		driver.findElement(By.id("mobile_number")).sendKeys("6003892833");
		driver.findElement(By.xpath("//button[text()='Create Account']")).click();
		
//	10	Verify 'ACCOUNT CREATED!' and click 'Continue' button
		WebElement accCreated=driver.findElement(By.xpath("//b[text()='Account Created!']"));
		if(accCreated.isDisplayed()) {
			System.out.println("Account created has been displayed");
		}
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
//	11	Verify ' Logged in as username' at top
		WebElement logV=driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
		if(logV.isDisplayed()) {
			System.out.println("Logged in as username");
		}
		
//	12	Click 'Cart' button
		driver.findElement(By.xpath("//a[text()=' Cart']")).click();
//	13	Click 'Proceed To Checkout' button
		driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
//	14	Verify Address Details and Review Your Order
		WebElement YDA= driver.findElement(By.xpath("//h2[text()='Address Details']"));
		if(YDA.isDisplayed()) {
			System.out.println("Address detail is displayed");
		}
		WebElement RYO= driver.findElement(By.xpath("//h2[text()='Review Your Order']"));
		if(RYO.isDisplayed()) {
			System.out.println("Review detail is displayed");
		}
//	15	Enter description in comment text area and click 'Place Order'
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("This is sample text which is used to check the text field");
		driver.findElement(By.xpath("//a[text()='Place Order']")).click();
//	16	Enter payment details: Name on Card, Card Number, CVC, Expiration date ..............(bug)
		driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("VISA");
		driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("434");
		driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys("02");
		driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("1999");
		
//	17	Click 'Pay and Confirm Order' button
		driver.findElement(By.id("submit")).click();
//	18. Verify success message 'Your order has been placed successfully!'
		WebElement VSM =driver.findElement(By.xpath("//b[text()='Order Placed!']"));
		if(VSM.isDisplayed()) {
			System.out.println("Your order has been placed successfully!");
		}
//	19.	Click 'Download Invoice' button and verify invoice is downloaded successfully.
		driver.findElement(By.xpath("//a[text()='Download Invoice']")).click();
		System.out.println("Invoice has been downloaded");
//	20	Click 'Continue' button
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
//	21	Click 'Delete Account' button
		driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();
//	22	Verify 'ACCOUNT DELETED!' and click 'Continue' button
		driver.findElement(By.xpath("//b[text()='Account Deleted!']")).click();
		
		driver.close();
        
    }
}