package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageobjects.PageObjects;
import readers.property.PropertyReader;

import java.util.List;
import java.util.Map;

public class LoginSteps extends BaseSteps {

    PageObjects loginObjects;

    @Given("user on homepage")
    public void userOnHomepage() {
        loginObjects = new PageObjects();
        String url = PropertyReader.read().get("url");
        driver.get(url);
    }

    @When("user clicks My Account Link")
    public void userClicksMyAccountLink() {
        click(loginObjects.menuMyAccountLink);
    }

    @And("user clicks Login Link")
    public void userClicksLoginLink() {
        click(loginObjects.menuLoginLink);
    }

    @Then("login page should be visible")
    public void loginPageShouldBeVisible() {
        waitForVisibility(loginObjects.loginFormUsername);
    }

    @When("user fill the login form with the following datas")
    public void userFillTheLoginFormWithTheFollowingDatas(DataTable table) {
        Map<String, String> datas = table.asMap();
        String username = datas.get("username") == null ? "" : datas.get("username");
        String password = datas.get("password") == null ? "" : datas.get("password");
        sendKeys(loginObjects.loginFormUsername, username);
        sendKeys(loginObjects.loginFormPassword, password);

    }

    @And("user clicks Login button")
    public void userClicksLoginButton() {
        click(loginObjects.loginFormSubmitButton);
    }

    @Then("login should be successfull")
    public void loginShouldBeSuccessfull() {
        waitForVisibility(loginObjects.MyAccountSignedIn);

    }

    @Then("login should be fail")
    public void loginShouldBeFail() {
        waitForVisibility(loginObjects.warningAlert);
        Assert.assertTrue(loginObjects.warningAlert.getText().contains("No match for E-Mail Address"));
    }

    @When("user clicks forgotten password link")
    public void userClicksForgottenPasswordLink() {
        click(loginObjects.forgottenPasswordLink);
        waitForVisibility(loginObjects.accountForgottenBody);

    }


    @When("user fill the email with the following data")
    public void userFillTheEmailWithTheFollowingData(DataTable table) {
        Map<String, String> data = table.asMap();
        String username = data.get("username");
        sendKeys(loginObjects.loginFormUsername, username);
    }

    @And("Press Tab keyboard key until the control comes to the {string} text field")
    public void pressTabKeyboardKeyUntilTheControlComesToTheTextField(String text) {
        String locator = "//*[contains( @name,'%s')]";
        xpath(locator, text);
        By body = By.xpath("//body");
        /*do {
            driver.findElement(body).sendKeys(Keys.TAB);
        }*/
    }

    @When("user fill the password with the following data")
    public void userFillThePasswordWithTheFollowingData(DataTable table) {
        Map<String, String> data = table.asMap();
        String password = data.get("password");
        sendKeys(loginObjects.loginFormUsername, password);
    }

    @When("user clicks the following links with text")
    public void userClicksTheFollowingLinksWithText(DataTable table) {
        String xpathOfLink = "//a[contains(.,'%s')]";
        List<String> list = table.asList();
        for (String text : list) {
            By locator = By.xpath(String.format(xpathOfLink, text));
            click(locator);
        }

    }

    @Then("login should be {string}")
    public void loginShouldBe(String text) {
        if (text.equalsIgnoreCase("true")) {
            Assert.assertTrue(loginObjects.MyAccountSignedIn.isDisplayed());
        } else {
            Assert.assertTrue(loginObjects.warningAlert.isDisplayed());
        }
    }

    @Then("user clicks on the button having search icon")
    public void userClicksOnTheButtonHavingSearchIcon() {
        click(loginObjects.eSearchButtonTop);
    }

    @And("user clicks on the Product displayed in the Search results")
    public void userClicksOnTheProductDisplayedInTheSearchResults() {
        scrollToElement(loginObjects.displayedProductTitle);
        click(loginObjects.displayedProductTitle);
    }

    @And("user clicks on Add to Wish List option on a product that is displayed in the Related Products section of Product Display page")
    public void userClicksOnAddToWishListOptionOnAProductThatIsDisplayedInTheRelatedProductsSectionOfProductDisplayPage() {
        waitForVisibility(loginObjects.addToWishListButton);
        click(loginObjects.addToWishListButton);
        waitForVisibility(loginObjects.successAlertMessage);
    }

    @And("user clicks on the wish list! link in the displayed success message")
    public void userClicksOnTheWishListLinkInTheDisplayedSuccessMessage() {
        click(loginObjects.successAddToWishLink);
        waitForVisibility(loginObjects.displayedProductOnWishList);
    }

    @When("user login with username {string} and password {string}")
    public void userLoginWithUsernameAndPassword(String username, String password) {
        click(loginObjects.menuMyAccountLink);
        click(loginObjects.menuLoginLink);
        waitForVisibility(loginObjects.loginFormUsername);
        sendKeys(loginObjects.loginFormUsername, username);
        sendKeys(loginObjects.loginFormPassword, password);
        click(loginObjects.loginFormSubmitButton);


    }
}
