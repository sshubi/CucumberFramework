package com.Vtiger.Stepdefinitions;

import java.io.IOException;

import com.Vtiger.Pages.InvoicePage;
import com.Vtiger.Pages.PageObjectManager;
import com.codoid.products.exception.FilloException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvoiceSteps extends BaseDefinition {
	
	
	
	@Given("Usere should be on invoice page")
	public void usere_should_be_on_invoice_page() throws IOException, FilloException 
	{
		//LaunchApp();
		pm= new PageObjectManager(driver, logger);
		pm.GetLoginPage().Login("admin", "admin");
		

		pm.GetInvoicePage().MouseHover();
	    
	}
	
	@Then("User should validate Invoice text")
	public void user_should_validate_invoice_text() 
	{
		 
		pm.GetInvoicePage().VerifyInvoice("Invoice:");
	    
	}
	
	@When("User click on Change button and will navigated to popup window")
	public void user_click_on_change_button_and_will_navigated_to_popup_window() 
	{
		
		pm.GetInvoicePage().ChildSwitch();
	}
	
	@Then("User will retrive {string} attribute")
	public void user_will_retrive_attribute(String string) 
	{
	//	inv.VerifyElm(string);
	    
	}
	
	@Then("The attribute value should be {string}")
	public void the_attribute_value_should_be(String string) 
	{
		
		pm.GetInvoicePage().VerifyElm(string);
	}
	
	@Then("User will verify status dropdown")
	public void user_will_verify_status_dropdown() 
	{
		//inv.VerifyElm();
	    
	}
	
	@Then("default selection should be {string}")
	public void default_selection_should_be(String string) {
	   
	}
	@Then("there should be five values in dropdown as {string}")
	public void there_should_be_five_values_in_dropdown_as(String string) {
	   
	}


}
