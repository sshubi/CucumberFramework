package com.Vtiger.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.Utilities.PageActions;
import com.aventstack.extentreports.ExtentTest;

public class HeaderPage extends PageActions{
	
	
	public HeaderPage(WebDriver driver,ExtentTest logger) {
		super(driver,logger);
		PageFactory.initElements(driver, this);//or we can write LoginPage.class i.e. class name
	}
	
	@FindBy(linkText="Home")
	WebElement lnk_Home; 
	
	@FindBy(linkText="Logout")
	WebElement lnk_Logout; 
	
	@FindBy(linkText="Leads")
	WebElement lnk_Leads;
	
	@FindBy(linkText="New Lead")
	WebElement lnk_NewLeads; 
	
	@FindBy(xpath="//a[text()='New Product']")
	WebElement lnk_NewProduct; 
	
	@FindBy(xpath="(//a[text()='Products'])[1]")
	WebElement lnk_Product; 
	
	@FindBy(xpath="//a[text()='My Account']")
	WebElement Myac; 
	
	
	public void VerifyHome()
	{
		ElementExist(lnk_Home,"Home menu is displayed on home page");
	}
	
	
	public void VerifyLogout()
	{
		ElementExist(lnk_Logout,"Logout link displayed on homepage");
	}
	
	public void ClickLogout()
	{
		ClickElement(lnk_Logout,"logout link clicked");	
	}
	
	public void ClickLeads()
	{
		ClickElement(lnk_Leads,"leads menu clicked");	
	}
	
	public void NewLeads()
	{
		ClickElement(lnk_NewLeads,"New lead menu clicked");	
	}
	
	public void NewProdcuct()
	{
		ClickElement(lnk_NewProduct,"New product menu clicked");	
	}
	
	public void Product()
	{
		ClickElement(lnk_Product,"New product menu clicked");	
	}
	
	public void MyAccount()
	{
		ClickElement(Myac,"My Account button is clicked");	
	}
	
	

}
