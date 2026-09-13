package com.NopCommerce.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.NopCommerce.Pages.BaseClass;
import com.NopCommerce.Pages.LoginPage;

import com.NopCommerce.utility.ExcelDataReader;

public class LoginNopCommerce extends BaseClass {

    @Test
    public void loginApp() throws Exception {

        ExcelDataReader excel = new ExcelDataReader();

        LoginPage loginNopCommerce = PageFactory.initElements(
                driver,
                LoginPage.class
        );

        loginNopCommerce.login_NopCommerce(
                excel.getStringData("LoginNopCommerce", 0, 0),
                excel.getStringData("LoginNopCommerce", 0, 1)
        );

        Thread.sleep(5000);

    }

}