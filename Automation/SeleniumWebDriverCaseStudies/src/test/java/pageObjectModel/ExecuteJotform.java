package pageObjectModel;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import pageObjectModel.LoginJotform;

import utility.BrowserFactory;

public class ExecuteJotform {

    @Test
    public void TestValidLogin() {

        WebDriver driver = BrowserFactory.BrowserOptions(
                "Chrome",
                "https://www.jotform.com/login/");

        LoginJotform loginPageJotForm =
                PageFactory.initElements(driver, LoginJotform.class);

        loginPageJotForm.login_JotForm(
                "testuser@gmail.com",
                "testpassword");

        //driver.quit();

    }

}