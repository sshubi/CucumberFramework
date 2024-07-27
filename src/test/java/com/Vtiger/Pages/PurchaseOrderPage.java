package com.Vtiger.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.aventstack.extentreports.ExtentTest;

public class PurchaseOrderPage extends HeaderPage {
	
	public PurchaseOrderPage (WebDriver driver,ExtentTest logger)
	{
		super(driver, logger);
		PageFactory.initElements(driver, logger);
	}
	
	@FindBy (xpath="//img[@src='themes/blue/images/showsubmenu.gif']")
	WebElement sub;
	
	@FindBy (xpath="//a[text()='New Purchase Order']")
	WebElement Nwpr;
	
	@FindBy (xpath="//input[@name='subject']")
	WebElement subject_name;
	
	@FindBy (xpath="(//input[@title='Change'])[1]")
	WebElement change_btn;
	
	@FindBy (xpath="//a[text()='Linda']")
	WebElement vendor_name;
	
	@FindBy (xpath="//textarea[@name='bill_street']")
	WebElement billing_adrs;
	
	@FindBy (xpath="//textarea[@name='ship_street']")
	WebElement shipping_adrs;
	
	@FindBy (xpath="//img[@src='themes/blue/images/search.gif']")
	WebElement product_srch;
	
	@FindBy (xpath="//a[text()='Vtiger Single User Pack']")
	WebElement product_select;
	
	@FindBy (xpath="//input[@id='txtQty1']")
	WebElement quantity;
	
	@FindBy (xpath="//div[@id='grandTotal']")
	WebElement grnd_total;


	
	public void ShowSubMenu()
	{
		MoveToElement(sub, "MouseHover on submenu and click on new purchase order", Nwpr);
	}
	
	public void PurchaseOrderInfo(String input)
	{
		SetInput(subject_name, input, "subject name is filled");
		ClickElement(change_btn, "clicked on change button");
		PopUpWindow(change_btn, "Vendor name Linda is selcted", vendor_name);
	}
	
	public void AddressInfo(String input1, String input2)
	{
		SetInput(billing_adrs, input1, "Billing adress is filled");
		SetInput(shipping_adrs, input2, "Shipping adress is filled");
		
	}
	
	public void ProductDetails(String input3)
	{
		
		ClickElement(product_srch, "click on product sreach");
		PopUpWindow(product_srch, "product name Vtiger Single User Pack is selected", product_select);
		SetInput(quantity, input3, "quantity is filled");
	}
	
	public void VerifyGrandTotal(String act)
	{
	  TextExist(grnd_total, act, "Verified the grand total");
	 //Assert.assertEquals();
	}
}
