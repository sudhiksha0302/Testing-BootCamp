package radioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DemoRadioButtons {

    ChromeDriver driver;

    @Test
    public void TestRadioBtn() throws Exception {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        // Select Male radio button
        driver.findElement(By.xpath("//input[@id='male']")).click();

        Thread.sleep(3000);

        // Select Female radio button
        driver.findElement(By.xpath("//input[@id='female']")).click();

        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}