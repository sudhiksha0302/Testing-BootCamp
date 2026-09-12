package pageObjectModel;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class LoginJotform {

    WebDriver driver;

    public LoginJotform(WebDriver driver) {

        this.driver = driver;

    }

    @FindBy(xpath="//input[@type='email']")
    WebElement email;

    @FindBy(xpath="//input[@type='password']")
    WebElement password;

    @FindBy(xpath="//button[contains(text(),'Log in')]")
    WebElement loginbtn;

    public void login_JotForm(String uname, String pass) {

        email.sendKeys(uname);

        password.sendKeys(pass);

        loginbtn.click();

    }

}