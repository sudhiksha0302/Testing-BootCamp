package ListBoxItems;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Dropdown {

    ChromeDriver driver;

    String url = "https://testautomationpractice.blogspot.com/";

    @BeforeTest
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to(url);
    }

    @Test
    public void ChromeBrowserTest() throws Exception {

        // Locate the Country dropdown
        WebElement Country_Dropdown = driver.findElement(By.id("country"));

        // Create Select object
        Select Country_list = new Select(Country_Dropdown);

        // Select country using index
        Country_list.selectByIndex(3);

        Thread.sleep(10000);

        // Select country using visible text
        Country_list.selectByVisibleText("India");

        // Get the first selected option
        WebElement option = Country_list.getFirstSelectedOption();

        String selectedCountry = option.getText();

        System.out.println("Selected Country: " + selectedCountry);

        // Get all options from dropdown
        List<WebElement> c_list = Country_list.getOptions();

        // Get total number of options
        int total_country = c_list.size();

        System.out.println("Total countries count in List: " + total_country);
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
    }
}