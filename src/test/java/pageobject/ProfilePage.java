package pageobject;

import uistore.ProfilePageUi;
import utility.BaseClass;

public class ProfilePage extends BaseClass {
	
	public boolean verifyDeatils(String name,String email,String phoneNumber) {
		boolean flag=true;
		webDriver.clickElement(ProfilePageUi.Profile);
		webDriver.clickElement(ProfilePageUi.basicProfileOption);
		String emailRecived=webDriver.getValue(ProfilePageUi.emailFeild);
		String phoneNumberRecived=webDriver.getValue(ProfilePageUi.phoneFeild);
		String nameRecived=webDriver.getValue(ProfilePageUi.nameFeild);
		if(emailRecived.equalsIgnoreCase(email)) {
			log.info("Testeamil "+ email+" and Recived email "+emailRecived);
			exReport.enterPassLog("TestEmail: "+ email+" <br> Recived email: "+emailRecived);
			
		}
		else {
			log.error("Testeamil "+ email+" and Recived email "+emailRecived);
			exReport.enterFailLog("Test Email: "+ email+" <br> Recived email: "+emailRecived);
			flag=false;
			
		}
		if(phoneNumber.equalsIgnoreCase(phoneNumberRecived)) {
			log.info("Test PhoneNumber "+ phoneNumber+" and Recived phoneNumber "+phoneNumberRecived);
			exReport.enterPassLog("Test PhoneNumber: "+ phoneNumber+"<br>Recived phoneNumber: "+phoneNumberRecived);
			
		}
		else {
			log.error("Test PhoneNumber "+ phoneNumber+" and Recived phoneNumber "+phoneNumberRecived);
			exReport.enterFailLog("Test PhoneNumber: "+ phoneNumber+"<br>Recived phoneNumber: "+phoneNumberRecived);
			flag=false;
			
		}
		if(name.equalsIgnoreCase(nameRecived)) {
			log.info("Test name "+ name+" and Recived name "+nameRecived);
			exReport.enterPassLog("Test name: "+ name+" <br>Recived name: "+nameRecived);
			
		}
		else {
			log.error("Test name "+ name+" and Recived name "+nameRecived);
			exReport.enterFailLog("Test name: "+ name+" <br> Recived name: "+nameRecived);
			flag=false;
		}
		
		return flag;
	}

}
