package com.Vtiger.Stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.beust.jcommander.internal.Maps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeadsSteps extends BaseDefinition {
	//WebDriver driver;
		
	@When("once user create the lead")
	public void once_user_create_the_lead(io.cucumber.datatable.DataTable dataTable) {
	List<Map<String, String>> ls=	dataTable.asMaps();
	for(Map<String, String> m: ls)
	{
		pm.GetLeadPage().NewLeads();
		pm.GetLeadPage().CreateLeadWithMandatoryFields(m.get("lastname"), m.get("company"));
		
	}
	    
	}
	@Then("Lead should be created successfully")
	public void lead_should_be_created_successfully() {
	    
	}
	@Then("User click on logout")
	public void user_click_on_logout() {
		pm.GetLeadPage().ClickLogout();
	}
	
	

	@When("User create the New lead")
	public void user_create_the_new_lead(io.cucumber.datatable.DataTable dataTable) 
	{
		List<Map<String, String>> js=	dataTable.asMaps();
		for(Map<String, String> n: js)
		{
			pm.GetLeadPage().NewLeads();
			pm.GetLeadPage().CreateNEwLead(n.get("lastname"), n.get("company"));
		}
		
		
		
	    
	}
	
	@Then("User should verify saved lead")
	public void user_should_verify_saved_lead() 
	{
		pm.GetLeadPage().VerifyNewLead("userid1");
	    
	}
	
	@When("User edits the lead and pass modified data and save the lead")
	public void user_edits_the_lead_and_pass_modified_data_and_save_the_lead() 
	{
		
		pm.GetLeadPage().EditLead("lastname","company");
		
	   
	}
	
	@Then("user should verify modified lead")
	public void user_should_verify_modified_lead() 
	{
		
		pm.GetLeadPage().VerifyModifiedLead();
	    
	}
	
	@Then("user searh the modified lead and delete that lead")
	public void user_searh_the_modified_lead_and_delete_that_lead() 
	{
		pm.GetLeadPage().DeletedLead("lastname");
	   
	}
	
	@Then("verify the deleted lead")
	public void verify_the_deleted_lead() 
	{
		pm.GetLeadPage().VerifyDeletedLead();
		
		
	    
	}
	
	@When("once user create the lead with mandatory fields")
	public void once_user_create_the_lead_with_mandatory_fields() {
		pm.GetLeadPage().NewLeads();
		pm.GetLeadPage().CreateNEwLead(dt.get(TCName).get("LastName"), dt.get(TCName).get("Company"));
	}






}
