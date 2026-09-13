package com.Jotform.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;

    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@id='signinButton']")
    WebElement loginbtn;

    public void login_Jotform(String uname, String pass) {

        username.sendKeys(uname);

        password.sendKeys(pass);

        loginbtn.click();

    }

}