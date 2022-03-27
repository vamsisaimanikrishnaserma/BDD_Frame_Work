package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import utility.BaseClass;

public class TC010_Emi_defination extends BaseClass {
	private Scenario scenario;

	@Before()
	public void embedScreenshotStep(Scenario scenario) {
		this.scenario = scenario;
	}

	@And("selct emi option")
	public void selctEmi() throws IOException, InterruptedException {
		log.createLogger(getClass());
		exReport.createNewTestReport("Selecting emi");
		log.info("Selecting emi");
		home.openEmiCalculator();

	}

	@Then("enter vales Loan_Amount {string} Rate_of_Interest {string} and Loan_Tenure {string}")
	public void enterEmivalues(String loanAmount, String rateOfIntrest, String loanTenure) throws IOException {
		emiCalculator.calculate(loanAmount, rateOfIntrest, loanTenure);
	}
	@Then("it must show Monthly EMI {string} Principal_Amount {string} TotalInterest {string} and Total Amount {string}")
	public void verifyEmiResult(String monthlyEmi, String principalAmount, String totalIntrest, String totalAmount) throws IOException {
		boolean result=true;
		String actualPrincipalAmount=emiCalculator.getPrincipalAmount().substring(1);
		String actualTotalIntrest = emiCalculator.getTotalIntrest().substring(1);
		String actualTotalAmount=emiCalculator.getTotalAmount().substring(1);
		String actualMonthlyEmi=emiCalculator.getMonthlyEmi().substring(1);
		
		if (actualPrincipalAmount.equalsIgnoreCase(principalAmount)) {
			log.info("Expected principal Amount: "+principalAmount);
			log.info("Actual principal Amount: "+emiCalculator.getPrincipalAmount());
			exReport.enterPassLog("Expected principal Amount: "+principalAmount+"<br />"+"Actual principal Amount: "+actualPrincipalAmount);
		}
		else {
			log.info("Expected principal Amount: "+principalAmount);
			log.info("Actual principal Amount: "+emiCalculator.getPrincipalAmount());
			exReport.enterFailLog("Expected principal Amount: "+principalAmount+"<br />"+"Actual principal Amount: "+actualPrincipalAmount);
			result=false;
		}
		if (actualMonthlyEmi.equalsIgnoreCase(monthlyEmi)) {
			log.info("Expected montly Emi: "+monthlyEmi);
			log.info("Actual montly Emi: "+actualMonthlyEmi);
			exReport.enterPassLog("Expected montly emi: "+monthlyEmi+"<br />"+"Actual montly Emi: "+actualMonthlyEmi);
		}
		else {
			log.info("Expected montly Emi: "+monthlyEmi);
			log.info("Actual montly Emi: "+actualMonthlyEmi);
			exReport.enterFailLog("Expected montly emi: "+monthlyEmi+"<br />"+"Actual montly Emi: "+actualMonthlyEmi);
			result=false;
			
		}
		if (actualTotalIntrest.equalsIgnoreCase(totalIntrest)) {
			log.info("Expected Total Intrest: "+totalIntrest);
			log.info("Actual Total Intrest: "+actualTotalIntrest);
			exReport.enterPassLog("Expected Total Intrest: "+totalIntrest+"<br />"+"Actual Total Intrest: "+actualTotalIntrest);
		}
		else {
			log.info("Expected Total Intrest: "+totalIntrest);
			log.info("Actual Total Intrest: "+actualTotalIntrest);
			exReport.enterFailLog("Expected Total Intrest: "+totalIntrest+"<br />"+"Actual Total Intrest: "+actualTotalIntrest);
			result=false;
		}
		if(actualTotalAmount.equalsIgnoreCase(totalAmount)) {
			log.info("Expected Total amount: "+totalAmount);
			log.info("Actual Total Amount: "+actualTotalAmount);
			exReport.enterPassLog("Expected Total Amount: "+totalAmount+"<br />"+"Actual Total Intrest: "+actualTotalAmount);
		}
		else {
			log.info("Expected Total amount: "+totalAmount);
			log.info("Actual Total Amount: "+actualTotalAmount);
			exReport.enterFailLog("Expected Total Amount: "+totalAmount+"<br />"+"Actual Total Intrest: "+actualTotalAmount);
			result=false;
			
		}
		if(result==true) {
			exReport.enterPassLogWithSnap("Emi calculations are correct");
			scenario.log("Emi calculations are correct");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			log.info("Emi calculations are correct");
		}
		else {
			exReport.enterPassLogWithSnap("Emi calculations are not correct");
			scenario.log("Emi calculations are not correct");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Loginscreenshot");
			log.info("Emi calculations are not correct");
			Assert.assertTrue(false);
		}

	}
	
	@After
	public void tearDown() {
		flush();
	}
	
}
