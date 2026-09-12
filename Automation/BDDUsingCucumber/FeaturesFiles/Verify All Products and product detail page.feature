Feature: Automation Exercise

Scenario: Checking All Products and Product Detail page

    Given User should Launch Chrome browser
    When User should Navigate to URL "http://automationexercise.com"
    Then User should Verify that Home Page is visible successfully
    When User Should Click on 'Products' button
    Then User Should Verify that user is navigated to 'ALL PRODUCTS' page successfully
    Then User Should Verify that the products list is visible
    When User Should Click on 'View Product' of first product
    Then User Should Verify that user is landed on product detail page
    And User Should Verify that product details are visible: product name, category, price, availability, condition and brand