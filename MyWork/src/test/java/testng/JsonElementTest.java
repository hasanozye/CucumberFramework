package testng;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import stepdefs.BaseSteps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import static utils.Utils.getBy;
import static utils.Utils.getValue;

public class JsonElementTest extends BaseSteps {


    @Test
    public void test1() throws FileNotFoundException {
        driver.get(getValue("application", "url"));
        click(getBy("topmenu", "myaccount"));
        click(getBy("topmenu", "loginlink"));
        sendKeys(getBy("login", "username"), getValue("application", "username"));
        sendKeys(getBy("login", "password"), getValue("application", "password"));
        click(getBy("login", "submitbutton"));
        waitForVisibility(getBy("account", "sitemapaccount"));


        sendKeys(getBy("search", "searchbox"), "iMac");
        click(getBy("search", "searchbutton"));
        waitForVisibility(getBy("search", "searchcontainer"));
        click(getXpathOfButtonOfListedProduct("iMac", Buttons.wish));
        waitForVisibility(getBy("search", "successalert"));
        Assert.assertTrue(driver
                .findElement(getBy("search", "successalert"))
                .getText()
                .toLowerCase()
                .contains("wish list!"));

        driver.quit();

    }
}
