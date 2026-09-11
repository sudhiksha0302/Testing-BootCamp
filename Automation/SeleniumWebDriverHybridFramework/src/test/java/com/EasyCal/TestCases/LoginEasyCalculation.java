package com.EasyCal.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.EasyCal.Pages.BaseClass;
import com.EasyCal.Pages.LoginPage;

public class LoginEasyCalculation extends BaseClass {

    @Test
    public void loginApp() throws Exception {

        LoginPage loginHRM =
                PageFactory.initElements(driver, LoginPage.class);

        loginHRM.login_easyCal(
                excel.getStringData("LoginHRM", 0, 0),
                excel.getStringData("LoginHRM", 0, 1)
        );

        Thread.sleep(5000);
    }
}