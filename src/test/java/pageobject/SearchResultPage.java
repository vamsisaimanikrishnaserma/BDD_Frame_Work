package pageobject;

import uistore.SearchResultPageUi;
import utility.BaseClass;

public class SearchResultPage extends BaseClass {
	public int resultCount() {
		String result = webDriver.getText(SearchResultPageUi.totalResults);
		
		return Integer.parseInt(result);
	}
}
