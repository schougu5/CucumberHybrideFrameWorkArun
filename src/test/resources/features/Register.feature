Feature:  Registration Functionality

Scenario: User creates an account with mandetory fields ONLY

Given User navigates to Register Account Page
When User enters below field

|firstname 				| Snehal |
|lastname 				| Chougule |
|telephone 				| 8983610108 |
|password 				| NewJob@1008 |

And User selects privacy policy checkbox
And User clicks on Continue button
Then User Account should get created successfully

@smokeTest
Scenario: User creates an account with all available fields

Given User navigates to Register Account Page
When User enters below field

|firstname 				| Snehal |
|lastname 				| Chougule |
|telephone 				| 8983610108 |
|password 				| NewJob@1008 |

And User selects Yes for NewsLetter
And User selects privacy policy checkbox
And User clicks on Continue button
Then User Account should get created successfully



Scenario: User creates an account with duplicateID

Given User navigates to Register Account Page
When User enters below field with duplicate emailID

|firstname 				| Snehal |
|lastname 				| Chougule |
|emailID 					| snehal.chougule.samco782@gmail.com |
|telephone 				| 8983610108 |
|password 				| NewJob@1008 |

And User selects Yes for NewsLetter
And User selects privacy policy checkbox
And User clicks on Continue button
Then User should get an error about DuplicateID is not allowed

@smokeTest
Scenario: User creates an account without entering any details

Given User navigates to Register Account Page
When User does NOT enter any field
And User clicks on Continue button
Then User should get an error about saying no input is given.
