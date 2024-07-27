package com.Vtiger.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class ProductPage extends HeaderPage {
	
	public  ProductPage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='productname']")
	WebElement product_name;
	
	@FindBy(xpath="(//input[@name='Button'])[1]")
	WebElement change_contact;
	
	@FindBy(xpath="(//input[@name='Button'])[2]")
	WebElement change_Vendor ;
	
	@FindBy(xpath="//a[text()='Mary Smith']")
	WebElement Name_Mary;
	
	@FindBy(xpath="//a[text()='Linda']")
	WebElement Name_Linda;
	
	@FindBy(xpath="//select[@name='parent_type']")
	WebElement prnt_type;
	
	@FindBy(xpath="(//input[@name='button'])[3]")
	WebElement change_prntType;
	
	@FindBy(xpath="(//a[contains(text(),'vtiger')])[1]")
	WebElement Name_vtiger;
	

	@FindBy(xpath="//input[@name='imagename']")
	WebElement img_name;
	
	@FindBy(xpath="(//input[@name='button'])[1]")
	WebElement sv_button;
	
	@FindBy(xpath="(//input[@name='productname'])[2]")
	WebElement srch_product;
	
	@FindBy(xpath="(//input[@type='submit'])[2]")
	WebElement srch_button;
	
	public void input(String pname) 
	{
		NewProdcuct();
		SetInput(product_name, pname,pname+ "has been entered in product name");
		ClickElement(change_contact, "clicked on contact change button");
		PopUpWindow(change_contact, " ", Name_Mary);
		ClickElement(change_Vendor, "clicked on vondor's change button");
		PopUpWindow(change_Vendor," ",Name_Linda);
		DropDown(prnt_type,"click on dropdown button to select Accounts option");
		ClickElement(change_prntType, "clicked on parent_Type change button");
		PopUpWindow(change_prntType," ",Name_vtiger );
		ChooseFile(img_name,"click on choose file and uploading file");
		ClickElement(sv_button, "clicked on save button");
	}
	
	public void VerifyProduct(String sname)
	{
		Product();
		SetInput(srch_product, sname,sname+ "has been entered in product name searchbox	");
		ClickElement(srch_button, "clicked on Search button");
	}
	

}
