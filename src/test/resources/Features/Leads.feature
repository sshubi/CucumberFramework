@regression
Feature: Lead functionality
Background:
Given User should be on login page
When User enters valid credentials and click on login button

@single
Scenario: Create multiple leads
//Given User should be on login page
//When User enters valid credentials and click on login button
And once user create the lead
        |lastname| company|
		|userid1 | pass1 |
		|userid2 | pass2 |
		|userid3 | pass3 |
Then Lead should be created successfully
And User click on logout

@fullLead1
Scenario: Create_NewLead_Save_Edit_save_verify lead
//Given User should be on login page
//When User enters valid credentials and click on login button
And User create the New lead
        |lastname| company|
		|userid1 | pass1 |
				
Then User should verify saved lead
When User edits the lead and pass modified data and save the lead
Then user should verify modified lead
And  user searh the modified lead and delete that lead 
Then verify the deleted lead

@excel
Scenario: Create_leads_TC03
//Given User should be on login page
//When User enters valid credentials and click on login button
And once user create the lead with mandatory fields
Then Lead should be created successfully
And User click on logout
