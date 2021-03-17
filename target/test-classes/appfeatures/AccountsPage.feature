Feature: Account page feature

Background:
Given user has already logged in to application
|username               |password|
|seeking.stock@gmail.com|Dec$2013|

Scenario: Accounts page title
Given User is on Accounts page
When user gets the title of the page
Then page title should be "My account - My Store"

Scenario: Account section count
Given User is on Accounts page
Then User gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And Account section count should be 6