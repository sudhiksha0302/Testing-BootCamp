Feature:Automation Login User with incorrect email and password

Scenario:checking login User Functionlities 

Given User Should Launch Chrome browser
When User Should Navigate to url 'http://automationexercise.com'
When User Should Verify that home page is visible successfully

Then User Should Verify that home page is visible successfully
Then User Should Click on 'Signup / Login' button
Then User Should  Verify 'Login to your account' is visible
Then User Should  Enter incorrect email address and password
Then User Should  Click 'login' button
Then User Should  Verify error 'Your email or password is incorrect!' is visible
