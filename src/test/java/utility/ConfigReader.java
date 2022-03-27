package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	static Properties property;
	static {
		FileInputStream fileStream;
		try {
			fileStream = new FileInputStream("configs/config.properties");
			property = new Properties();
			property.load(fileStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getBrowser() {
		return property.getProperty("browser");
	}
	
	public static String getChromeDriver() {
		return property.getProperty("chromeDriver");
	}
	
	public static String getUrl() {
		return property.getProperty("url");
	}

	public static String getExcelPath() {
		return property.getProperty("excelPath");
	}

	public static String getExtentReportsConfig() {
		return property.getProperty("extentReportsConfig");
	}

	public static String getReportsPath() {
		return property.getProperty("reportsPath");
	}

	public static String getScreenshotPath() {
		return property.getProperty("screenshotPath");
	}

	public static String getFireFoxDriver() {
		return property.getProperty("fireFoxDriver");
	}
	public static int getImplicitWait() {
		return Integer.valueOf(property.getProperty("implicitWait"));
	}
	public static String getTitle() {
		return property.getProperty("title");
	}
	public static String getLog4jConfig() {
		return property.getProperty("log4jConfig");
	}
	public static String getlog4jPath() {
		return property.getProperty("log4jPath");
	}
	public static int getExplicitWait() {
		return Integer.valueOf(property.getProperty("explicitWait"));
		
	}
}
