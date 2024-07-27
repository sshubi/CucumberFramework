package com.Vtiger.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Vtiger.Utilities.PageActions;
import com.aventstack.extentreports.ExtentTest;

public class LoginPage extends PageActions {
	
	
	
;	public LoginPage(WebDriver driver,ExtentTest logger)
	{
		super (driver,logger);
		this.driver= driver;
		
		PageFactory.initElements(driver, this);//or we can write LoginPage.class i.e. class name
		
	}
	@FindBy(name="user_name")
	WebElement uid;
	
	@FindBy(xpath="//input[@name='user_password']")
	WebElement pass;
	
	@FindBy(xpath="//input[@name='Login']")
	WebElement login;
	
	@FindBy(xpath="//img[@src='include/images/vtiger-crm.gif']")
	WebElement logo;
	
	@FindBy(xpath="//*[contains(text(),'You must specify a valid username and password.')]")
	WebElement err_msg;
	
	@FindBy(xpath="//font[text()='Key Modules']")
	WebElement txt;
	
	@FindBy(xpath="//a[text()='vtiger Customer Portal']")
	WebElement lnk_txt;
	
	
	/*
	private String uid= "user_name";
	private String pass= "user_password";
	*/
	
	/*
	By uid= By.name("user_name");
	By pass= By.name("user_password");
	*/
	
	
	
	public void Login(String userid, String pwd)
	{
		SetInput(uid,userid,userid+" has been entered in userid field");
		SetInput(pass,pwd,pwd+" has been entered in password field");
		ClickElement(login,"Login button clicked");
		
	
	}
	
	public void CheckUsernameExist()
	{
		ElementExist(uid,"Testbox userid is displayed on loginpage");
	}
		
	public void VeriyLogo()
	{
		ElementExist(logo,"Logo is displayed on login page");
	}
	
	public void VeriyErrorMsg()
	{
		ElementExist(err_msg,"Error message validated successfully");
	}
	
	public void InvalidLogin(String userid, String pwd)
	{
		SetInput(uid,userid,userid+" has been entered in userid field");
		SetInput(pass,pwd,pwd+" has been entered in password field");
		ClickElement(login,"Login button clicked");
		
	}
	
	public void VerifyText(String exp)
	{
		TextExist(txt,exp,"");
		TextExist(lnk_txt,exp,"");
	
	}

	 

}
