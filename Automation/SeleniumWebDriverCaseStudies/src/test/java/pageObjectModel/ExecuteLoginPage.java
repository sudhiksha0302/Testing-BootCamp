package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObjectModel.LoginSauceDemo;
import utility.BrowserFactory;

public class ExecuteLoginPage {

    @Test
    public void CheckValidUser() throws Exception {

        WebDriver driver = BrowserFactory.BrowserOptions(
                "chrome",
                "https://www.saucedemo.com/"
        );

        LoginSauceDemo loginPage =
                PageFactory.initElements(driver, LoginSauceDemo.class);

        loginPage.login_SauceDemo(
                "standard_user",
                "secret_sauce"
        );
    }
}