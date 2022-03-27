package uistore;

import org.openqa.selenium.By;

public class ProfilePageUi {
	static public By loggiedInUser= By.xpath("//span[@class='nb__3-MNF']");
	static public By profileMenu= By.xpath("//div[.='Sign Out']");
	static public By logOut= By.xpath("//div[.='Sign Out']");
	static public By Profile= By.xpath("//a[.='Profile']");
	static public By basicProfileOption= By.xpath("//div[.='Basic Profile']");
	static public By nameFeild= By.id("nameText");
	static public By emailFeild= By.id("emailText");
	static public By phoneFeild= By.id("phone");
}
