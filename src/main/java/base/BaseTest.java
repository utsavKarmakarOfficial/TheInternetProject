package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import config.ConfigReader;
import driver.BrowserFactory;
import driver.DriverFactory;
import enums.BrowserType;

public class BaseTest {
    
	@Parameters("browser")
	@BeforeMethod
	public void setup(@Optional String browser) {
		
		BrowserType browserRef = browser!=null? BrowserType.valueOf(browser.toUpperCase()):BrowserType.valueOf(ConfigReader.get("browser").toUpperCase());
		WebDriver driver = BrowserFactory.createBrowser(browserRef);
		DriverFactory.setDriver(driver);
		
		DriverFactory.getDriver().get(ConfigReader.get("url"));
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
	    if (DriverFactory.getDriver() != null) {
	        DriverFactory.getDriver().quit();
	        DriverFactory.unload();
	    }
	}

}
