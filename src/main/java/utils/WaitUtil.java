package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;
import driver.DriverFactory;

public class WaitUtil {

    private static WebDriverWait getWait() {
        return new WebDriverWait(
            DriverFactory.getDriver(),
            Duration.ofSeconds(Long.parseLong(ConfigReader.get("explicit.wait")))
        );
    }

    public static WebElement presenecOfElement(By locator) {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    public static List<WebElement> presenceOfAllElement(By locator){
    	return getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public static WebElement visibilityOfElement(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public static List<WebElement> visibilityOfAllElement(By locator){
    	return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static WebElement elementToBeClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebDriver handleFrame(By locator) {
        return getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }
    
    public static Alert handleAlert() {
    	return getWait().until(ExpectedConditions.alertIsPresent());
    }
    
    public static String getText(By locator) {
    	return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}
