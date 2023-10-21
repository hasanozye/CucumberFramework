package _temp;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonReadClass {
    public static void main(String[] args) throws FileNotFoundException {

        // 1. Define the file path for the JSON file containing the data.
        String jsonFile = "MyWork/src/test/resources/datafiles/Elements.json";

        // 2. Read the JSON file for the first time and parse it into a JSONObject.
        JSONObject object = (JSONObject) JSONValue.parse(new FileReader(jsonFile));

        // 3. Retrieve the 'myaccount' object from the parsed JSON.
        JSONObject myaccount = (JSONObject) object.get("myaccount");

        String type = myaccount.get("type").toString();
        String locator = myaccount.get("locator").toString();
        System.out.println(getBy(type, locator));
    }

        public static By getBy(String type, String locator) {

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
}
