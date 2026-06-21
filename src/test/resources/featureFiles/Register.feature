Feature: Registration functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName|Runit          |
|lastName |Patil          |
|telephone|123456789      |    
|password |12345          |
And User selects Privacy Policy
And User clicks on Continue button
Then User account should get created successfully


Scenario: User creates an account with all fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName|Runit          |
|lastName |Patil          |
|telephone|123456789      |    
|password |12345          |
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User account should get created successfully


Scenario: User creates a duplicate accounts
Given User navigates to Register Account page
When User enters the details into below fields with duplicate email
|firstName|Runit          |
|lastName |Patil          |
|email    |runit@gmail.com|
|telephone|123456789      |    
|password |12345          |
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User should get a proper warning about duplicate email

Scenario: User creates an account without filling details
Given User navigates to Register Account page
When User do not enter any details into fields
And User clicks on Continue button
Then User should get a proper warning messages for every mandatory field