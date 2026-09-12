package ListBoxItems;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ElfSight {

    @Test
    public void countItems() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://elfsight.com/online-form-builder/templates/html-employee-registration-form/");

        WebElement dropdown = driver.findElement(By.tagName("select"));

        Select list = new Select(dropdown);

        List<WebElement> options = list.getOptions();

        int total = options.size();

        System.out.println("Total items in dropdown: " + total);

        Thread.sleep(3000);

        driver.quit();
    }
}
