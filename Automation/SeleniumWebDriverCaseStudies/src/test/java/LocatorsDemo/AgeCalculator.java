package LocatorsDemo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AgeCalculator {

    WebDriver driver;

    String baseURL =
            "https://www.easycalculation.com/date-day/age-calculator.php";

    @BeforeTest
    public void setUp() throws Exception {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(baseURL);

        Thread.sleep(5000);
    }

    @Test
    public void calculateAge() throws Exception {

        /*
         * Enter your Date of Birth here.
         *
         * Example:
         * 15 June 2005
         *
         * Change this value to your actual DOB.
         */

        String dateOfBirth = "15/06/2005";

        /*
         * Current date is taken automatically from the system.
         */

        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String currentDateValue =
                currentDate.format(formatter);

        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Current Date: " + currentDateValue);

        /*
         * Parse the date to make sure it is valid.
         */

        try {

            LocalDate dob =
                    LocalDate.parse(dateOfBirth, formatter);

            System.out.println("Valid Date of Birth: " + dob);

        } catch (DateTimeParseException e) {

            System.out.println("Invalid Date of Birth.");
            return;
        }

        /*
         * Locate date fields.
         *
         * The website may change its HTML structure,
         * so these XPath locators are intentionally based
         * on the field's surrounding labels/attributes.
         */

        WebElement dayField = driver.findElement(
                By.xpath("(//input[contains(@name,'day') or contains(@id,'day')])[1]"));

        WebElement monthField = driver.findElement(
                By.xpath("(//input[contains(@name,'month') or contains(@id,'month')])[1]"));

        WebElement yearField = driver.findElement(
                By.xpath("(//input[contains(@name,'year') or contains(@id,'year')])[1]"));

        /*
         * Split Date of Birth.
         */

        String[] dobParts = dateOfBirth.split("/");

        String dobDay = dobParts[0];
        String dobMonth = dobParts[1];
        String dobYear = dobParts[2];

        /*
         * Enter Date of Birth.
         */

        dayField.clear();
        dayField.sendKeys(dobDay);

        monthField.clear();
        monthField.sendKeys(dobMonth);

        yearField.clear();
        yearField.sendKeys(dobYear);

        /*
         * Locate Current Date fields.
         */

        WebElement currentDayField = driver.findElement(
                By.xpath("(//input[contains(@name,'day') or contains(@id,'day')])[2]"));

        WebElement currentMonthField = driver.findElement(
                By.xpath("(//input[contains(@name,'month') or contains(@id,'month')])[2]"));

        WebElement currentYearField = driver.findElement(
                By.xpath("(//input[contains(@name,'year') or contains(@id,'year')])[2]"));

        /*
         * Split Current Date.
         */

        String currentDay =
                String.valueOf(currentDate.getDayOfMonth());

        String currentMonth =
                String.valueOf(currentDate.getMonthValue());

        String currentYear =
                String.valueOf(currentDate.getYear());

        /*
         * Enter Current Date.
         */

        currentDayField.clear();
        currentDayField.sendKeys(currentDay);

        currentMonthField.clear();
        currentMonthField.sendKeys(currentMonth);

        currentYearField.clear();
        currentYearField.sendKeys(currentYear);

        /*
         * Click Calculate button.
         */

        WebElement calculateButton = driver.findElement(
                By.xpath("//input[@type='submit' or @value='Calculate']"));

        calculateButton.click();

        Thread.sleep(3000);

        /*
         * Print results.
         */

        try {

            WebElement age = driver.findElement(
                    By.xpath("//*[contains(text(),'Your Age Is')]/following::*[1]"));

            WebElement ageDays = driver.findElement(
                    By.xpath("//*[contains(text(),'Your Age In Days')]/following::*[1]"));

            WebElement ageHours = driver.findElement(
                    By.xpath("//*[contains(text(),'Your Age in Hours')]/following::*[1]"));

            WebElement ageMinutes = driver.findElement(
                    By.xpath("//*[contains(text(),'Your Age in Minutes')]/following::*[1]"));

            System.out.println("--------------------------------------");
            System.out.println("Age Calculator Results");
            System.out.println("--------------------------------------");

            System.out.println("Your Age Is       : " + age.getText());
            System.out.println("Your Age In Days  : " + ageDays.getText());
            System.out.println("Your Age in Hours : " + ageHours.getText());
            System.out.println("Your Age in Minutes: " + ageMinutes.getText());

            System.out.println("--------------------------------------");

        } catch (Exception e) {

            System.out.println(
                    "Unable to locate result fields. Please inspect the current HTML of the calculator.");
        }
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
    }
}
