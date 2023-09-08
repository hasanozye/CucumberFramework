package pageobjects;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjects {

    public LoginObjects() {
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

    @FindBy(css = "#content")
    public WebElement contentBody;

}
