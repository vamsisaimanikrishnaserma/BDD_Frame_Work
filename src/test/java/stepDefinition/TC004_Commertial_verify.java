package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import pageobject.SearchResultPage;
import uistore.SearchResultPageUi;
import utility.BaseClass;

public class TC004_Commertial_verify extends BaseClass{
	private Scenario scenario;

    @Before()
    public void embedScreenshotStep(Scenario scenario) {
    	this.scenario = scenario;
    }
    
    @And("selct Commertail option")
	public void selectCommertail() throws IOException{
		log.createLogger(getClass());
		exReport.createNewTestReport("Search for Commertial properties");
		log.info("Starting commertial search test");
		home.clickCommertial();
		
	}

    @Then("Search for {string}")
	public void saerchForString(String city) throws IOException{
		log.createLogger(getClass());
		home.searchCommertial(city);
	}
    @Then("verify no reuslt {string}")
   	public void verifyResult(String resultNo) throws IOException{
   		log.createLogger(getClass());
   		SearchResultPage searchResult = new SearchResultPage();
		webDriver.waitUntilVisibilityOfElement(SearchResultPageUi.totalResults);
		webDriver.waitElmentValueGraterThanZero(SearchResultPageUi.totalResults);
		log.info(" Number of Results "+ searchResult.resultCount());
		exReport.enterInfoLog(" Number of Results "+ searchResult.resultCount());
		if (searchResult.resultCount()==Integer.parseInt(resultNo)) {
			exReport.enterPassLogWithSnap("Number of results matched");
			scenario.log("Number of results matched");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			log.info("Number of results matched");

		} else {
			exReport.enterPassLogWithSnap("Number of results doesnt matched");
			scenario.log("Number of results doesnt matched");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			log.info("Number of results doesnt matched");
			Assert.assertTrue(false);
		}
   		
   	}


}
