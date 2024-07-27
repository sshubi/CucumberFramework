package com.Vtiger.Pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class PageObjectManager {
	
	
	public  LoginPage lp;
	public  HomePage hp;
	public  LeadPage ldp;
	public  InvoicePage inp;
	public  ProductPage pp;
	public  MyAccountPage map;
	public PurchaseOrderPage pop;
	
	public WebDriver driver;
	public ExtentTest logger;
	
	public PageObjectManager(WebDriver driver,ExtentTest logger)
	{
		this.driver= driver;
		this.logger= logger;
	}
	
	public LoginPage GetLoginPage()
	{
		if(lp==null)
		{
			lp= new LoginPage(driver,logger);
			return lp;
		}else 
		{
			return lp;
		}
		
	}
		
		public HomePage GetHomePage()
		{
			if(hp==null)
			{
				hp= new HomePage(driver,logger);
				return hp;
			}else 
			{
				return hp;
			}
		}
		
		public LeadPage GetLeadPage()
		{
			if(ldp==null)
			{
				ldp= new LeadPage(driver,logger);
				return ldp;
			}else 
			{
				return ldp;
			}
		}
		
		public InvoicePage GetInvoicePage()
		{
			if(inp==null)
			{
				inp= new InvoicePage(driver,logger);
				return inp;
			}else 
			{
				return inp;
			}
		}
		
		public ProductPage GetProcuctPage()
		{
			if(pp==null)
			{
				pp= new ProductPage(driver,logger);
				return pp;
			}else 
			{
				return pp;
			}
		}
		
		public MyAccountPage GetMyAccountPage()
		{
			if(map==null)
			{
				map= new MyAccountPage(driver,logger);
				return map;
			}else 
			{
				return map;
			}
		}
		
		public PurchaseOrderPage GetPurchaseOrderPage()
		{
			if(pop==null)
			{
				pop= new PurchaseOrderPage (driver,logger);
				return pop;
			}else
			{
				return pop;
			}
		}
	

}
