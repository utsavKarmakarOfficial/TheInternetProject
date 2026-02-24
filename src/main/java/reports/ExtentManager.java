package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FrameworkConstants;

public class ExtentManager {
    
	private ExtentManager() {}
	
	private static ExtentReports reports;
	
	public static ExtentReports getInstance() {
		if(reports==null) {
			
			ExtentSparkReporter reporter = new ExtentSparkReporter(FrameworkConstants.REPORT_PATH);
			reports = new ExtentReports();
			reports.attachReporter(reporter);
			
		}
		return reports;
	}
}


