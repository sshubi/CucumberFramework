package com.Vtiger.Stepdefinitions;

import java.io.IOException;

import com.Vtiger.Pages.PageObjectManager;
import com.Vtiger.Pages.ProductPage;
import com.codoid.products.exception.FilloException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps extends BaseDefinition {
	
	
	@Given("User Should be on product name page")
	public void user_should_be_on_product_name_page() throws IOException, FilloException
	{
		//LaunchApp();
		pm= new PageObjectManager(driver, logger);
		pm.GetLoginPage().Login("admin","admin");
		
		
		
		
	    
	}
	
	@When("User fill all the required information and save the product")
	public void user_fill_all_the_required_information_and_save_the_product()  
	{
		pm.GetProcuctPage().input("camera");
	    
	}
	
	@Then("User should validate the product")
	public void user_should_validate_the_product() 
	{
		
	   
	}

}
