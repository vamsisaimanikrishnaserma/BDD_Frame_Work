package pageobject;

import org.openqa.selenium.Keys;

import reusable.AllLogger;
import uistore.HomePageUi;
import uistore.SearchResultPageUi;
import utility.BaseClass;
import utility.ConfigReader;

public class HomePage extends BaseClass {

	public void clickOnLogin() {
		webDriver.clickElement(HomePageUi.loginOption);
		log.createLogger(getClass());
	}

	public void enterloginDetails(String phoneNo, String password) {
		log.createLogger(getClass());
		webDriver.waitUntilVisibilityOfElement(HomePageUi.phoneNumberFeild);
		AllLogger.infoLog("Entering phone no : " + phoneNo);
		webDriver.sendText(HomePageUi.phoneNumberFeild, phoneNo);
		AllLogger.passLog("Clicking continue");
		webDriver.clickElement(HomePageUi.loginContinueButton);
		AllLogger.passLog("Selecting Login with password");
		webDriver.waitUntilElementToBeClickable(HomePageUi.contineWithPasswordRadioButton);
		webDriver.clickElement(HomePageUi.contineWithPasswordRadioButton);
		webDriver.waitUntilVisibilityOfElement(HomePageUi.passwordFeild);
		AllLogger.infoLog("Entering password : " + password);
		webDriver.sendText(HomePageUi.passwordFeild, password);
		webDriver.clearText(HomePageUi.passwordFeild);
		webDriver.sendText(HomePageUi.passwordFeild, password);
	}

	public void clickOnSignIn() {
		log.createLogger(getClass());
		webDriver.clickElement(HomePageUi.LoginButton);
	}

	public boolean verifyLogin() {
		log.createLogger(getClass());
		try {
			webDriver.waitUntilVisibilityOfElement(HomePageUi.loggiedInUser);
			webDriver.hover(HomePageUi.loggiedInUser);
			webDriver.waitUntilVisibilityOfElement(HomePageUi.logOut);
			if (webDriver.checkPresent(HomePageUi.logOut))
				return true;
			else
				return false;
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}

	public boolean searchRent(String keyword) {
		try {

			webDriver.openPage(ConfigReader.getUrl());
			AllLogger.infoLog("Opening the url : " + ConfigReader.getUrl());
			webDriver.clickElement(HomePageUi.rentOption);
			webDriver.clickElement(HomePageUi.searchTextFeild);
			webDriver.sendText(HomePageUi.searchTextFeild, keyword);
			webDriver.waitUntilVisibilityOfElement(HomePageUi.autoCompleteList);
			webDriver.sendKeys(HomePageUi.searchTextFeild, Keys.ARROW_UP);
			webDriver.sendKeys(HomePageUi.searchTextFeild, Keys.ENTER);
			webDriver.waitUntilVisibilityOfElement(HomePageUi.selectedLocalities);
			webDriver.clickElement(HomePageUi.searchButton);
			SearchResultPage searchResult = new SearchResultPage();
			webDriver.waitUntilVisibilityOfElement(SearchResultPageUi.totalResults);
			webDriver.waitElmentValueGraterThanZero(SearchResultPageUi.totalResults);
			log.info(" Number of Results found for " + keyword + " :" + searchResult.resultCount());
			exReport.enterInfoLog(" Number of Results found for " + keyword + " :" + searchResult.resultCount());
			if (searchResult.resultCount() > 0) {
				return true;

			} else {
				return false;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			exReport.enterFailLog(e.getMessage());
			return false;
		}
	}

	public void clickCommertial() {
		AllLogger.infoLog("clicked on commertail");
		webDriver.clickElement(HomePageUi.commertialOption);
		AllLogger.passLog("selcting city as Mumbai");
		webDriver.clickElement(HomePageUi.cityMumbai);
	}
	
	public void selectRent() {
		
	}

	public void searchCommertial(String keyword) {
		try {
			webDriver.clickElement(HomePageUi.searchTextFeild);
			AllLogger.infoLog("Entering loacation as " + keyword);
			webDriver.sendText(HomePageUi.searchTextFeild, keyword);
			webDriver.waitUntilVisibilityOfElement(HomePageUi.autoCompleteList);
			webDriver.sendKeys(HomePageUi.searchTextFeild, Keys.ARROW_UP);
			webDriver.sendKeys(HomePageUi.searchTextFeild, Keys.ENTER);
			webDriver.waitUntilVisibilityOfElement(HomePageUi.selectedLocalities);
			webDriver.clickElement(HomePageUi.searchButton);

		} catch (Exception e) {
			log.error(e.getMessage());
			exReport.enterFailLog(e.getMessage());
		}
	}

	public void downloadAndroidApp() {
			webDriver.JsClick(HomePageUi.androidAppDownloadLink);
			AllLogger.infoLog("Clicking on download android app");
			webDriver.switchTab(1);
	}
	
	public boolean verifyCorrectApp() {
		if (webDriver.getPageTitle().contains("NoBroker")
				&& webDriver.getCurrentUrl().contains("https://play.google.com/"))
			return true;
		else
			return false;
	}
	
	public void clickOnBuilder() {
		webDriver.clickElement(HomePageUi.buyOption);
		AllLogger.passLog("Clicking on new builder properties");
		webDriver.waitUntilVisibilityOfElement(HomePageUi.builderProjects);
		webDriver.clickElement(HomePageUi.builderProjects);
	}
	
	
	public void selectBuilderProjects(String city) throws InterruptedException {
		try {
			
			webDriver.waitUntilVisibilityOfElement(HomePageUi.popUpCityBangalore);
			AllLogger.infoLog("Clicking on city :" + city);
			if (city.contains("Bangalore"))
				webDriver.clickElement(HomePageUi.popUpCityBangalore);
			else if (city.contains("Mumbai"))
				webDriver.clickElement(HomePageUi.popUpCityMumbai);
			else if (city.contains("Chennai"))
				webDriver.clickElement(HomePageUi.popUpCityChennai);
			else if (city.contains("Pune"))
				webDriver.clickElement(HomePageUi.popUpCityPune);
			else if (city.contains("Hyderabad"))
				webDriver.clickElement(HomePageUi.popUpCityHyderabad);
			else if (city.contains("Gurgaon"))
				webDriver.clickElement(HomePageUi.popUpCityGurgaon);
		} catch (Exception e) {

			e.printStackTrace();
			log.error(e.getMessage());
			exReport.enterFailLog(e.getMessage());

		}

	}

	public void clickFooterPgHostel() {
		
		webDriver.jsScroolMiddle(HomePageUi.footerPgHostels);
		webDriver.JsClick(HomePageUi.footerPgHostels);
		
	}
	public boolean searchFooterPgHostels(String city) {
		try {
			AllLogger.infoLog("checking presence of city: " + city);
			
			boolean resultList = false;
			boolean resultHeader = webDriver.searchElementsContains(HomePageUi.footerPgHostelsHeadersList, city);
			if (resultHeader != true) {
				resultList = webDriver.searchElementsContains(HomePageUi.footerPgHostelsList, city);
			}
			if (resultList || resultHeader)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			exReport.enterFailLog(e.getMessage());
			return false;
		}

	}

	public boolean checkFaceBook() {
		log.createLogger(getClass());
		webDriver.openPage(ConfigReader.getUrl());
		AllLogger.infoLog("Opeining facebook");
		webDriver.JsClick(HomePageUi.footerFaceBook);
		webDriver.switchLastTab();

		if (webDriver.getPageTitle().contains("NoBroker")
				&& webDriver.getCurrentUrl().contains("https://www.facebook.com/"))
			return true;
		else
			return false;
	}

	public boolean checkTwitter() {
		log.createLogger(getClass());
		webDriver.openPage(ConfigReader.getUrl());
		AllLogger.infoLog("Opeining twitter");
		webDriver.JsClick(HomePageUi.footerTwitter);
		webDriver.switchLastTab();
		System.out.println(webDriver.getPageTitle().contains("NoBroker"));
		System.out.println(webDriver.getCurrentUrl().contains("https://www.facebook.com/"));
		if (webDriver.getPageTitle().contains("NoBroker") && webDriver.getCurrentUrl().contains("https://twitter.com/"))
			return true;
		else
			return false;
	}

	public boolean checkInsta() {
		log.createLogger(getClass());
		webDriver.openPage(ConfigReader.getUrl());
		AllLogger.infoLog("Opeining Insta");
		webDriver.JsClick(HomePageUi.footerInstagram);
		webDriver.switchLastTab();

		if (webDriver.getPageTitle().contains("NoBroker")
				&& webDriver.getCurrentUrl().contains("https://www.instagram.com/"))
			return true;
		else
			return false;
	}

	public boolean checkLinkdin() {
		log.createLogger(getClass());
		webDriver.openPage(ConfigReader.getUrl());
		AllLogger.infoLog("Opeining Linkdin");
		webDriver.JsClick(HomePageUi.footerLinkdin);
		webDriver.switchLastTab();
		if (webDriver.getPageTitle().contains("NoBroker")
				&& webDriver.getCurrentUrl().contains("https://www.linkedin.com/"))
			return true;
		else
			return false;
	}

	public boolean checkYouTube() {
		log.createLogger(getClass());
		webDriver.openPage(ConfigReader.getUrl());
		AllLogger.infoLog("Opeining youtube");
		webDriver.JsClick(HomePageUi.footerYouTube);
		webDriver.switchLastTab();
		if (webDriver.getPageTitle().contains("NoBroker")
				&& webDriver.getCurrentUrl().contains("https://www.youtube.com/"))
			return true;
		else
			return false;
	}

	public void openEmiCalculator() throws InterruptedException {
		AllLogger.infoLog("Opening the url : " + ConfigReader.getUrl());
		webDriver.openPage(ConfigReader.getUrl());
		webDriver.JsClick(HomePageUi.emiCalculator);
		AllLogger.infoLog("Opeining emi calculator");
		webDriver.switchLastTab();
	}

}
