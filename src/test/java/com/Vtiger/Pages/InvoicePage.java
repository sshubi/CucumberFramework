package com.Vtiger.Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Vtiger.Utilities.PageActions;
import com.aventstack.extentreports.ExtentTest;

public class InvoicePage extends PageActions {

	public InvoicePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//select[@name='invoicestatus']")
	WebElement sts_them;
	
	@FindBy(xpath="//a[@id='showSubMenu']")
	WebElement mnu;
	
	@FindBy(xpath="//a[text()='New Invoice']")
	WebElement nw_invoce;
	
	@FindBy(xpath="//td[contains(text(),'Invoice:')]")
	WebElement invoice;
	
	@FindBy(xpath="//input[@name='btn1']")
	WebElement chng;
	
	@FindBy(xpath="//a[text()='vtiger']")
	WebElement vtgr;
	
	@FindBy(xpath="//input[@name='account_name']")
	WebElement ac_name;
	
	
	
	public void CheckStatusDropdown()
	{
		ElementExist(sts_them, null);
	}
	
	public void MouseHover()
	{
		MoveToElement(mnu," ",nw_invoce);
			
	}
	
	public void VerifyInvoice(String txt)
	{
		TextExist(invoice, "Invoice text is displayed on invoice page ",txt);
		
	}
	
	public void ChildSwitch()
	{
		ClickElement(chng,"");
		PopUpWindow(chng," ",vtgr);
		
	}
	
	public void VerifyElm(String act)
	{
		String exp=Attribute(ac_name,"value","");
		String v1="value";
		assertEquals(exp, v1);
	}


}
