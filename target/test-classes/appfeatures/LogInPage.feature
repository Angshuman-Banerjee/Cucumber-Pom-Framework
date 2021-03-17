Feature: Log in page feature

Scenario: Login Page Title
Given User is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: forgot password link
Given User is on login page
Then forgot password link should be displayed

Scenario: Login with correct credential
Given User is on login page
When user enters username "seeking.stock@gmail.com"
And user enters password "Dec$2013"
And user clicks on Sign in Button
Then user gets the title of the page
And page title should be "My account - My Store"


