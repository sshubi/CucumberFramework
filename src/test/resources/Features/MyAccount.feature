Feature: Drag and drop funtionality 
Background:
Given User should be on login page
@myac
Scenario: vTiger_Drag_and_Drop_Selectedtabs_TC08
Given User should be on customize tab of my account 
When user perform drag and drop on selectd tabs
Then user should validate the changed position of the tabs 