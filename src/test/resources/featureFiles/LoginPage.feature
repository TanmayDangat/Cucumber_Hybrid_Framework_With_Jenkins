Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User has entered valid email address <validEmail> into email field
And User has entered valid password <validPassword> into password field
And User clicks on Login button
Then User should get successfully logged in

Examples:
|validEmail     |validPassword|
|runit@gmail.com|12345        |
|runit@gmail.com|12345        |
|runit@gmail.com|12345        |


Scenario Outline: Login with invalid credentials
Given User navigates to login page
When User has entered invalid email address into email field
And User has entered invalid password <invalidPassword> into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Examples:
|invalidPassword|
|1234567        |

Scenario Outline: Login with valid email and invalid password
Given User navigates to login page
When User has entered valid email address <validEmail> into email field
And User has entered invalid password <invalidPassword> into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Examples:
|validEmail     |invalidPassword|
|runit@gmail.com|1234567        |

Scenario Outline: Login with invalid email and valid password
Given User navigates to login page
When User has entered valid email address <invalidEmail> into email field
And User has entered invalid password <invalidPassword> into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Examples:
|invalidEmail        |validPassword|
|runittt@gmail.com   |12345          |

Scenario: Login without providing any credentials
Given User navigates to login page
And User do not enter email address into email field
And User do not enter password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch