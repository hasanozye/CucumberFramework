package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import readers.property.PropertyReader;

public class DriverFactory {

    public static WebDriver createChrome() {
        ChromeOptions options = new ChromeOptions();
        PropertyReader pr = PropertyReader.read();
        for (String s : pr.get("chrome.options").split(",")) {
            options.addArguments(s.trim());
        }
        return new ChromeDriver(options);
    }

    public static WebDriver createEdge() {
        EdgeOptions options = new EdgeOptions();
        PropertyReader pr = PropertyReader.read();
        for (String s : pr.get("edge.options").split(",")) {
            options.addArguments(s.trim());
        }
        return new EdgeDriver(options);
    }

    public static WebDriver createFirefox() {
        FirefoxOptions options = new FirefoxOptions();
        PropertyReader pr = PropertyReader.read();
        for (String s : pr.get("firefox.options").split(",")) {
            options.addArguments(s.trim());
        }
        return new FirefoxDriver(options);
    }

    public static WebDriver createIe() {
        if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
            throw new WebDriverException("Your OS doesn't support Internet Explorer");
        }
        InternetExplorerOptions options = new InternetExplorerOptions();
        PropertyReader pr = PropertyReader.read();
        return new InternetExplorerDriver();
    }

    public static WebDriver createSafari() {
        if (!System.getProperty("os.name").toLowerCase().contains("mac")) {

            throw new WebDriverException("Your OS doesn't support Safari");
        }
        SafariOptions options = new SafariOptions();
        PropertyReader pr = PropertyReader.read();
        options.setCapability("safari.cleanSession", true);
        options.setAutomaticInspection(true);
        options.getUseTechnologyPreview();
        return new SafariDriver(options);
    }


}
