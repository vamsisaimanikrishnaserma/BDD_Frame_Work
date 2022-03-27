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

public class TC008_AndoidApp_download extends BaseClass {
	private Scenario scenario;

	@Before()
	public void embedScreenshotStep(Scenario scenario) {
		this.scenario = scenario;
	}

	@And("clicked on download android app")
	public void clickonDownloadApp() throws IOException {
		log.createLogger(getClass());
		exReport.createNewTestReport("AndroidApp download test");
		log.info("Clicked on android app download");
		AllLogger.passLog("clicking android download");
		home.downloadAndroidApp();
		

	}
	@Then("it should open playstore")
	public void verifyApp() throws IOException, InterruptedException {
		
		if (home.verifyCorrectApp()) {
			exReport.enterPassLogWithSnap("It opened correct android app");
			scenario.log("It opened correct android app");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			log.info("It opened correct android app");
		} else {
			exReport.enterPassLogWithSnap("It Doesnt opened correct android app");
			scenario.log("It doesnot opened correct android app");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			log.info("It doesnor opened correct android app");
			Assert.assertTrue(false);
		}
	}
}
