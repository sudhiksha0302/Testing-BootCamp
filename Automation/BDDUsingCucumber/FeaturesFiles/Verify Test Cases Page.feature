Feature: Automation Exercise

Scenario: Checking Test Cases page

    Given User should Launch Chrome browser
    When User should Navigate to URL "http://automationexercise.com"
    Then User should Verify that Home Page is visible successfully
    When User Should Click on 'Test Cases' button
    Then User Should Verify that user is navigated to Test Cases page successfully