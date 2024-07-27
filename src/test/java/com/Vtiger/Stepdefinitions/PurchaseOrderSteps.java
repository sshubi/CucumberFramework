package com.Vtiger.Stepdefinitions;

import com.Vtiger.Pages.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseOrderSteps extends BaseDefinition {
	
	@Given("User Should be on Purchase order page")
	public void user_should_be_on_purchase_order_page() 
	{
		pm= new PageObjectManager(driver, logger);
		pm.GetLoginPage().Login("admin","admin");
		pm.GetPurchaseOrderPage().ShowSubMenu();
	}
	
	@When("User fills up mandatory fiels of Purchase Order Information")
	public void user_fills_up_mandatory_fiels_of_purchase_order_information() 
	{
		pm.GetPurchaseOrderPage().PurchaseOrderInfo("PO #00123 – 2 Units of Model X Laptop ");
	    
	}
	
	@When("Address Information")
	public void address_information() 
	{
		pm.GetPurchaseOrderPage().AddressInfo("Company Name:\r\n"
				+ "ABC Ltd.\r\n"
				+ "\r\n"
				+ "Attn:\r\n"
				+ "Billing Office\r\n"
				+ "\r\n"
				+ "Address Line 1:\r\n"
				+ "789 Main Street\r\n"
				+ "\r\n"
				+ "City, State, ZIP Code:\r\n"
				+ "Hometown, TX 75001\r\n"
				+ "\r\n"
				+ "Country:\r\n"
				+ "USA\r\n"
				+ "\r\n"
				+ "Phone Number:\r\n"
				+ "(555) 987-6543\r\n"
				+ "\r\n"
				+ "Email Address:\r\n"
				+ "billing@abcltd.com", "Company Name:\r\n"
						+ "ABC Manufacturing Inc.\r\n"
						+ "\r\n"
						+ "Attn:\r\n"
						+ "Receiving Department\r\n"
						+ "\r\n"
						+ "Address Line 1:\r\n"
						+ "456 Industrial Park Road\r\n"
						+ "\r\n"
						+ "Address Line 2:\r\n"
						+ "Building B, Dock 3\r\n"
						+ "\r\n"
						+ "City, State, ZIP Code:\r\n"
						+ "Metropolis, CA 90210\r\n"
						+ "\r\n"
						+ "Country:\r\n"
						+ "USA\r\n"
						+ "\r\n"
						+ "Phone Number:\r\n"
						+ "(555) 654-3210\r\n"
						+ "\r\n"
						+ "Email Address:\r\n"
						+ "receiving@abcmfg.com");
	    
	}
	
	@When("Product Details")
	public void product_details() 
	{
		
	    pm.GetPurchaseOrderPage().ProductDetails("2");
	}
	
	@Then("validate the product details")
	public void validate_the_product_details() 
	{
		
		pm.GetPurchaseOrderPage().VerifyGrandTotal("297.00");

	}

}
