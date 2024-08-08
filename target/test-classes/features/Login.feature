Feature: Login Functionality


Scenario Outline: Login with valid credentials

Given User is navigated to Login Page
When User enters valid email address <username>
And User enters valid password as <password>
And User clicks on Login Button
Then User should get logged in successfully
Examples:

|username						|password|
|snehalc1@gmail.com	|12345|
|snehalc2@gmail.com	|12345|
|snehalc3@gmail.com	|12345|



Scenario: Login with InValid credentials

Given User is navigated to Login Page
When User enters Invalid email address 
And User enters Invalid password as "12345123456789"
And User clicks on Login Button
Then User should get error about invalid credentials


Scenario: Login with valid email and Invalid Password

Given User is navigated to Login Page
When User enters valid email address "snehal.chougule04@gmail.com" 
And User enters Invalid password as "123456789"
And User clicks on Login Button
Then User should get error about invalid credentials


Scenario: Login with Invalid email and valid Password

Given User is navigated to Login Page
When User enters Invalid email address
And User enters valid password as "12345"
And User clicks on Login Button
Then User should get error about invalid credentials


Scenario: Login without providing the credentials

Given User is navigated to Login Page
When User does not enter an email address
And User does not enter a password
And User clicks on Login Button
Then User should get error about invalid credentials
