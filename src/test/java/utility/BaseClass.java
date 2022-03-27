package utility;

import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobject.BuilderPropertiesPage;
import pageobject.EmiCalculatorPage;
import pageobject.HomePage;
import pageobject.ProfilePage;
import reusable.WebDriverHelper;
public class BaseClass {
	static public ProfilePage profile;
	static public BuilderPropertiesPage builderPage;
	static public HomePage home;
	static public WebDriverHelper webDriver;
	static public WebDriver driver;
	static public Log log;
	static public ExtentReport exReport;
	static public WebDriverWait wait;
	static public EmiCalculatorPage emiCalculator;

	public void init() {
		System.setProperty("extent.reporter.avent.config", ConfigReader.getExtentReportsConfig());
		if(Objects.isNull(exReport))
			exReport = new ExtentReport();
	}
	public void required(String browser) {
		System.out.print(browser);
		System.setProperty("log4j2.configurationFile", ConfigReader.getLog4jConfig());
		log = new Log();
		
		log.createLogger(BaseClass.class);
		webDriver = new WebDriverHelper();
		if (ConfigReader.getBrowser().contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", ConfigReader.getChromeDriver());
			driver = new ChromeDriver();
			log.info("Driver set as Chrome");
		} else if (ConfigReader.getBrowser().contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", ConfigReader.getFireFoxDriver());
			driver = new FirefoxDriver();
			log.info("Driver set as firefox");
		}
		driver.manage().window().maximize();
		log.info("Driver Maximized");
		wait = new WebDriverWait(driver,Duration.ofSeconds(ConfigReader.getExplicitWait()));
		home = new HomePage();
		profile = new ProfilePage();
		builderPage= new BuilderPropertiesPage();
		emiCalculator = new EmiCalculatorPage();
	}

	public void driverExit() throws IOException {
		driver.quit();
	}
	
	public void flush() {
		exReport.flush();
	}

}
