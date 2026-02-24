package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import config.ConfigReader;
import enums.BrowserType;
import exceptions.InvalidBrowserException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver createBrowser(BrowserType browser) {

		switch (browser) {

		case CHROME:
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();

		case SAFARI:
			WebDriverManager.safaridriver().setup();
			return new SafariDriver();
			
		case EDGE:
			return new EdgeDriver();
		
		case FIREFOX:
			return new FirefoxDriver();

		default:
			throw new InvalidBrowserException(String.valueOf(browser));
		}

	}

}
