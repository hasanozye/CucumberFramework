package stepdefs;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseSteps {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BaseSteps() {
        driver = Driver.getDriver();
        wait = Driver.getWait();
    }

    public void click(WebElement element) {
//        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        /*
        wait.until(driver1 -> {
            try {
                element.clear();
                element.sendKeys(text);
                return true;
            } catch (Exception e1) {
            return false;
            }
       });
         */
        wait.until(driver1 -> {
            try {
                element.click();
                return true;
            } catch (Exception e1) {
                try {
                    new Actions(driver1)
                            .moveToElement(element)
                            .click()
                            .perform();
                    return true;
                } catch (Exception e2) {
                    try {
                        ((JavascriptExecutor) driver1).executeScript("arguments[0].click()", element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }
                }
            }
        });
    }

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);
    }

    public void hover(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        hover(element);
    }

    public void hover(WebElement element) {
        wait.until(e -> {
            try {
                new Actions(e)
                        .moveToElement(element)
                        .perform();
                return true;
            } catch (Exception e1) {
                return false;
            }
        });
    }

    public void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        sendKeys(element, text);
    }

    public void sendKeys(WebElement element, String text) {

        wait.until(driver1 -> {
            try {
                element.clear();
                element.sendKeys(text);
                return true;
            } catch (Exception e1) {
                try {
                    element.clear();
                    new Actions(driver1)
                            .moveToElement(element)
                            .sendKeys(text)
                            .perform();
                    return true;
                } catch (Exception e2) {
                    try {
                        element.clear();
                        ((JavascriptExecutor) driver1).executeScript("arguments[0].value()'" + text + "'", element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }
                }
            }
        });
    }

    public By xpath(String xpathStr, String label) {
        return By.xpath(String.format(xpathStr, label));
    }

    public void waitForVisibility(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(WebElement element) {
        // Use JavaScript to scroll to the element
        waitForVisibility(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public By getXpathOfButtonOfListedProduct(String text, int index) {
        return By.xpath("//div[@class='product-thumb' and .//div[@class='caption' and .//*[contains(.,'" + text + "')]]]//button[" + index + "]");
    }

    public By getXpathOfLeftSideProduct(String text) {
        return By.xpath("//div[@class='list-group']/a[contains(.,'" + text + "')]");
    }

    public By getXpathOfButtonOfListedProduct(String text, String button) {
        int index = 3;
        if (button.equalsIgnoreCase("wish")) {
            index = 2;
        }
        if (button.equalsIgnoreCase("cart")) {
            index = 1;
        }
        return By.xpath("//div[@class='product-thumb' and .//div[@class='caption' and .//*[contains(.,'" + text + "')]]]//button[" + index + "]");
    }




    public By getXpathOfButtonOfListedProduct(String text, Buttons button) {
        int index = button.ordinal() + 1;
        return By.xpath("//div[contains(@class,'product-thumb') and .//div[@class='caption' and .//*[contains(.,'" + text + "')]]]//button[" + index + "]");
    }

    public By getXpathOfUpsideHeaders(String text) {
        return By.xpath("//div[@id='top-links']/descendant::a[contains(.,'" + text + "')]");
    }

    public By getXpathOfNavigationBarComponents(Headers header) {
        return By.xpath("//ul[contains(@class,'navbar')]/li[contains(.,'" + header + "')]");
    }

    public By getXpathOfNavigationBarComponents(String text) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return By.xpath("//ul[contains(@class,'navbar')]/*[contains(.,'" + text + "')]");
    }

    public enum Buttons {
        cart,
        wish,
        compare;
    }

    public enum Headers {
        Desktops,
        Laptops,
        Components,
        Tablets,
        Software,
        Phones,
        Cameras,
        MP3;
    }

}
