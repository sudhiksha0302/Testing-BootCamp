package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginNopCommerce {

    WebDriver driver;

    public LoginNopCommerce(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(xpath = "//button[contains(@class,'login-button')]")
    WebElement loginButton;

    public void login_NopCommerce(String mail, String pass) {

        email.clear();
        email.sendKeys(mail);

        password.clear();
        password.sendKeys(pass);

        loginButton.click();
    }
}