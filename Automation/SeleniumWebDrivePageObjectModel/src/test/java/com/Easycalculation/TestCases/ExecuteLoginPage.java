package com.Easycalculation.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Easycalculation.Pages.LoginEasyCal;

import Helper.BrowserFcatory;

public class ExecuteLoginPage {

    @Test
    public void CheckValidUser() {

        WebDriver driver = BrowserFcatory.startBrowser("edge");

        driver.get("https://www.login.hiox.com/login?referrer=easycalculation.com");

        LoginEasyCal loginPageEasyCal =
                PageFactory.initElements(driver, LoginEasyCal.class);

        loginPageEasyCal.login_easyCal(
                "sudhikshaa2006@gmail.com",
                "Sudhi@0302"
        );

        BrowserFcatory.closeBrowser(driver);
    }
}