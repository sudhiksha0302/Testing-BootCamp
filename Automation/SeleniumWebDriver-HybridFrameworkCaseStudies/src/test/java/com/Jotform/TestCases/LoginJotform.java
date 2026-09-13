package com.Jotform.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Jotform.Pages.BaseClass;
import com.Jotform.Pages.LoginPage;

import com.Jotform.utility.ExcelDataReader;

public class LoginJotform extends BaseClass {

    @Test
    public void loginApp() throws Exception {

        ExcelDataReader excel = new ExcelDataReader();

        LoginPage loginJotform = PageFactory.initElements(
                driver,
                LoginPage.class
        );

        loginJotform.login_Jotform(
                excel.getStringData("LoginJotform", 0, 0),
                excel.getStringData("LoginJotform", 0, 1)
        );

        Thread.sleep(5000);

    }

}