package page_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPOM {
	 @FindBy(xpath = "//b[text()='Account Deleted!']")
	 private WebElement accountDeleteText;
	 
	 @FindBy(xpath = "//a[text()='Continue']")
	 private WebElement clickContinue;
	    
	 public DeleteAccountPOM(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	    
// Verify text
	 public boolean verifyAccountDeletion() {
		 return accountDeleteText.isDisplayed();
	 }
//	 Click on continue button
	 public void clickDeleteButton() {
		 clickContinue.click();
	 }

}
