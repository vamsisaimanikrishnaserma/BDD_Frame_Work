package reusable;

import java.time.Duration;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


import utility.BaseClass;




public class WebDriverHelper extends BaseClass {
	
	
	public void waitUntilCompletelyLoad() {
		wait.until(new PageLoaded());
	}
	
	public boolean searchElementsContains(By elements,String keyword) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		for(WebElement element:driver.findElements(elements)) {
			if(element.getText().contains(keyword)) {
				jse.executeScript(scrollElementIntoMiddle, element);
				Thread.sleep(1000);
				jse.executeScript("arguments[0].style.border='2px solid red'", element);
				return true;
			}
		}
		return false;
	}
	
	public String getValue(By element) {
		return driver.findElement(element).getAttribute("value");
	}
	
	public void jsScroolMiddle(By element) {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		WebElement webElement = driver.findElement(element);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript(scrollElementIntoMiddle, webElement);
	}
	
	public void JsClick(By element) {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		WebElement webElement = driver.findElement(element);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript(scrollElementIntoMiddle, webElement);
		jse.executeScript("arguments[0].click();", webElement); 
	}
	
	public void waitElmentValueGraterThanZero(By element) {
		 Pattern pattern = Pattern.compile("^[1-9][0-9]*$");
		wait.until(ExpectedConditions.textMatches(element, pattern ));
	}
	
	public void moveAndClick(By element) {
		WebElement webElement = driver.findElement(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().perform();
		
	}
	
	public void waitUntilInVisibilityOfElement(By element) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}
	
	public void waitUntilVisibilityOfElement(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public void waitUntilElementToBeClickable(By element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickElement(By element) throws ElementNotInteractableException {
		driver.findElement(element).click();
	}

	
	public void clearText( By element) throws ElementNotInteractableException {
		driver.findElement(element).clear();
	}

	public void sendText(By element, String value) throws ElementNotInteractableException {
		driver.findElement(element).sendKeys(value);
	}

	

	public String getText(By element) {
		return driver.findElement(element).getText();
	}

	public void switchTab( int index) {
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(index));
	}
	public void switchLastTab() {
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(windows.size()-1));
	}

	public void implicitWait(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public void openPage(String Url) {
		driver.get(Url);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void hoverAndClick(WebDriver driver, By hoverElement, By selction) throws InterruptedException {
		WebElement element = driver.findElement(hoverElement);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		Thread.sleep(1);
		driver.findElement(selction).click();
	}

	public void hover(By hoverElement) throws InterruptedException {
		WebElement element = driver.findElement(hoverElement);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		Thread.sleep(1);
	}

	public boolean checkPresent(By element) {
		return driver.findElement(element).isDisplayed();
	}

	public void sendKeys(By element, Keys key) {
		driver.findElement(element).sendKeys(key);
	}
	
	

}
