package uistore;

import org.openqa.selenium.By;

public class HomePageUi {
	//Login UI Details
	static public By loginOption = By.xpath("//div[.='Log in']");
	static public By phoneNumberFeild = By.xpath("//input[@type='tel']");
	static public By loginContinueButton = By.id("signUpSubmit");
	static public By contineWithPasswordRadioButton = By.id("login-signup-form-login-radio-password");
	static public By passwordFeild = By.id("login-signup-form__password-input");
	static public By LoginButton = By.id("signUpSubmit");
	static public By loggiedInUser= By.xpath("//span[@class='nb__3-MNF']");
	static public By profileMenu= By.xpath("//div[.='Sign Out']");
	static public By logOut= By.xpath("//div[.='Sign Out']");
	
	//Search UI Menu Details
	static public By rentOption = By.xpath("//div[.='Rent']");
	static public By commertialOption = By.xpath("//div[.='Commercial']");
	static public By buyOption = By.xpath("//div[.='Buy']");
	
	//Search UI Details
	static public By searchTextFeild = By.id("listPageSearchLocality");
	static public By autoCompleteList = By.xpath("//div[@class='autocomplete-dropdown-container']");
	static public By searchButton = By.xpath("//button[@class='prop-search-button btn btn-primary btn-lg']");
	static public By selectedLocalities = By.id("selectedLocalities");
	
	//App download UI
	static public By androidAppImg = By.xpath("//img[@alt='android']");
	static public By androidAppDownloadLink = By.id("appAndroidDll");
	
	//Options UI details
	static public By builderProjects= By.id("builderHomeTile");
	
	//City selection UI
	static public By cityBangalore= By.xpath("//div[.='Bangalore']");
	static public By cityMumbai= By.xpath("//div[.='Mumbai']");
	static public By cityChennai= By.xpath("//div[.='Chennai']");
	static public By cityPune= By.xpath("//div[.='Pune']");
	static public By cityHyderabad= By.xpath("//div[.='Hyderabad']");
	static public By cityGurgaon= By.xpath("//div[.='Gurgaon']");
	
	//City selection POPUPUI
	static public By popUpCityBangalore= By.xpath("//div[.='Bangalore' and @class='nb__2p4w1']");
	static public By popUpCityMumbai= By.xpath("//div[.='Mumbai' and @class='nb__2p4w1']");
	static public By popUpCityChennai= By.xpath("//div[.='Chennai' and @class='nb__2p4w1']");
	static public By popUpCityPune= By.xpath("//div[.='Pune' and @class='nb__2p4w1']");
	static public By popUpCityHyderabad= By.xpath("//div[.='Hyderabad' and @class='nb__2p4w1']");
	static public By popUpCityGurgaon= By.xpath("//div[.='Gurgaon' and @class='nb__2p4w1']");
	
	
	//Footer page UI
	static public By footerPgHostels= By.xpath("//div[.='PG / Hostels']");
	static public By footerPgHostelsHeadersList= By.xpath("//a[@rel='noopener noreferrer' and @class='heading-6 font-semi-bold nb__SmXT_']");
	static public By footerPgHostelsList= By.xpath("//a[@rel='noopener noreferrer' and @class='nb__1pJSa']");
	
	//Footer Social media Links 
	static public By footerFaceBook= By.xpath("//a[@aria-label='facebook']");
	static public By footerTwitter= By.xpath("//a[@aria-label='twitter']");
	static public By footerInstagram= By.xpath("//a[@aria-label='instagram']");
	static public By footerLinkdin= By.xpath("//a[@aria-label='linkedin']");
	static public By footerYouTube= By.xpath("//a[@aria-label='youtube']");
	
	//Home page Services
	static public By emiCalculator= By.xpath("//a[.='EMI Calculator']");
	
}
