package utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class CaptureScreenshot extends BaseClass {
	static String path;
	static File file;
	static public  String takeScreenshot(String browser) throws IOException {
		path = ConfigReader.getScreenshotPath()+"/"+browser+CurrentDateTime.getDateTime() + ".png";
		file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(path));
		int  extendReports=StringUtils.countMatches(ConfigReader.getReportsPath(), "/");
		for(int i=0;i<=(extendReports);i++)
			path="../"+path;
		return path;
	}
	static public String takeScreenshot() throws IOException {
		path =ConfigReader.getScreenshotPath()+"/Screenshot"+CurrentDateTime.getDateTime()+".png";
		file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(path));
		int  extendReports=StringUtils.countMatches(ConfigReader.getReportsPath(), "/");
		for(int i=0;i<=(extendReports);i++)
			path="../"+path;
		return path;
	}

}
