package reusable;

import utility.BaseClass;

public class AllLogger extends BaseClass {
	
	static public void infoLog(String message) {
		log.info(message);
		exReport.enterInfoLog(message);
	}
	
	static public void passLog(String message) {
		log.info(message);
		exReport.enterPassLog(message);
	}

}
