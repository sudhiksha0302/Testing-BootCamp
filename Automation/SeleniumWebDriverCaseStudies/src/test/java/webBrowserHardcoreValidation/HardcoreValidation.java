package webBrowserHardcoreValidation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardcoreValidation {

    @Test
    public void ValidateBrowserInformation() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();

        String expectedTitle = "Test Login | Practice Test Automation";
        String expectedUrl = "https://practicetestautomation.com/practice-test-login/";

        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();

        System.out.println("Expected Title: " + expectedTitle);
        System.out.println("Actual Title: " + actualTitle);
        System.out.println("Expected URL: " + expectedUrl);
        System.out.println("Actual URL: " + actualUrl);

        Assert.assertEquals(actualTitle, expectedTitle, "Browser title is not matching");
        Assert.assertEquals(actualUrl, expectedUrl, "Browser URL is not matching");
        System.out.println("Title and URL validated successfully");

        driver.quit();
    }
}
