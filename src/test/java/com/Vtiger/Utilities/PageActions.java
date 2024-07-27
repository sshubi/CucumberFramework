package com.Vtiger.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.text.DateFormat;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Vtiger.Stepdefinitions.BaseDefinition;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class PageActions {
	public WebDriver driver;
	public WebDriverWait wait;
	public  ExtentTest logger;
	public  PageActions(WebDriver driver,ExtentTest logger)
	{
		this.driver= driver;
		this.logger=logger;
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public String GetScreenShot()
	{
		Date d= new Date();
		DateFormat ft= new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName= ft.format(d);
		String path = System.getProperty("user.dir")+"/src/test/java/com/Vtiger/reports/ScreenShot"+fileName+".png";
		
		TakesScreenshot ts=  ((TakesScreenshot)driver);
		File SrcFile= ts.getScreenshotAs(OutputType.FILE);
		
		File DestFile =new File(path);
		
		try
		{
			FileUtils.copyFile(SrcFile,DestFile);
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return path;
	}
	
	
	public void SetInput(WebElement elm, String value, String msg)
	{
		
		try
		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.clear();
			elm.sendKeys(value);
			logger.pass(msg);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			logger.fail("unable to enter the text in textbox due to error "+e.getMessage()+"<a href='\"+GetScreenShot()+\"'><span class=\"label end-time\">ScreenShot</span></a>");
		}
	}
	
	public void ClickElement(WebElement elm,String msg)
	{
		
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(elm));
			elm.click();
			logger.pass(msg);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			//logger.fail("unable to enter the text in textbox due to error "+e.getMessage()+"<a href='\"+GetScreenShot()+\"'><span class=\"label end-time\">ScreenShot</span></a>");
		}
	}
	
	
	public void ElementExist(WebElement elm,String msg)
	{
		
		try
		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.isDisplayed();
			logger.pass(msg);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			logger.fail("unable to enter the text in textbox due to error "+e.getMessage()+"<a href='\"+GetScreenShot()+\"'><span class=\"label end-time\">ScreenShot</span></a>");
		}
	}
	
	public void TextExist(WebElement elm,String act,String msg)
	{
		
		try
		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			 act=elm.getText();
			 act.equals(act);
			 logger.pass(msg);
		
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String Attribute(WebElement elm,String attri,String msg)
	{
		
		try
		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.getAttribute(attri);
			logger.pass(msg);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return attri;
	}
	
	public void MoveToElement(WebElement elm,String msg,WebElement elm1)
	{
		
		try
		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			Actions act= new Actions(driver);
			act.moveToElement(elm);
			act.click(elm1).perform();
			logger.pass(msg);
			
		
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void PopUpWindow(WebElement elm,String msg,WebElement elm1)
	{
		
		try
		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			
			Set<String> st= driver.getWindowHandles();
			Iterator<String> itr=st.iterator();
			String pr= itr.next();
			String ch= itr.next();
			driver.switchTo().window(ch);
			ClickElement(elm1,"");
			driver.switchTo().window(pr);
			logger.pass(msg);
		
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void DropDown(WebElement elm,String msg)
	{
		
		try
		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			
			Select sc= new Select(elm);
		    sc.getOptions().get(1).click();    
			logger.pass(msg);
		
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void ChooseFile(WebElement elm,String msg)
	{
		
		try
		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			
			 

		        // Locate the file input element
		        WebElement fileInput = (elm); // Replace with your element locator strategy

		        // Specify the file path you want to upload
		        String filePath = "C:/Users/Shubham T/Downloads/vTiger.jpg"; // Replace with your file path

		        // Send the file path to the file input element
		        fileInput.sendKeys(filePath);

		        
			logger.pass(msg);
		
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void DragnDrop(WebElement elm,String msg,WebElement elm1)
	{
		
		try
		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			Actions act= new Actions(driver);
			act.dragAndDrop(elm, elm1).perform();
			
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
