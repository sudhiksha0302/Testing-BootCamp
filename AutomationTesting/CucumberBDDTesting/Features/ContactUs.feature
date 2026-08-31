Feature: Automation Exercise

Scenario: Checking Contact Us Form

    Given User should Launch Chrome browser
    When User should Navigate to URL "http://automationexercise.com"
    Then User should Verify that Home Page is visible successfully
    When User Should Click on 'Contact Us' button
    Then User Should Verify that 'GET IN TOUCH' is visible
    When User Should Enter name, email, subject and message
    And User Should Upload file
    And User Should Click 'Submit' button
    And User Should Click OK button
    Then User Should Verify that 'Success! Your details have been submitted successfully.' is visible
    When User Should Click 'Home' button
    Then User Should Verify that user is landed on Home Page successfully