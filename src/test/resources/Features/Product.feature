Feature: Product_Adding_Functionality

Background:
Given User should be on login page
Given User Should be on product name page
@nwprdct
Scenario: vTiger_Verify_Add_NewProduct_TC07
When User fill all the required information and save the product
Then User should validate the product

