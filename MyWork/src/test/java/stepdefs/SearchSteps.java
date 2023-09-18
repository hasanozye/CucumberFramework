package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.PageObjects;

public class SearchSteps extends BaseSteps {

    PageObjects pageObjects = new PageObjects();

    @Given("user search for {string}")
    public void userSearchFor(String textToSearch) {
        sendKeys(pageObjects.eSearchBoxTop, textToSearch);
        click(pageObjects.eSearchButtonTop);
        waitForVisibility(pageObjects.eSearchContainer);

    }

    @When("user add {string} to the wishList")
    public void userAddToTheWishList(String productName) {
        click(getXpathOfButtonOfListedProduct(productName, Buttons.wish));
    }

    @Then("success notification with {string} should be visible")
    public void successNotificationWithShouldBeVisible(String text) {
        waitForVisibility(pageObjects.eAlertSuccess);
        Assert.assertTrue(pageObjects.eAlertSuccess.
                getText()
                .toLowerCase()
                .contains(text.toLowerCase()));
    }

    @Given("user hovers the mouse on any of the menu option say {string}")
    public void userHoversTheMouseOnAnyOfTheMenuOptionSay(String text) {
        hover(getXpathOfNavigationBarComponents(Headers.valueOf(text)));

    }

    @When("user clicks on {string} option")
    public void userClicksOnOption(String text) {
        click(getXpathOfNavigationBarComponents(text));
    }
}
