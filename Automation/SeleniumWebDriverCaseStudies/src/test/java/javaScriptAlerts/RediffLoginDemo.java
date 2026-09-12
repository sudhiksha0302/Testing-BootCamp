package javaScriptAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility.Helper;

public class RediffLoginDemo {

    @Test
    public void TestLogin() throws Exception {

        WebDriver driver = Helper.startBrowser("Edge");

        // Open Rediff login page
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

        // Enter username
        driver.findElement(By.id("login1")).sendKeys("sudhikshaa2006");

        // Enter password
        driver.findElement(By.id("password")).sendKeys("TestPassword123");

        // Click Login
        driver.findElement(By.name("proceed")).click();

        Thread.sleep(3000);

        // Get page text
        String result = driver.findElement(By.tagName("body")).getText();

        System.out.println("Result:");
        System.out.println(result);

        // Verify human verification page
        Assert.assertTrue(result.contains("Please verify that you are a human."));

        driver.quit();
    }
}