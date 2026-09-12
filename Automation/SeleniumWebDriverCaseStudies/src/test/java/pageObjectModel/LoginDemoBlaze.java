package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginDemoBlaze {

    WebDriver driver;

    public LoginDemoBlaze(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "login2")
    WebElement loginLink;

    @FindBy(id = "loginusername")
    WebElement username;

    @FindBy(id = "loginpassword")
    WebElement password;

    @FindBy(xpath = "//button[text()='Log in']")
    WebElement loginButton;

    public void login_DemoBlaze(String uname, String pass) {

        loginLink.click();

        username.sendKeys(uname);
        password.sendKeys(pass);

        loginButton.click();
    }
}
