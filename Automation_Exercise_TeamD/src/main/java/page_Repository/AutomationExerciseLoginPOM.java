package page_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationExerciseLoginPOM {

    // ========== Login Section Elements ========== //
    @FindBy(xpath = "//h2[text()='Login to your account']")
    private WebElement loginSectionTitle;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmailField;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPasswordField;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    private WebElement loginErrorMessage;

    // ========== New User Signup Section Elements ========== //
    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement signupSectionTitle;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement signupNameField;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement signupEmailField;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupButton;
    
    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    private WebElement emailAlreadyExist;

    public AutomationExerciseLoginPOM(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // ========== Login Section Methods ========== //

    public boolean isLoginSectionDisplayed() {
        return loginSectionTitle.isDisplayed();
    }

    public void enterLoginEmail(String email) {
        loginEmailField.clear();
        loginEmailField.sendKeys(email);
    }

    public void enterLoginPassword(String password) {
        loginPasswordField.clear();
        loginPasswordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isInvalidLoginErrorDisplayed() {
        return loginErrorMessage.isDisplayed();
    }

    // ========== New User Signup Section Methods ========== //

    public boolean isSignupSectionDisplayed() {
        return signupSectionTitle.isDisplayed();
    }

    public void enterSignupName(String name) {
        signupNameField.clear();
        signupNameField.sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        signupEmailField.clear();
        signupEmailField.sendKeys(email);
    }
    
    public boolean emailAlreadyExist() {
    	return emailAlreadyExist.isDisplayed();
       
    }

    public void clickSignupButton() {
        signupButton.click();
    }

    // ========== Combined Methods ========== //

    public void login(String email, String password) {
        enterLoginEmail(email);
        enterLoginPassword(password);
        clickLoginButton();
    }

    public void signup(String name, String email) {
        enterSignupName(name);
        enterSignupEmail(email);
        clickSignupButton();
    }
}
