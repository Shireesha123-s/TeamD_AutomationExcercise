package TestCase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import page_Repository.AutomationExerciseLoginPOM;
import page_Repository.HomePage;

public class Testcase_05 {
	@Test
    public static void main() {
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
            System.out.println("Home page verification failed");
        }
        
// 4. Click on Signup/Login button
        HomePage hPage = new HomePage(driver);
        
        hPage.clickSignupLoginLink();
// 5. Verify 'New User Signup!' is visible
        AutomationExerciseLoginPOM automationLogin = new AutomationExerciseLoginPOM(driver);
        if(automationLogin.isSignupSectionDisplayed()) {
        	System.out.println("'New User Signup!' section is visible");
        }else {
        	System.out.println("New User Signup section not found");
        }
        
// 6. Enter name and already registered email address
        automationLogin.enterSignupName("Superman");
        automationLogin.enterSignupEmail("supermanofPune@gmail.com");
        
        System.out.println("Entered name and existing email address");
        
// 7. Click signup button
       automationLogin.clickSignupButton();
// 8. Verify error message
       if(automationLogin.emailAlreadyExist()) {
    	   System.out.println("Error message verified");
       }else {
    	   System.out.println("Error message is not verified");
       }
       
// Close browser
        driver.quit();
        System.out.println("Browser closed - Test completed");
    }
}