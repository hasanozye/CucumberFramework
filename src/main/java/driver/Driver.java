package driver;

import org.openqa.selenium.WebDriver;

import static driver.DriverFactory.*;

public class Driver {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

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
        return drivers.get();
    }

    public static void quitDriver() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }
}
