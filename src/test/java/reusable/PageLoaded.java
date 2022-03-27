package reusable;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import utility.BaseClass;

public class PageLoaded extends BaseClass implements ExpectedCondition<Boolean> {
	public Boolean apply(WebDriver input) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		return jse.executeScript("return document.readyState").equals("complete");
	}
}
