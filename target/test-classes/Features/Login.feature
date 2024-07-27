@regression 
 Feature: Login Functionality
 
 Background:
 Given User should be on login page
  
 @Login1
 Scenario:  valid login
When User enters valid credentials and click on login button
Then user should navigated to home page
Then user can validate the logout button 
@invalid
Scenario: invalid login
//Given User should be on login page
When User enters invalid credentials and click on login button
Then User should be navigated to login page
Then user can validate the error message

@CR
Scenario Outline: invalid login with dataset
//Given User should be on login page
When User enters invalid userid as "<userid>" and password as "<password>" click on login button
Then User should be navigated to login page
Then user can validate the error message
Examples:
		|userid | password|
		|userid1| pass1|
		|userid2| pass2|
		|userid3| pass3|

@vrifytxt		
Scenario Outline: Validate_text_tc04
Then user should see  "<text>" and "<Linktext>"

Examples:
|text|Linktext|
|Key Modules|:: vtiger Customer Portal|

Scenario:  valid_login_TC01
When User enters valid credentials and click on login button
Then user should navigated to home page
Then user can validate the logout button 
@invalid
Scenario: invalid_login_TC02
//Given User should be on login page
When User enters invalid credentials and click on login button
Then User should be navigated to login page
Then user can validate the error message


