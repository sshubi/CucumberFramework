package com.Vtiger.Stepdefinitions;

import com.Vtiger.Pages.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccountSteps extends BaseDefinition {
	
	@Given("User should be on customize tab of my account")
	public void user_should_be_on_customize_tab_of_my_account() 
	{
		pm= new PageObjectManager(driver, logger);
		pm.GetLoginPage().Login("admin","admin");
	}
	
	@When("user perform drag and drop on selectd tabs")
	public void user_perform_drag_and_drop_on_selectd_tabs() 
	{
		pm.GetMyAccountPage().DragnDrop();
	}
	
	@Then("user should validate the changed position of the tabs")
	public void user_should_validate_the_changed_position_of_the_tabs() 
	{
	   pm.GetMyAccountPage().VerifyDragnDrop("Leads"); 
	}
	
	

}
