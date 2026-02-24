package reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
    
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	public static ExtentTest getTest() {
		return test.get();
	}
	
	public static void setTest(ExtentTest testRef) {
		test.set(testRef);
	}
	
	public static void unload() {
		test.remove();
	}
}
