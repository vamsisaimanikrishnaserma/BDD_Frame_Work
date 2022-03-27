package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 

@CucumberOptions(
		monochrome = true,
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "features", glue = "stepDefinition") 
public class TestRunner {
	
}
