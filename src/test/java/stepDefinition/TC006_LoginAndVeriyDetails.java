package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import reusable.AllLogger;
import utility.BaseClass;

public class TC006_LoginAndVeriyDetails extends BaseClass {
	
	private Scenario scenario;

    @Before()
    public void embedScreenshotStep(Scenario scenario) {
    	this.scenario = scenario;
    }
    
    @And("loggged in with phone number {string} and passord as {string}")
	public void login(String phoneNumber, String password) throws IOException{
		log.createLogger(getClass());
		exReport.createNewTestReport("Loggin and verify");
		log.info("Stared Login and verify");
		AllLogger.passLog("Clicking on login");
		home.clickOnLogin();
		AllLogger.infoLog("Entering details");
		home.enterloginDetails(phoneNumber, password);
		home.clickOnSignIn();
		AllLogger.passLog("Clicking on signIn");
		home.verifyLogin();
		
	}

    @Then("it shoul show name as {string} phoneNumber as {string} and email {string}")
	public void verifyLogin(String name, String phone,String email ) throws IOException{
		
		if (profile.verifyDeatils(name,email,phone)) {
			exReport.enterPassLogWithSnap("Login details matched");
			scenario.log("Login details matched");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			log.info("Login details matched");

		} else {
			exReport.enterPassLogWithSnap("Login details doesnot matched");
			scenario.log("Login details doesnot matched");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			log.info("Login details doesnot matched");
			Assert.assertTrue(false);
		}
	}
  

}
