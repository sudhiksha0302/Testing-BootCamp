package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginHiox {

    WebDriver driver;

    public LoginHiox(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "log_email")
    WebElement username;

    @FindBy(id = "log_password")
    WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    public void login_Hiox(String uname, String pass) {

        username.sendKeys(uname);
        password.sendKeys(pass);
        loginButton.click();
    }
}
