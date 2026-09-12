package javaScriptAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility.Helper;

public class KSRTCAlerts {

    @Test
    public void TestPopups() throws Exception {

        WebDriver driver = Helper.startBrowser("Edge");

        // Open KSRTC login page
        driver.get("https://www.ksrtc.in/login");

        // Case 1 - Empty Email
        driver.findElement(By.xpath(
                "//div[contains(@class,'payee-info-inputs')]//div[contains(@class,'inp-container')][1]//input"))
                .clear();

        driver.findElement(By.xpath(
                "(//div[contains(@class,'auth-page')]//*[normalize-space()='Login'])[last()]"))
                .click();

        Thread.sleep(1000);

        String result1 = driver.findElement(By.tagName("body")).getText();

        System.out.println("Result:");
        System.out.println(result1);

        Assert.assertTrue(result1.contains("Please Enter Email"));

        driver.findElement(By.xpath(
                "//div[contains(@class,'alert')]//*[normalize-space()='OK']"))
                .click();

        Thread.sleep(1000);

        // Case 2 - Empty Phone
        driver.findElement(By.xpath(
                "//div[contains(@class,'payee-info-inputs')]//div[contains(@class,'inp-container')][1]//input"))
                .sendKeys("sudhikshaa2006@gmail.com");

        driver.findElement(By.xpath(
                "//div[contains(@class,'payee-info-inputs')]//div[contains(@class,'inp-container')][3]//input"))
                .clear();

        driver.findElement(By.xpath(
                "(//div[contains(@class,'auth-page')]//*[normalize-space()='Login'])[last()]"))
                .click();

        Thread.sleep(1000);

        String result2 = driver.findElement(By.tagName("body")).getText();

        System.out.println("Result:");
        System.out.println(result2);

        Assert.assertTrue(result2.contains("Please Enter Phone"));

        driver.findElement(By.xpath(
                "//div[contains(@class,'alert')]//*[normalize-space()='OK']"))
                .click();

        Thread.sleep(1000);

        // Case 3 - Empty Password
        driver.findElement(By.xpath(
                "//div[contains(@class,'payee-info-inputs')]//div[contains(@class,'inp-container')][3]//input"))
                .sendKeys("8639849165");

        driver.findElement(By.xpath(
                "//div[contains(@class,'payee-info-inputs')]//div[contains(@class,'inp-container')][4]//input"))
                .clear();

        driver.findElement(By.xpath(
                "(//div[contains(@class,'auth-page')]//*[normalize-space()='Login'])[last()]"))
                .click();

        Thread.sleep(1000);

        String result3 = driver.findElement(By.tagName("body")).getText();

        System.out.println("Result:");
        System.out.println(result3);

        Assert.assertTrue(result3.contains("Please Enter Password"));

        driver.findElement(By.xpath(
                "//div[contains(@class,'alert')]//*[normalize-space()='OK']"))
                .click();

        Thread.sleep(1000);

        // Case 4 - Terms and Conditions
        driver.findElement(By.xpath(
                "//div[contains(@class,'payee-info-inputs')]//div[contains(@class,'inp-container')][4]//input"))
                .sendKeys("Sudhi@0302");

        driver.findElement(By.xpath(
                "(//div[contains(@class,'auth-page')]//*[normalize-space()='Login'])[last()]"))
                .click();

        Thread.sleep(1000);

        String result4 = driver.findElement(By.tagName("body")).getText();

        System.out.println("Result:");
        System.out.println(result4);

        Assert.assertTrue(result4.contains("You need to agree to KSRTC's"));

        driver.findElement(By.xpath(
                "//div[contains(@class,'alert')]//*[normalize-space()='AGREE']"))
                .click();

        Thread.sleep(1000);

        // Case 5 - Security Verification
        driver.findElement(By.xpath(
                "(//div[contains(@class,'auth-page')]//*[normalize-space()='Login'])[last()]"))
                .click();

        Thread.sleep(2000);

        String result5 = driver.findElement(By.tagName("body")).getText();

        System.out.println("Result:");
        System.out.println(result5);

        Assert.assertTrue(
                result5.contains("Security verification failed. Please try again."));

        driver.findElement(By.xpath(
                "//div[contains(@class,'alert')]//*[normalize-space()='OK']"))
                .click();

        Thread.sleep(1000);

        // Case 6 - Login and Home Page
        driver.findElement(By.xpath(
                "(//div[contains(@class,'auth-page')]//*[normalize-space()='Login'])[last()]"))
                .click();

        Thread.sleep(5000);

        driver.get("https://www.ksrtc.in/");

        Thread.sleep(3000);

        String result6 = driver.findElement(By.tagName("body")).getText();

        System.out.println("Result:");
        System.out.println(result6);

        Assert.assertTrue(result6.contains("Home"));

        driver.quit();
    }
}