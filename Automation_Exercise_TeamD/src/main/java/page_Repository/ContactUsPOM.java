package page_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPOM {

    // Form Fields
    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "subject")
    private WebElement subjectInput;

    @FindBy(id = "message")
    private WebElement messageTextarea;
    
    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement upLoadElement;
    

    // Buttons
    @FindBy(name = "submit")
    private WebElement submitButton;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homeButton;

    // Verification Elements
    @FindBy(xpath = "//div[contains(@class,'status alert')]")
    private WebElement successAlert;

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    private WebElement getInTouchHeader;

    public ContactUsPOM(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Methods for form filling
    public void enterName(String name) {
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterSubject(String subject) {
        subjectInput.sendKeys(subject);
    }

    public void enterMessage(String message) {
        messageTextarea.sendKeys(message);
    }
    
    public boolean upLoadFile() {
        return upLoadElement.isDisplayed();
    }

    // Submit form
    public void clickSubmit() {
        submitButton.click();
    }

    // Return to Home
    public void clickHomeButton() {
        homeButton.click();
    }

    // Verification Methods
    public boolean isSuccessMessageDisplayed() {
        return successAlert.isDisplayed();
    }

    public boolean isGetInTouchHeaderVisible() {
        return getInTouchHeader.isDisplayed();
    }
}