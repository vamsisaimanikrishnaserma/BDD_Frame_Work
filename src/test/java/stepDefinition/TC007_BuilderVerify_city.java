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

public class TC007_BuilderVerify_city extends BaseClass {

	private Scenario scenario;

	@Before()
	public void embedScreenshotStep(Scenario scenario) {
		this.scenario = scenario;
	}

	@And("clicked on newBuilder properties")
	public void clickonBuilder() throws IOException {
		log.createLogger(getClass());
		exReport.createNewTestReport("clicked on newBuilder properties");
		log.info("clicked on newBuilder properties started");
		AllLogger.passLog("clicking new Builder");
		home.clickOnBuilder();

	}

	@Then("selcting city {string}")
	public void selectCity(String city) throws IOException, InterruptedException {
		home.selectBuilderProjects(city);
	}

	@And("it should show correct city as {string} builder Project")
	public void verifyCorrectCity(String city) throws IOException {

		String result = builderPage.getHeadingOfResults();

		if (result.contains(city)) {
			exReport.enterPassLogWithSnap("New Projects are displaying according to cites");
			scenario.log("New Projects are displaying according to cites");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			log.info("New Projects are displaying according to cites");
		} else {
			exReport.enterPassLogWithSnap("New Projects are not displaying according to cites");
			scenario.log("New Projects are not displaying according to cites");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			log.info("New Projects are not displaying according to cites");
			Assert.assertTrue(false);
		}
	}

}
