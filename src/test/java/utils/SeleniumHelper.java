package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SeleniumHelper {
    public static void waitForElementToExist(WebDriver driver, By locator){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public static void waitForElementToBeVisible(WebDriver driver, WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public static void waitForNotToEmptyList(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(driver1 -> driver.findElements(locator).size() > 0);
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(element)));
    }

    private static String takeScreenshot(WebDriver driver) throws IOException {
        int randomNumber = (int) (Math.random() * 1000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        String path = "src/test/resources/screenshots/screenshot" + randomNumber + ".png";
        FileUtils.copyFile(file, new File(path));
        return path;
    }
    public static void scrollAndClick(WebDriver driver,WebElement element){
        try {
            // Scroll element into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            // Optional: small pause to let any sticky banners move
            Thread.sleep(300);

            // Try normal click
            element.click();

        } catch (Exception e) {
            System.out.println("Normal click failed, trying JS click. Reason: " + e.getMessage());

            // Fallback: force JS click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
}
