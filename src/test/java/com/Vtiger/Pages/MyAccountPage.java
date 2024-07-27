package com.Vtiger.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class MyAccountPage extends HeaderPage {
	
	public MyAccountPage(WebDriver driver,ExtentTest logger)
	{
	super(driver,logger);
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='Customise']")
	WebElement cus_tab;
	
	@FindBy(xpath="//td[@id='cl2']")
	WebElement ld;
	
	@FindBy(xpath="//td[@id='cl4']")
	WebElement clndr;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement sv_btn;
	
	@FindBy(xpath="(//a[@class='otherTab'])[4]")
	WebElement cl;
	
	
	
	
	public void DragnDrop()
	{
		MyAccount();
		ClickElement(cus_tab, "Clicked on custome tab");
		DragnDrop(ld,"Calender tab is moved to account tab",clndr);
		ClickElement(sv_btn,"Clicked on save button");
		MyAccount();
	}
	
	public void VerifyDragnDrop(String nm)
	{
		String elm=cl.getText();
		Assert.assertEquals(elm, nm);
	}
	
			

}
