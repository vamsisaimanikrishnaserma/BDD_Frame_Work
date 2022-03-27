package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import utility.BaseClass;

public class TC002_Login_invalid_data extends BaseClass {
	private Scenario scenario;

    @Before()
    public void embedScreenshotStep(Scenario scenario) {
    	this.scenario = scenario;
    }
	
	@Then("it must not log into account")
	public void verifyLogin() throws IOException{
		log.createLogger(getClass());
		boolean result = home.verifyLogin();
		 byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
         scenario.attach(screenshot, "image/png", "Loginscreenshot");  //(screenshot, "image/png");
		if(result==false) {
			exReport.enterPassLogWithSnap("Does not login with invalid credit");
			log.info("Does not login with invalid credit");
			scenario.log("Does not login with invalid credit");
			Assert.assertTrue(true);
		}
		else {
			exReport.enterFailLogWithSnap("logged in with invalid credit");
			log.info("logged in with invalid credit");
			scenario.log("logged in with invalid credit");
			Assert.assertTrue(false);
			
		}
		
	}

}
