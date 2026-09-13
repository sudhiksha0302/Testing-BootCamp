package com.NopCommerce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;

    }

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(xpath = "//button[contains(@class,'login-button')]")
    WebElement loginbtn;

    public void login_NopCommerce(String uname, String pass) {

        email.clear();

        email.sendKeys(uname);

        password.clear();

        password.sendKeys(pass);

        loginbtn.click();

    }

}