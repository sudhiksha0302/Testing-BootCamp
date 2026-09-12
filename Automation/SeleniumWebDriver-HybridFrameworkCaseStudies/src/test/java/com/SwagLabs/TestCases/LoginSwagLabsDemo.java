package com.SwagLabs.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.SwagLabs.Pages.BaseClass;
import com.SwagLabs.Pages.LoginPage;

import utility.ExcelDataReader;

public class LoginSwagLabsDemo extends BaseClass {

    @Test
    public void loginApp() throws Exception {

        ExcelDataReader excel = new ExcelDataReader();

        LoginPage loginSauceDemo = PageFactory.initElements(
                driver,
                LoginPage.class
        );

        loginSauceDemo.login_SauceDemo(
                excel.getStringData("LoginSauceDemo", 0, 0),
                excel.getStringData("LoginSauceDemo", 0, 1)
        );

        Thread.sleep(5000);

    }

}