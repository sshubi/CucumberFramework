Feature: Mousehover_Pop_upWindow & drop_Down functionality 

Background:
Given User should be on login page
Given Usere should be on invoice page

Scenario: vTiger_verify_Mouseover_menu_options_TC04

Then User should validate Invoice text
@mouse
Scenario Outline: vTiger_verify_Invoice_Pop_window_TC05



When User click on Change button and will navigated to popup window
Then User will retrive "<attribute>" attribute 
Then The attribute value should be "<value>"
Examples:
|attribute|value|
|value|vtiger|

@invoice
Scenario Outline: vTiger_verify_NewInvoice_status_Dropdown_TC06
Then User will verify status dropdown
And default selection should be "<Default_value>"
And there should be five values in dropdown as "Options"
Examples:
|Default_value|Options|
|Created|Created,Approved,Sent,Credit Invoice,Paid|
