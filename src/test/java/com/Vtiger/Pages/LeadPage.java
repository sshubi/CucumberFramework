package com.Vtiger.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class LeadPage extends HeaderPage {

	public LeadPage(WebDriver driver,ExtentTest logger) {
		super(driver,logger);
		PageFactory.initElements(driver, this);//or we can write LoginPage.class i.e. class name

	}
	
	@FindBy(name="lastname")
	WebElement tb_lname;
	
	@FindBy(xpath="//input[@name='company']")
	WebElement td_cname;
	
	@FindBy(xpath="//input[@name='button']")
	WebElement btn_save;
	
	@FindBy(xpath="//td[text()='Last Name:']")
	WebElement txt_lstname;
	
	@FindBy(xpath="//input[@name='Edit']")
	WebElement edt;
	
	
	@FindBy(xpath="(//input[@name='lastname'])[2]")
	WebElement srch_lname;
	
	@FindBy(xpath="(//input[@name='button'])[2]")
	WebElement srch_btn;
	
	@FindBy(xpath="//input[@name='selected_id']")
	WebElement chk_boxClick;
	
	
	@FindBy(xpath="(//input[@class='button'])[4]")
	WebElement dlt_lead;
	
	
	@FindBy(xpath="//td[contains(text(),'Showing 0 - 0 of 0')]")
	WebElement rslt;
	
	
	
	
	
	public void CreateLeadWithMandatoryFields(String lname,String comp)
	{
		SetInput(tb_lname,lname,lname+"has been entered in lastname field");
		SetInput(td_cname,comp,comp+"has been entered in company field");
		ClickElement(btn_save,"save button clicked");
		
	}
	
	
	
	public void CreateNEwLead(String lname,String comp)
	{
		SetInput(tb_lname,lname,lname+"has been entered in lastname field");
		SetInput(td_cname,comp,comp+"has been entered in company field");
		ClickElement(btn_save,"save button clicked");
		
	}
	
	public void VerifyNewLead(String val)
	{
		TextExist(txt_lstname,"userid1"," ");
	}
	
	public void EditLead(String lname,String comp)
	{
		ClickElement(edt,"clicked on edit lead");
		SetInput(tb_lname,lname,lname+"has been re-entered in lastname field");
		SetInput(td_cname,comp,comp+"has been re-entered in company field");
		ClickElement(btn_save,"save button clicked");
	}
	
	public void VerifyModifiedLead()
	{
		TextExist(txt_lstname,"lastname"," ");
	}
	
	
	public void DeletedLead(String lsame)
	{
		ClickLeads();
		SetInput(srch_lname,lsame,lsame+"has been searched in lastname field");
		ClickElement(srch_btn,"search button clicked");
		ClickElement(chk_boxClick,"Checkbox is ticked");
		ClickElement(dlt_lead,"delete button clicked");
	}
	
	public void VerifyDeletedLead()
	{
		ElementExist(rslt,"result is diplayed");
	}

}
