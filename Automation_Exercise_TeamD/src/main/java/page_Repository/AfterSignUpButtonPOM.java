package page_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AfterSignUpButtonPOM {

    // Title radio buttons
	@FindBy(xpath = "//b[text()='Enter Account Information']")
    private WebElement accInfo;
	
	
    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement titleMr;
    
    @FindBy(xpath = "//input[@id='id_gender2']")
    private WebElement titleMrs;
    
    // Password field
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    
    // Date of birth dropdowns
    @FindBy(xpath = "//select[@id='days']")
    private WebElement dayDropdown;
    
    @FindBy(xpath = "//select[@id='months']")
    private WebElement monthDropdown;
    
    @FindBy(xpath = "//select[@id='years']")
    private WebElement yearDropdown;
    
    // Newsletter checkbox
    @FindBy(xpath = "//input[@id='newsletter']")
    private WebElement newsletterCheckbox;
    
    // Special offers checkbox
    @FindBy(xpath = "//input[@id='optin']")
    private WebElement specialOffersCheckbox;
    
    // Address information fields
    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstNameField;
    
    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastNameField;
    
    @FindBy(xpath = "//input[@id='company']")
    private WebElement companyField;
    
    @FindBy(xpath = "//input[@id='address1']")
    private WebElement address1Field;
    
    @FindBy(xpath = "//input[@id='address2']")
    private WebElement address2Field;
    
    @FindBy(xpath = "//select[@id='country']")
    private WebElement countryDropdown;
    
    @FindBy(xpath = "//input[@id='state']")
    private WebElement stateField;
    
    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityField;
    
    @FindBy(xpath = "//input[@id='zipcode']")
    private WebElement zipcodeField;
    
    @FindBy(xpath = "//input[@id='mobile_number']")
    private WebElement mobileNumberField;
    
    // Create account button
    @FindBy(xpath = "//button[contains(text(),'Create Account')]")
    private WebElement createAccountButton;
    
    // Account created verification
    @FindBy(xpath = "//b[text()='Account Created!']")
    private WebElement accountCreated;
    
    @FindBy(xpath = "//a[text()='Continue']")
    private WebElement accountCreatedButton;
    
    public AfterSignUpButtonPOM(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    // Methods for interacting with elements
    
    public boolean accountInfoDisplay() {
    	return accInfo.isDisplayed();
    }
    
    public void selectTitleMr() {
        titleMr.click();
    }
    
    public void selectTitleMrs() {
        titleMrs.click();
    }
    
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    
    public void selectDay(String day) {
    	Select daysSelect = new Select(dayDropdown);
        daysSelect.selectByVisibleText(day);
    }
    
    public void selectMonth(String month) {
    	Select monthsSelect = new Select(monthDropdown);
        monthsSelect.selectByVisibleText(month);
    }
    
    public void selectYear(String year) {
    	Select yearsSelect = new Select(yearDropdown);
        yearsSelect.selectByVisibleText(year);
    }
    
    public void checkNewsletter() {
        if(!newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }
    }
    
    public void uncheckNewsletter() {
        if(newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }
    }
    
    public void checkSpecialOffers() {
        if(!specialOffersCheckbox.isSelected()) {
            specialOffersCheckbox.click();
        }
    }
    
    public void uncheckSpecialOffers() {
        if(specialOffersCheckbox.isSelected()) {
            specialOffersCheckbox.click();
        }
    }
    
    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }
    
    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }
    
    public void enterCompany(String company) {
        companyField.sendKeys(company);
    }
    
    public void enterAddress1(String address1) {
        address1Field.sendKeys(address1);
    }
    
    public void enterAddress2(String address2) {
        address2Field.sendKeys(address2);
    }
    
    public void selectCountry(String country) {
    	Select yearsSelect = new Select(countryDropdown);
        yearsSelect.selectByVisibleText(country);
    }
    
    public void enterState(String state) {
        stateField.sendKeys(state);
    }
    
    public void enterCity(String city) {
        cityField.sendKeys(city);
    }
    
    public void enterZipcode(String zipcode) {
        zipcodeField.sendKeys(zipcode);
    }
    
    public void enterMobileNumber(String mobileNumber) {
        mobileNumberField.sendKeys(mobileNumber);
    }
    
    public void clickCreateAccount() {
        createAccountButton.click();
    }
    
    public boolean verifyAccountCreation() {
        return accountCreated.isDisplayed();
    }
    
    public void clickContinueButton() {
        accountCreatedButton.click();
    }
}
