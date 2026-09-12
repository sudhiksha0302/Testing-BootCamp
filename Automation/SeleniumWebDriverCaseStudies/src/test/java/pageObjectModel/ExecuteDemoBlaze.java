package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObjectModel.LoginDemoBlaze;
import utility.BrowserFactory;

public class ExecuteDemoBlaze {

    @Test
    public void CheckValidUser() {

        WebDriver driver = BrowserFactory.BrowserOptions(
                "chrome",
                "https://www.demoblaze.com/index.html"
        );

        LoginDemoBlaze loginPage =
                PageFactory.initElements(driver, LoginDemoBlaze.class);

        loginPage.login_DemoBlaze("testuser0302", "testpassword0302");
    }
}