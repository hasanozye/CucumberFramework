package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import driver.Driver;
import org.apache.poi.ss.usermodel.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.io.FileHandler;
import readers.json.MyJsonPojo;

public class Utils {

    private static final String ENTER = "\n";

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

    /**
     * bu method okunacak .json dosyasını pojo.class'a map eder.
     *
     * @param file okunacak json file
     * @param pojo parent'i MyJsonPojo olan pojo class'i
     * @return Object olarak return eder, işlem sırasında sub class'a cast edilmeli.
     */
    public static Object getPojo(String file, MyJsonPojo pojo) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new FileReader(file), pojo.getClass());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public MyJsonPojo t1(String jsonFile, MyJsonPojo pojo) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new FileReader(jsonFile), pojo.getClass());

    }

    /**
     * özel bir excel dosyasinda yazili gherkin satirlarindan feature file olusturma.
     *
     * @param excelFile   gherkin olan excel dosyasi
     * @param featureFile olusturulacak feature dosya adi
     */
    public static void createFeatureFileFromExcel(String excelFile, String featureFile) {
        try {
            FileWriter fileWriter = new FileWriter(featureFile);

            // java excel'i okudu
            FileInputStream fileInputStream = new FileInputStream(excelFile);

            // Apache poi excel'i workbook olarak tanidi
            Workbook workbook = WorkbookFactory.create(fileInputStream);

            // ilk sayfa okundu
            Sheet sheet = workbook.getSheetAt(0);

            // row sayisi alindi
            int rowNums = sheet.getPhysicalNumberOfRows();

            String featureLine = "Feature: " + sheet.getRow(1).getCell(0).toString();
            fileWriter.write(featureLine + ENTER);

            String scenarioLine = sheet.getRow(1).getCell(1).toString();
            scenarioLine += ":";
            scenarioLine += sheet.getRow(1).getCell(2).toString();

            fileWriter.write(scenarioLine + ENTER);

            for (int i = 1; i < rowNums; i++) {
                Cell cell = sheet.getRow(i).getCell(3);
                String str = cell == null ? "" : cell.toString();
                fileWriter.write(str + ENTER);
            }
            workbook.close();
            fileInputStream.close();
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
