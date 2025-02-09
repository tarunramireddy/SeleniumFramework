package com.automation.framework.drivers;

import com.automation.framework.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    private static WebDriver webDriver;

    public static WebDriver initWebDriver() {
        String chromeDriverPath = ConfigReader.getProperty("chromeDriverPath");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        webDriver = new ChromeDriver();
        return webDriver;
    }

    public static void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}