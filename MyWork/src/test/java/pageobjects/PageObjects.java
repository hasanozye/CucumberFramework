package pageobjects;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {

    public PageObjects() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='top-links']//a[contains(.,'My Account')]")
    public WebElement menuMyAccountLink;

    @FindBy(xpath = "//div[@id='top-links']//a[contains(.,'Login')]")
    public WebElement menuLoginLink;

    @FindBy(id = "input-email")
    public WebElement loginFormUsername;

    @FindBy(id = "input-password")
    public WebElement loginFormPassword;

    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginFormSubmitButton;

    @FindBy(xpath = "//h2[text()='My Account']")
    public WebElement MyAccountSignedIn;

    @FindBy(xpath = "//div[contains(@class,'alert')]")
    public WebElement warningAlert;

    @FindBy(xpath = "//a[text()='Forgotten Password']")
    public WebElement forgottenPasswordLink;

    @FindBy(css = "#account-forgotten")
    public WebElement accountForgottenBody;

    @FindBy(css = "input[name='search']")
    public WebElement eSearchBoxTop;

    @FindBy(xpath = "//div[@id='search']//button[@type='button']")
    public WebElement eSearchButtonTop;

    @FindBy(css = "#product-search")
    public WebElement eSearchContainer;

    @FindBy(xpath = "//h4")
    public WebElement displayedProductTitle;

    @FindBy(xpath = "(//button[@data-original-title='Add to Wish List'])[1]")
    public WebElement addToWishListButton;

    @FindBy(xpath = "//a[text()='wish list']")
    public WebElement successAddToWishLink;

    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    public WebElement successAlertMessage;

    @FindBy(xpath = "//a[text()='iMac']")
    public WebElement displayedProductOnWishList;

}
