package pageobject;

import uistore.BuilderPropertiesPageUi;
import utility.BaseClass;

public class BuilderPropertiesPage extends BaseClass {
	
	public String getHeadingOfResults() {
		String result = webDriver.getText(BuilderPropertiesPageUi.resultsHeading);
		
		return result;
	}
	

}
