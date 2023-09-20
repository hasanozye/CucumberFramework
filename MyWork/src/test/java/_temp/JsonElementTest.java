package _temp;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Test;
import org.openqa.selenium.By;
import stepdefs.BaseSteps;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonElementTest extends BaseSteps {


    @Test
    public void test1() throws FileNotFoundException {
        driver.get(getValue("application", "url"));
        click(getBy("topmenu", "myaccount"));
        click(getBy("topmenu", "loginlink"));
        sendKeys(getBy("login", "username"), getValue("application", "username"));
        sendKeys(getBy("login", "password"), getValue("application", "password"));
        click(getBy("login", "submitbutton"));
        waitForVisibility(getBy("account","sitemapac count"));
        driver.quit();

    }

    public By getBy(String main, String sub) throws FileNotFoundException {

        String jsonFile = "src/test/resources/datafiles/Elements.json";


        JSONObject object = (JSONObject) JSONValue.parse(new FileReader(jsonFile));


        JSONObject mainNode = (JSONObject) object.get(main);
        JSONObject subNode = (JSONObject) mainNode.get(sub);

//         get
        String type = subNode.get("type").toString();
        String locator = subNode.get("locator").toString();

        switch (type) {
            case "xpath" -> {
                return By.xpath(locator);
            }
            case "css" -> {
                return By.cssSelector(locator);
            }
            case "id" -> {
                return By.id(locator);
            }
            case "tagname" -> {
                return By.tagName(locator);
            }
            case "classname" -> {
                return By.className(locator);
            }
            case "linktext" -> {
                return By.linkText(locator);
            }
            case "partiallinktext" -> {
                return By.partialLinkText(locator);
            }
            default -> {
                return null;
            }
        }

    }

    public static String getValue(String main, String key) throws FileNotFoundException {

        String jsonFile = "src/test/resources/datafiles/Elements.json";

        JSONObject object = (JSONObject) JSONValue.parse(new FileReader(jsonFile));

        JSONObject mainNode = (JSONObject) object.get(main);
        return mainNode.get(key).toString();


    }
}
