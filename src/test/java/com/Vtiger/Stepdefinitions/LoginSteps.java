package com.Vtiger.Stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Vtiger.Pages.HomePage;
import com.Vtiger.Pages.LeadPage;
import com.Vtiger.Pages.LoginPage;
import com.Vtiger.Pages.PageObjectManager;
import com.codoid.products.exception.FilloException;

public class LoginSteps extends BaseDefinition {
	@Before
	public void GetScenario(Scenario scen)
	{
		if(extent==null) {
		CreateExtentReport();
		}
		 TCName=scen.getName();
		logger= extent.createTest(TCName);
		
	}
	
	@After
	public void SaveReport()
	{
		extent.flush();
		driver.quit();
	}
	
	@Given("User should be on login page")
	public void user_should_be_on_login_page() throws IOException, FilloException {
		LaunchApp();
		pm= new PageObjectManager(driver, logger);

		 
	}
	@When("User enters valid credentials and click on login button")
	public void user_enters_valid_credentials_and_click_on_login_button() {
		
		
		pm.GetLoginPage().Login(dt.get(TCName).get("UserId"), dt.get(TCName).get("Password"));
		//pm.GetLoginPage().Login("admin", "admin");
	  
	}
	
	@Then("user should navigated to home page")
	public void user_should_navigated_to_home_page() {
		driver.findElement(By.linkText("Home")).isDisplayed();
	
	}
	@Then("user can validate the logout button")
	public void user_can_validate_the_logout_button() {

		pm.GetHomePage().VerifyLogout();
	}
	
	@When("User enters invalid credentials and click on login button")
	public void user_enters_invalid_credentials_and_click_on_login_button() {
	
		pm.GetLoginPage().Login(dt.get(TCName).get("UserId"), dt.get(TCName).get("Password"));
	    
	}
	
	@Then("User should be navigated to login page")
	public void user_should_be_navigated_to_login_page() {
		pm.GetLoginPage().CheckUsernameExist();
		
	   }
	@Then("user can validate the error message")
	public void user_can_validate_the_error_message() {

		pm.GetLoginPage().VeriyErrorMsg();
	}

	@When("User enters invalid userid as {string} and password as {string} click on login button")
	public void user_enters_invalid_userid_as_and_password_as_click_on_login_button(String uid, String pwd	) {
	
		pm.GetLoginPage().Login(uid, pwd);
	    
	}
	
	@Then("user should see  {string} and {string}")
	public void user_should_see_and(String string, String string2) 
	{
		pm.GetLoginPage().VerifyText("text");
		pm.GetLoginPage().VerifyText("Linktext");
	    
	}



}
