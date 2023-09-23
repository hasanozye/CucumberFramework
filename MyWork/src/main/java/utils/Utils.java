package utils;

import driver.Driver;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.io.FileHandler;

public class Utils {
    /**
     * takescreenshots
     */
    public static void takesScreenShot() {
        takeScreenShot("screenshot");
    }

    /**
     * @param fileName file name of the screenshot
     */
    public static void takeScreenShot(String fileName) {
        fileName = fileName + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        String filePath = "screenShot/" + fileName + ".png";
        TakesScreenshot scrShot = ((TakesScreenshot) Driver.getDriver());
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        try {
            FileHandler.copy(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createDirectory(String fileWithPath) {
        String[] pathArray = fileWithPath.split("/");
        String path = "";
        if (pathArray.length > 0) {
            for (int i = 0; i < pathArray.length; i++) {
                path += pathArray[i] + "/";
            }
        }
        File theDir = new File(path);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }

    /**
     * alinan screenshot'i byte[] olarak return eder
     *
     * @return screenshot in byte[]
     */
    public static byte[] getScreenShotAsByte() {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * java sleep
     *
     * @param millis milliseconds
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static By getBy(String main, String sub) throws FileNotFoundException {

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
