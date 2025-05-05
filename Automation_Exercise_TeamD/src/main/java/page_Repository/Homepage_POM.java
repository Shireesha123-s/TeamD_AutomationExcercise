package page_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage_POM {
    WebDriver driver;

// 1. Navigation Menu Elements
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homeMenu;

    @FindBy(xpath = "//a[contains(text(),'Products')]")
    private WebElement productsMenu;

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    private WebElement cartMenu;

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    private WebElement loginSignupMenu;
    
//	    @FindBy(xpath = "//a[text()=' Test Cases']")
//	    private WebElement testCase;

    @FindBy(xpath = "//a[contains(text(),'Contact us')]")
    private WebElement contactUsMenu;

// 2. Featured Section Elements
    @FindBy(css = "div.features_items h2.title")
    private WebElement featuredItemsTitle;

    @FindBy(xpath = "(//div[@class='productinfo text-center'])[1]")
    private WebElement firstFeaturedItem;

// 3. Subscription (Footer)
    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmailInput;

    @FindBy(id = "subscribe")
    private WebElement subscribeButton;

    @FindBy(css = "div.alert-success")
    private WebElement subscriptionSuccessAlert;
    
    @FindBy(xpath =  "//i[contains(@class,'fa fa-angle-up')]")
    private WebElement scrollToTop;

// 4. Category Section
    @FindBy(xpath =  "//h2[text()='Category']")
    private WebElement categoryTitle;

    @FindBy(xpath = "(//span[@class='badge pull-right'])[1]")
    private WebElement womenCategory;

    @FindBy(xpath = "//a[@href='#Men']")
    private WebElement menCategory;

// 5. Recommended Items
    @FindBy(css = "div.recommended_items h2.title")
    WebElement recommendedItemsTitle;

// Constructor
    public Homepage_POM(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

// ===== ACTION METHODS =====

// Navigation Methods
    public void clickProductsMenu() {
        productsMenu.click();
    }

    public void clickCartMenu() {
        cartMenu.click();
    }

    public void clickLoginSignupMenu() {
        loginSignupMenu.click();
    }

// Subscription Method
    public void subscribeWithEmail(String email) {
        subscribeEmailInput.sendKeys(email);
        subscribeButton.click();
    }

// Validation Methods
    public boolean isFeaturedItemsVisible() {
        return featuredItemsTitle.isDisplayed();
    }

    public boolean isSubscriptionSuccessVisible() {
        return subscriptionSuccessAlert.isDisplayed();
    }
}
