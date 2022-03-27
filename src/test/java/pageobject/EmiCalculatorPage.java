package pageobject;



import uistore.EmiCalculatorUi;
import utility.BaseClass;

public class EmiCalculatorPage extends BaseClass {
	public void calculate(String loanAmount, String rateOfIntrest,String loanTenure) {
		webDriver.clearText(EmiCalculatorUi.loanAmount);
		webDriver.sendText(EmiCalculatorUi.loanAmount, loanAmount);
		webDriver.clearText(EmiCalculatorUi.rateOfIntrest);
		webDriver.sendText(EmiCalculatorUi.rateOfIntrest, rateOfIntrest);
		webDriver.clearText(EmiCalculatorUi.loanTenure);
		webDriver.sendText(EmiCalculatorUi.loanTenure, loanTenure);
	}

	public String getMonthlyEmi() {
		String amount=webDriver.getText(EmiCalculatorUi.monthlyEmi);
		return amount;
	}
	public String getPrincipalAmount(){
		String amount=webDriver.getText(EmiCalculatorUi.principalAmount);
		return amount;
	}
	public String getTotalIntrest() {
		String amount=webDriver.getText(EmiCalculatorUi.totalIntrest);
		return amount;
	}
	public String getTotalAmount() {
		String amount=webDriver.getText(EmiCalculatorUi.totalAmount);
		return amount;
	}


}
