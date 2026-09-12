Feature: Automation Exercise

Scenario: Checking Search Product

    Given User should Launch Chrome browser
    When User should Navigate to URL "http://automationexercise.com"
    Then User should Verify that Home Page is visible successfully
    Then User Should Click on 'Products' button
    Then User Should Verify that user is navigated to 'ALL PRODUCTS' page successfully
    Then User Should Enter product name in search input and click search button
    Then User Should Verify that 'SEARCHED PRODUCTS' is visible
    Then User Should Verify that all the products related to search are visible