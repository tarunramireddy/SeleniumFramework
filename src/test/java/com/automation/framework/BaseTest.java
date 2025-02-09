package com.automation.framework;

import com.automation.framework.drivers.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    public void setUp() {
        driver = WebDriverManager.initWebDriver();
    }

    public void tearDown() {
        WebDriverManager.tearDown();
    }
}