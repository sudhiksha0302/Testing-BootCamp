package dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

    WebDriver driver;

    @Test(dataProvider = "TestAutomation")
    public void Browser(String UserName, String Password) throws Exception {

        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("username")).sendKeys(UserName);
        driver.findElement(By.name("password")).sendKeys(Password);
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        String actualTitle = driver.getTitle();
        System.out.println("Actual Title: " + actualTitle);
        String expectedTitle = "Logged In Successfully | Practice Test Automation";
        Assert.assertEquals(actualTitle,expectedTitle,"Title Validation Failed!");
        System.out.println("User Able to Login Successfully - Title Validated");
    }

    @AfterMethod
    public void tearDown() {driver.quit();}

    @DataProvider(name = "TestAutomation")
    public Object[][] passData() {
        Object[][] data = new Object[3][2];
        data[0][0] = "student";
        data[0][1] = "Password123";
        data[1][0] = "student";
        data[1][1] = "student";
        data[2][0] = "student";
        data[2][1] = "Password123";
        return data;
    }
}