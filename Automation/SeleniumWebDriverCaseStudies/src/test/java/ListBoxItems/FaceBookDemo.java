package ListBoxItems;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.Helper;

public class FaceBookDemo {

    WebDriver driver = Helper.startBrowser("Chrome");

    @BeforeTest
    public void Setup() {
        driver.manage().window().maximize();
    }

    @Test
    public void DropDownLists() throws Exception {

        driver.navigate().to(
            "https://www.facebook.com/reg/?entry_point=login"
        );

        Thread.sleep(5000);

        List<WebElement> dropdowns =
                driver.findElements(By.tagName("select"));

        System.out.println("===== FACEBOOK =====");
        System.out.println("Number of Drop Downs: " + dropdowns.size());

        for (WebElement dropdown : dropdowns) {

            Select list = new Select(dropdown);

            List<WebElement> options = list.getOptions();

            System.out.println("Items Count: " + options.size());

            for (WebElement ele : options) {
                System.out.println("Item: " + ele.getText());
            }
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}