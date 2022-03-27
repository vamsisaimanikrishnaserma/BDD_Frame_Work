package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;

import utility.BaseClass;

public class TC003_Fan_Page_verification extends BaseClass {
	private Scenario scenario;
	boolean flag = true;

	@Before()
	public void embedScreenshotStep(Scenario scenario) {
		this.scenario = scenario;
	}

	@And("verify facebook")
	public void verifyFacebook() throws IOException {
		log.createLogger(getClass());
		exReport.createNewTestReport("Verifying fan pages");
		log.info("Verifying fan pages");
		exReport.enterInfoLog("Verifying fan pages");
		if (home.checkFaceBook()) {
			webDriver.waitUntilCompletelyLoad();
			exReport.enterPassLogWithSnap("Opened Facebook");
			scenario.log("Facebook opened");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot"); // (screenshot, "image/png");
			log.info("Opened Facebook");
			
		} else {
			webDriver.waitUntilCompletelyLoad();
			exReport.enterFailLogWithSnap("Unable to open Facebook");
			log.info("Unable to open Facebook");
			scenario.log("Unable to open Facebook");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			flag = false;
			Assert.assertTrue(false);
		}
		webDriver.switchTab(0);
	}

	@And("verify twitter")
	public void verifyTwitter() throws IOException {
		log.createLogger(getClass());
		log.info("Verifying fan pages");
		exReport.enterInfoLog("Verifying fan pages");
		if (home.checkTwitter()) {
			webDriver.waitUntilCompletelyLoad();
			exReport.enterPassLogWithSnap("Opened Twitter");
			scenario.log("Opened Twitter");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			log.info("Opened Twitter");

		} else {
			webDriver.waitUntilCompletelyLoad();
			scenario.log("Unable to open Twitter");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			exReport.enterFailLogWithSnap("Unable to open Twitter");
			log.info("Unable to open Twitter");
			flag = false;
			Assert.assertTrue(false);
		}
		webDriver.switchTab(0);
	}

	@And("verify linkdin")
	public void verifyLinkdin() throws IOException {
		if (home.checkLinkdin()) {
			webDriver.waitUntilCompletelyLoad();
			scenario.log("Opened Linkdin");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			exReport.enterPassLogWithSnap("Opened Linkdin");
			log.info("Opened Linkdin");

		} else {
			webDriver.waitUntilCompletelyLoad();
			scenario.log("Unable to open Linkdin");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			exReport.enterFailLogWithSnap("Unable to open Linkdin");
			log.info("Unable to open Linkdin");
			flag = false;
			Assert.assertTrue(false);
		}
		webDriver.switchTab(0);
	}

	@And("verify youtube")
	public void verifyYoutube() throws IOException {
		if (home.checkYouTube()) {
			webDriver.waitUntilCompletelyLoad();
			scenario.log("Opened YouTube");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			exReport.enterPassLogWithSnap("Opened YouTube");
			log.info("Opened YouTube");

		} else {
			webDriver.waitUntilCompletelyLoad();
			scenario.log("Unable to open YouTube");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			exReport.enterFailLogWithSnap("Unable to open YouTube");
			log.info("Unable to open YouTube");
			flag = false;
			Assert.assertTrue(false);
		}
		webDriver.switchTab(0);
	}
	@And("verify insta")
	public void verifyInsta() throws IOException {

		if (home.checkInsta()) {
			webDriver.waitUntilCompletelyLoad();
			scenario.log("Opened Insta");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			exReport.enterPassLogWithSnap("Opened Insta");
			log.info("Opened Insta");

		} else {
			webDriver.waitUntilCompletelyLoad();
			scenario.log("Unable to open Insta");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			exReport.enterFailLogWithSnap("Unable to open Insta");
			log.info("Unable to open Insta");
			flag = false;
			Assert.assertTrue(false);
		}

		if (flag == false)
			Assert.assertTrue(flag);
	}
}
