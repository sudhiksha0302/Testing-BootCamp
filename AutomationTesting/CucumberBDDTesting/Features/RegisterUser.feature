Feature: Automation Exercise Register User

Scenario: Checking Register User Functionalities

Given User Should Launch Chrome browser

When User Should Navigate to url 'http://automationexercise.com'

When User Should Verify that home page is visible successfully

Then User Should Click on 'Signup / Login' button

Then User Should Verify 'New User Signup!' is visible

Then User Should Enter name and email address

Then User Should Click 'Signup' button

Then User Should Verify that 'ENTER ACCOUNT INFORMATION' is visible

Then User Should Fill details: Title, Name, Email, Password, Date of birth

Then User Should Select checkbox 'Sign up for our newsletter!'

Then User Should Select checkbox 'Receive special offers from our partners!'

Then User Should Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

Then User Should Click 'Create Account button'

Then User Should Verify that 'ACCOUNT CREATED!' is visible

Then User Should Click 'Continue' button

Then User Should Verify that 'Logged in as username' is visible

Then User Should Click 'Delete Account' button

Then User Should Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button