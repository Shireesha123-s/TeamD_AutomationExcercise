package page_Repository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    // Header Navigation Elements
    @FindBy(xpath = "//a[text()=' Home']")
    private WebElement homeLink;
    
    @FindBy(xpath = "//a[text()=' Products']")
    private WebElement productsLink;
    
    @FindBy(xpath = "//a[text()=' Cart']")
    private WebElement cartLink;
    
    @FindBy(xpath = "//a[text()=' Delete Account']")
    private WebElement deleteAccount;
    
    @FindBy(xpath = "//a[text()=' Signup / Login']")
    private WebElement signupLoginLink;
    
    @FindBy(xpath = "//a[text()=' Video Tutorials']")
    private WebElement videoTutorialsLink;
    
    @FindBy(xpath = "//a[text()=' Contact us']")
    private WebElement contactUsLink;

    // Category Section
    @FindBy(xpath = "//h2[text()='Category']")
    private WebElement categoryHeader;
    
    // Brands Section
    @FindBy(xpath = "//h2[text()='Brands']")
    private WebElement brandsHeader;

    // Featured Items Section (contains the text we need to verify)
    @FindBy(xpath = "//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]")
    private WebElement featuredItemsHeader;
    
    @FindBy(xpath = "(//a[text()='Add to cart'])[1]")
    private WebElement firstProductAddToCartButton;
    
    @FindBy(xpath = "(//a[text()='View Product'])[1]")
    private WebElement firstProductViewButton;

    // Subscription Section
    @FindBy(xpath = "//h2[text()='Subscription']")
    private WebElement subscriptionHeader;
    
    @FindBy(id = "susbscribe_email")
    private WebElement subscriptionEmailField;
    
    @FindBy(id = "subscribe")
    private WebElement subscribeButton;

    // Scroll Up
    @FindBy(id = "scrollUp")
    private WebElement scrollUpButton;
    
    // Recommended item
    @FindBy(xpath = "//h2[text()='recommended items']")
    private WebElement recommendedItem;
    
    // Click on add to cart on recommended item
    @FindBy(xpath = "(//a[contains(@data-product-id,'4')]) [15]")
    private WebElement addTocartOnRecommend;
    
    // Click on view cart
    @FindBy(xpath = "//u[text()=\"View Cart\"]")
    private WebElement clickOnViewCart;
    
    // Product is there in view cart
    @FindBy(xpath = "//a[text()=\"Stylish Dress\"]")
    private WebElement productIsThere;
    
    // Logged in as a user verify
    @FindBy(xpath = "//a[text()=' Logged in as ']")
    private WebElement verifyLoggedIn;
    
    // Add product to cart
    @FindBy(xpath = "(//a[text()='Add to cart']) [1]")
    private WebElement addToCart;
    
    // Clicking on continue in add to cart section
    @FindBy(xpath = "//button[text()='Continue Shopping']")
    private WebElement continuteButton;
    
    // Deleting account
    @FindBy(xpath = "//b[text()='Account Deleted!']")
    private WebElement deletedAccount;
    
    @FindBy(xpath = "//a[text()='Continue']")
    private WebElement clickContinue;
    
    //Test case
    @FindBy(xpath = "//a[text()=' Test Cases']")
    private WebElement testcaseLink;
    
    //Log out
    @FindBy(xpath = "//a[text()=' Logout']")
    private WebElement clickLogout;
    
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    // Navigation Methods
    public void clickHomeLink() {
        homeLink.click();
    }
    
    public boolean isHomeLinkDisplayed() {
        return homeLink.isDisplayed();
    }
    
    public void clickProductsLink() {
        productsLink.click();
    }
    
    public void clickCartLink() {
        cartLink.click();
    }
    
    public void clickSignupLoginLink() {
        signupLoginLink.click();
    }
    
    public void clickVideoTutorialsLink() {
        videoTutorialsLink.click();
    }
    
    public void clickContactUsLink() {
        contactUsLink.click();
    }

    // Verification Methods
    public boolean isCategorySectionDisplayed() {
        return categoryHeader.isDisplayed();
    }
    
    public boolean isBrandsSectionDisplayed() {
        return brandsHeader.isDisplayed();
    }
    
    public boolean isFeaturedItemsSectionDisplayed() {
        return featuredItemsHeader.isDisplayed();
    }
    
    public boolean isSubscriptionSectionDisplayed() {
        return subscriptionHeader.isDisplayed();
    }

    // Product Interaction Methods
    public void addFirstProductToCart() {
        firstProductAddToCartButton.click();
    }
    
    public void viewFirstProduct() {
        firstProductViewButton.click();
    }

    // Subscription Methods
    public void enterSubscriptionEmail(String email) {
        subscriptionEmailField.clear();
        subscriptionEmailField.sendKeys(email);
    }
    
    public void clickSubscribeButton() {
        subscribeButton.click();
    }

    // Page Interaction Methods
    public void clickScrollUpButton() {
        scrollUpButton.click();
    }
    
    // Recommended item verification
    public boolean isRecommendedItemDisplayed() {
        return recommendedItem.isDisplayed();
    }
    
    // Add to cart on recommended item
    public void addToCartRecommendedItem() {
        addTocartOnRecommend.click();
    }
    
    // Going to cart
    public void goToCart() {
        clickOnViewCart.click();
    }
    
    // Product is present in cart
    public boolean isProductInCart() {
        return productIsThere.isDisplayed();
    }
    
    public boolean isLoggedInAsUser() {
        return verifyLoggedIn.isDisplayed();
    }
    
    public void addProductToCart() {
        addToCart.click();
    }
    
    public void clickOnContinue() {
        continuteButton.click();
    }
    
    public void clickOnDeleteAccount() {
        deleteAccount.click();
    }
    
    public boolean isAccountDeleted() {
        return deletedAccount.isDisplayed();
    }
    
    public void clickContinueAfterDeletion() {
        clickContinue.click();
    }
    
    public void clickLogoutOption() {
        clickLogout.click();
    }
    
    public void clickTestcase() {
        testcaseLink.click();
    }
}