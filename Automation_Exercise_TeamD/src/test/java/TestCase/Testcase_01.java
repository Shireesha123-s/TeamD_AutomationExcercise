package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_Repository.BaseConfig;
import page_Repository.AfterSignUpButtonPOM;
import page_Repository.AutomationExerciseLoginPOM;
import page_Repository.HomePage;

public class Testcase_01 extends BaseConfig {
@Test
	public void main() {
//// 1. Launch browser
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        
//// 2. Navigate to url
//        driver.get("http://automationexercise.com");
        
// 3. Verify that home page is visible successfully
	
        String pageTitle = driver.getTitle();
        if(pageTitle.equalsIgnoreCase("Automation Exercise")) {
            System.out.println("Home page is visible successfully");
        } else {
            System.out.println("Home page is not visible");
            driver.quit();
            return;
        }
        
// 4. Click on 'Signup / Login' button
        HomePage hPage = new HomePage(driver);
        
        hPage.clickSignupLoginLink();
        
// 5. Verify 'New User Signup!' is visible
        AutomationExerciseLoginPOM automationExercise= new AutomationExerciseLoginPOM(driver);
        
        if(automationExercise.isSignupSectionDisplayed()) {
        	 System.out.println("'New User Signup!' is visible");
        } else {
        	System.out.println("'New User Signup!' is not visible");
        	driver.quit();
		}
        
// 6. Enter name and email address
        automationExercise.enterSignupName("Saktiman");
        automationExercise.enterSignupEmail("saktiman@gmail.com");
// 7. Click 'Signup' button
        automationExercise.clickSignupButton();
// 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        AfterSignUpButtonPOM asuB = new AfterSignUpButtonPOM(driver);
        
        if(asuB.accountInfoDisplay()) {
        	System.out.println("'Enter Account Information' is visible");
        } else {
        	System.out.println("'Enter Account Information' is not visible");
        	driver.quit();
		}
// 9. Fill details: Title, Name, Email, Password, Date of birth
       // Select Title (Mr)
        asuB.selectTitleMr();
       // Password
        asuB.enterPassword("Test@123");
       // Date of birth
        asuB.selectDay("3");
        asuB.selectMonth("May");
        asuB.selectYear("1999");
      
// 10. Select checkbox 'Sign up for our newsletter!'
        asuB.checkNewsletter();
       
// 11. Select checkbox 'Receive special offers from our partners!'
        asuB.checkSpecialOffers();
       
// 12. Fill address information
        asuB.enterFirstName("Honey");
        asuB.enterLastName("Singh");
        asuB.enterCompany("Demo Company private limited");
        asuB.enterAddress1("123 test street");
        asuB.enterAddress2("Apt 4B Hyd");
       
       // Country
       Select country = new Select(driver.findElement(By.id("country")));
       country.selectByValue("India");
       
       driver.findElement(By.id("state")).sendKeys("California");
       driver.findElement(By.id("city")).sendKeys("Los Angeles");
       driver.findElement(By.id("zipcode")).sendKeys("12345");
       driver.findElement(By.id("mobile_number")).sendKeys("1234567890");
       
// 13. Click 'Create Account' button
       driver.findElement(By.xpath("//button[contains(text(),'Create Account')]")).click();
       
// 14. Verify that 'ACCOUNT CREATED!' is visible
       if(driver.findElement(By.xpath("//h2[@data-qa='account-created']")).isDisplayed()) {
           System.out.println("'ACCOUNT CREATED!' is visible");
       } else {
           System.out.println("'ACCOUNT CREATED!' is not visible");
           driver.quit();
           return;
       }
       
       // 15. Click 'Continue' button
       driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
       
       // 16. Verify that 'Logged in as username' is visible
       if(driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed()) {
           System.out.println("'Logged in as username' is visible");
       } else {
           System.out.println("'Logged in as username' is not visible");
           driver.quit();
           return;
       }
       
       // 17. Click 'Delete Account' button
       driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]")).click();
       
       // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
       if(driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).isDisplayed()) {
           System.out.println("'ACCOUNT DELETED!' is visible");
       } else {
           System.out.println("'ACCOUNT DELETED!' is not visible");
           driver.quit();
           return;
       }
       
       // Click Continue button after account deletion
       driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
       
       System.out.println("Complete signup and account deletion flow executed successfully");
       
       // Close the browser
       driver.close();

	}

}
