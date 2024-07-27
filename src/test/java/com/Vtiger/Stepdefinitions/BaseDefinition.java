package com.Vtiger.Stepdefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.json.Json;

import com.Vtiger.Pages.HomePage;
import com.Vtiger.Pages.InvoicePage;
import com.Vtiger.Pages.LeadPage;
import com.Vtiger.Pages.LoginPage;
import com.Vtiger.Pages.PageObjectManager;
import com.Vtiger.Pages.ProductPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import io.cucumber.core.internal.com.fasterxml.jackson.core.exc.StreamReadException;
import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.DatabindException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class BaseDefinition  {
	
	public static WebDriver driver;
	
	public static Properties prop;
	public static Map<String,Map<String,String>> dt;
	public static String TCName;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	public PageObjectManager pm;
	
	public void ReadProperties() throws IOException, FilloException
	{
		
		
		//ReadExcel();
		ReadJson();
		
		//System.out.println(dt);
		//System.exit(0);
		prop= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		prop.load(fis);
	}
	
	public void LaunchApp() throws IOException, FilloException
	{
		ReadProperties();
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		driver.get(prop.getProperty("AppUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void ReadExcel() throws FilloException
	{
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(System.getProperty("user.dir")+"/src/test/resources/Data/testdata.xlsx.xls");
		String strQuery="Select * from Sheet1";
		Recordset recordset=connection.executeQuery(strQuery);
		
		dt= new HashMap<String,Map<String,String>>();
		List<String> colm=recordset.getFieldNames(); 
		 
		while(recordset.next()){
		//System.out.println(recordset.getField("Details"));
			Map<String,String> row= new HashMap<String,String>();
			for(int i=0; i<colm.size();i++)
			{
				row.put(colm.get(i), recordset.getField(colm.get(i)));
			}
			dt.put(recordset.getField(colm.get(0)), row);
		}
		 
		recordset.close();
		connection.close();
	}
	
	public void ReadJson() throws StreamReadException, DatabindException, IOException
	{
		 ObjectMapper mapper = new ObjectMapper();
	        
	        
	            // Read JSON file into Map<String, Map<String, String>>
	            File file = new File(System.getProperty("user.dir")+"/src/test/resources/Data/testdata.json");
	             dt = mapper.readValue(file, new TypeReference<Map<String, Map<String, String>>>(){});
	            

	        } 
	public void CreateExtentReport()
	{
		Date d= new Date();
		SimpleDateFormat ft= new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName= ft.format(d);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/src/test/java/com/Vtiger/reports/ExtentReport"+fileName+".html");
		
		//create an object of extent reports
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "ATH");
		extent.setSystemInfo("Enviornment", "Test");
		extent.setSystemInfo("User Name", "Shubham T");
		
		htmlReporter.config().setDocumentTitle("vTiger Regression Report");
		
		htmlReporter.config().setReportName("Name of the report comes here");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
	}
	}


