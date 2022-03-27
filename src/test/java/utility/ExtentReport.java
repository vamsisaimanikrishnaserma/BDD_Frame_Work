package utility;

import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	ExtentSparkReporter spark;
	ExtentReports reports;
	ExtentTest reportLog;
	String reportsPath;
	String testName;
	
	
	
	public ExtentReport() {
		reportsPath=ConfigReader.getReportsPath()+"/"+ConfigReader.getTitle()+CurrentDateTime.getDateTime()+".html";
		spark = new ExtentSparkReporter(reportsPath);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		
	}
	
	public boolean isNull() {
		if(Objects.isNull(reportLog))
		return true;
		else 
			return false;
	}
	public void createNewTestReport(String title) {
		testName=title;
		reportLog = reports.createTest(title);
		
	}

	public void enterInfoLog(String log) {
		reportLog.info(log);
	}

	public void enterPassLog(String log) {
		reportLog.pass(log);
	}
	
	public void enterPassLogWithSnap(String log) throws IOException {
		reportLog.pass(log,MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreenshot.takeScreenshot()).build());
	}

	public void enterFailLog(String log) {
		reportLog.fail(log);
	}
	
	public void enterFailLogWithSnap(String log) throws IOException {
		reportLog.fail(log,MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreenshot.takeScreenshot()).build());
	}

	public void flush() {
		reports.flush();
	}
	
}
