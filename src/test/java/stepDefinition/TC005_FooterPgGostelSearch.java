package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import utility.BaseClass;

public class TC005_FooterPgGostelSearch extends BaseClass {
	
	private Scenario scenario;

    @Before()
    public void embedScreenshotStep(Scenario scenario) {
    	this.scenario = scenario;
    }
    
    @And("click on pghostels in footer")
	public void selectCommertail() throws IOException{
		log.createLogger(getClass());
		exReport.createNewTestReport("Footer Pg hostels");
		log.info("Footer Pg hostels");
		home.clickFooterPgHostel();;
		
	}

    @Then("Verify it contains {string}")
	public void verifyLogin(String city) throws IOException{
		
		if (home.searchFooterPgHostels(city)) {
			exReport.enterPassLogWithSnap("City present in PGHostel footer");
			scenario.log("City present in PGHostel footer");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			log.info("City present in PGHostel footer");

		} else {
			exReport.enterPassLogWithSnap("City not present in PGHostel footer");
			scenario.log("City not present in PGHostel footer");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			log.info("City not present in PGHostel footer");
			Assert.assertTrue(false);
		}
	}
  
}
