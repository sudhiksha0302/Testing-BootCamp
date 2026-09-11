package radioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class RadioButtonsDemo2 {

    EdgeDriver driver;

    @Test
    public void TestRadioBtn() throws Exception {

        driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement male= driver.findElement(By.id("male"));
        male.click();
        System.out.println("Male selected:"+male.isSelected());
        
        boolean status = driver.findElement(By.id("male")).isSelected();
        System.out.println(status);
        
        boolean displayed = driver.findElement(By.id("male")).isDisplayed();
        System.out.println(displayed);
        
        boolean enabled = driver.findElement(By.id("male")).isEnabled();
        System.out.println(enabled);
        
        
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
