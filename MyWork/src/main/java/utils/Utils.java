package utils;

import driver.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
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
}
