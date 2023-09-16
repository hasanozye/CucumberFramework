package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static driver.DriverFactory.*;

public class Driver {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> waits = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return getDriver(Browsers.chrome);
    }

    public static WebDriver getDriver(Browsers browser) {
        if (drivers.get() == null) {
            switch (browser) {
                case firefox -> {
                    drivers.set(createFirefox());
                }
                case edge -> {
                    drivers.set(createEdge());
                }
                case ie -> {
                    drivers.set(createIe());
                }
                case safari -> {
                    drivers.set(createSafari());
                }
                default -> {
                    drivers.set(createChrome());
                }
            }
        }
        waits.set(new WebDriverWait(drivers.get(), Duration.ofSeconds(10)));
        return drivers.get();
    }

    public static WebDriverWait getWait() {
        return waits.get();
    }

    public static void quitDriver() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }
}
