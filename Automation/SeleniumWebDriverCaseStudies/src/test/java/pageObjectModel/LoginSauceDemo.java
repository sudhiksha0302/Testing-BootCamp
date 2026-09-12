package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginSauceDemo {

    WebDriver driver;

    public LoginSauceDemo(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;

    public void login_SauceDemo(String uname, String pass) throws Exception {

        username.sendKeys(uname);

        password.sendKeys(pass);

        loginButton.click();
    }
}