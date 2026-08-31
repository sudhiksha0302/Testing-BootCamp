Feature: Automation Exercise

Scenario: Checking Subscription in Home Page

    Given User should Launch Chrome browser
    When User should Navigate to URL "http://automationexercise.com"
    Then User should Verify that Home Page is visible successfully
    When User Should Scroll down to footer
    Then User Should Verify that 'SUBSCRIPTION' text is visible
    When User Should Enter email address in input and click arrow button
    Then User Should Verify that 'You have been successfully subscribed!' message is visible