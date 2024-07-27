package com.Vtiger.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		
		
		features= "src/test/resources",
		glue= "com.Vtiger.Stepdefinitions",
		dryRun=false,
		plugin= {"pretty","html:target/cucumber-html-report.html","json:target/cucumber.json"}
		,tags="@invalid"
		
		
		
		)

public class TestRunner {

}

