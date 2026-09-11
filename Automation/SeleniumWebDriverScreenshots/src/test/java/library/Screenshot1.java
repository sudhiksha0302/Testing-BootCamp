package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Screenshot1 {

    @Test
    public void browser() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.get("https://elfsight.com/online-form-builder/templates/html-employee-registration-form/");

        driver.manage().window().maximize();
        Reusability.capturedScreensShot(driver, "page");

        driver.quit();
    }
}