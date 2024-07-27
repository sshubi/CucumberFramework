Feature: Purchase_order_Functionality

Background:
Given User should be on login page
Given User Should be on Purchase order page
@pcOrder
Scenario: vTiger_Verify_Add_NewProduct_TC09
When User fills up mandatory fiels of Purchase Order Information
And  Address Information
And Product Details
Then validate the product details
