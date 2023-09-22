package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @When("user scroll down and click to the {string}")
    public void userScrollDownAndClickToThe(String product) {
        WebElement element1 = driver.findElement(By.xpath("//div[@class='product-thumb']/descendant::h4//a[text()='" + product + "']"));
        scrollToElement(element1);
        click(element1);
        waitForVisibility(driver.findElement(By.xpath("//div[@id='tab-description']/descendant::b[contains(.,'Intel')]")));
    }

    @And("user click on the {string} header option")
    public void userClickOnTheHeaderOption(String headerName) {
        click(getXpathOfUpsideHeaders(headerName));
        waitForVisibility(driver.findElement(By.xpath("//div[@id='top-links']/descendant::a[contains(.,'" + headerName + "')]")));
    }

    @And("user add product to the wishList from product page")
    public void userAddToTheWishListFromProductPage() {
        click(pageObjects.AddToWishListButtonInProductPage);
    }
}
