package com.automation.framework.tests;

import com.automation.framework.drivers.WebDriverManager;
import com.automation.framework.utils.ConfigReader;
import com.automation.framework.utils.LoggerUtil;
import com.automation.framework.utils.ScreenshotUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest {

    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.initWebDriver();
        driver.get(ConfigReader.getProperty("appUrl") + "/login");

        try {
            // Logging the test start
            LoggerUtil.logInfo("Starting Login Test");

            WebElement usernameField = driver.findElement(By.xpath("//input[@id='email']"));
            Thread.sleep(2000);
            WebElement passwordField = driver.findElement(By.xpath("//input[@id='pass']"));
            Thread.sleep(2000);
            WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
            Thread.sleep(2000);

            usernameField.sendKeys(ConfigReader.getProperty("username"));
            passwordField.sendKeys(ConfigReader.getProperty("password"));
            loginButton.click();

            // Validating login success
            if (driver.getTitle().contains("Dashboard")) {
                LoggerUtil.logInfo("Login Test Passed");
            } else {
                LoggerUtil.logInfo("Login Test Failed");
            }
        } catch (Exception e) {
            LoggerUtil.logError("Login Test encountered an error", e);
            ScreenshotUtil.takeScreenshot(driver, "LoginTest");
        } finally {
            WebDriverManager.tearDown();
        }
    }
}