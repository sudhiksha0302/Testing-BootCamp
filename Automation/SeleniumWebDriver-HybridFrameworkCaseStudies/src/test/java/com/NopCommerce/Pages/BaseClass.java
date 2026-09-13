package com.NopCommerce.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.NopCommerce.utility.BrowserFactory;
import com.NopCommerce.utility.ConfigDataProvider;
import com.NopCommerce.utility.ExcelDataReader;
import com.NopCommerce.utility.Helper;

public class BaseClass {

    public WebDriver driver;

    public ExcelDataReader excel;

    public ConfigDataProvider config;

    @BeforeSuite
    public void SetUp() {

        excel = new ExcelDataReader();

        config = new ConfigDataProvider();

    }

    @BeforeClass
    public void BrowserTest() {

        driver = BrowserFactory.startBrowser(
                driver,
                config.getBrowser(),
                config.getAppURL()
        );

    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            Helper.capturedScreenShot(driver);

        }

    }

    @AfterClass
    public void teardown() {

        BrowserFactory.closeBrowser(driver);

    }

}