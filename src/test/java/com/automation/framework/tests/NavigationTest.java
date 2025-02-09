package com.automation.framework.tests;

import com.automation.framework.drivers.WebDriverManager;
import com.automation.framework.utils.LoggerUtil;
import com.automation.framework.utils.ScreenshotUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationTest {

    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.initWebDriver();
        driver.get("https://example.com");

        try {
            // Logging the test start
            LoggerUtil.logInfo("Starting Navigation Test");

            driver.findElement(By.linkText("About Us")).click();

            if (driver.getTitle().contains("About Us")) {
                LoggerUtil.logInfo("Navigation Test Passed");
            } else {
                LoggerUtil.logInfo("Navigation Test Failed");
            }
        } catch (Exception e) {
            LoggerUtil.logError("Navigation Test encountered an error", e);
            ScreenshotUtil.takeScreenshot(driver, "NavigationTest");
        } finally {
            WebDriverManager.tearDown();
        }
    }
}