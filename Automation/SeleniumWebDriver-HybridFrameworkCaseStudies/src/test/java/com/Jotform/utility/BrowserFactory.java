package com.Jotform.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    WebDriver driver;

    public static WebDriver startBrowser(
            WebDriver driver,
            String browserName,
            String AppUrl) {

        if (browserName.equalsIgnoreCase("Chrome")
                || browserName.equalsIgnoreCase("GC")
                || browserName.equalsIgnoreCase("Google Chrome")) {

            driver = new ChromeDriver();

            driver.manage().window().maximize();

        }

        else if (browserName.equalsIgnoreCase("Edge")
                || browserName.equalsIgnoreCase("EG")
                || browserName.equalsIgnoreCase("Microsoft Edge")) {

            driver = new EdgeDriver();

            driver.manage().window().maximize();

        }

        else if (browserName.equalsIgnoreCase("FireFox")
                || browserName.equalsIgnoreCase("FF")
                || browserName.equalsIgnoreCase("Mozilla Firefox")) {

            driver = new FirefoxDriver();

            driver.manage().window().maximize();

        }

        else {

            System.out.println(
                    "Sorry we do not support this browser"
            );

        }

        driver.get(AppUrl);

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(10)
        );

        return driver;

    }

    public static void closeBrowser(WebDriver driver) {

        driver.quit();

    }

}