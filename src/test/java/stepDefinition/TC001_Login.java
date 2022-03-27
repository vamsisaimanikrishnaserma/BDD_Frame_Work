package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import reusable.AllLogger;
import utility.BaseClass;


public class TC001_Login extends BaseClass {
	private Scenario scenario;

    @Before()
    public void embedScreenshotStep(Scenario scenario) {
    	this.scenario = scenario;
    }
	
	@Given("I am on {string} in {string} browser")
	public void i_am_on_url_in_browser(String url, String browser) {
		init();
		required(browser);
		log.createLogger(getClass());
	
		webDriver.openPage(url);
	}
	@And("Click on login")
	public void click_on_login(){
		exReport.createNewTestReport("login");
		AllLogger.passLog("Clicking on login");
		home.clickOnLogin();
		
	}
	@Then("entering phone number {string} and passord as {string}")
	public void entering_details(String phoneNumber, String password ){
		AllLogger.infoLog("Entering details");
		home.enterloginDetails(phoneNumber, password);
	}
	@And("click on sigin in")
	public void clickon_signin(){
		home.clickOnSignIn();
		AllLogger.passLog("Clicking on signIn");
		
	}
	@Then("it must login into account")
	public void verifyLogin() throws IOException{
		boolean result = home.verifyLogin();
		 byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
         scenario.attach(screenshot, "image/png", "Loginscreenshot");  //(screenshot, "image/png");
		if(result==true) {
			exReport.enterPassLogWithSnap("Login success");
			log.info("Login Success");
			scenario.log("Login Success");
			Assert.assertTrue(result);
		}
		else {
			exReport.enterFailLogWithSnap("Login FAILED");
			log.info("Login FAILED");
			scenario.log("Login failed");
			Assert.assertTrue(result);
		}
		
	}
	@After
	public void afterScenario() throws IOException {
		
		driverExit();
	}
	

}
