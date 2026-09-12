Feature:Automation Excersie  Login User with correct email and password

Scenario:checking login User Functionlities 

Given User Should Launch Chrome browser
When User Should Navigate to url 'http://automationexercise.com'
When User Should Verify that home page is visible successfully

Then User Should Click on 'Signup / Login' button
Then User Should Verify 'Login to your account' is visible
Then User Should Enter correct email address and password
Then User Should Click 'login' button
Then User Should Verify that 'Logged in as username' is visible