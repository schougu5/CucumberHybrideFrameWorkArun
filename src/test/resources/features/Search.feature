Feature: Search Functionality

Scenario: User searches for valid products

Given User opens the application
When User enters "HP" in search box
And User clicks on Search button
Then User should get valid product list


Scenario: User searches for InValid products

Given User opens the application
When User enters "Honda" in search box
And User clicks on Search button
Then User should get an error about no product matching



Scenario: User searches without any product

Given User opens the application
When User does NOT enter anything in search box
And User clicks on Search button
Then User should get an error about no product matching
