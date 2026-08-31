Feature: Automation Exercise Register User with Existing Email

Scenario: Checking Register User with Existing Email Functionality

Given User Should Launch Chrome browser
When User Should Navigate to url 'http://automationexercise.com'
Then User Should Verify that home page is visible successfully
Then User Should Click on 'Signup / Login' button
Then User Should Verify 'New User Signup!' is visible
Then User Should Enter name and already registered email address
Then User Should Click 'Signup' button
Then User Should Verify error 'Email Address already exist!' is visible