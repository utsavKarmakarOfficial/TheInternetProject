package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import driver.DriverFactory;
import utils.WaitUtil;

public class BasePage {
    
	public void click(By locator) {
		WaitUtil.presenecOfElement(locator).click();;
	}
	
	public void type(By locator, String text) {
		WaitUtil.presenecOfElement(locator).sendKeys(text);
	}
	
	public void pressEnter(By lcoator) {
		WaitUtil.presenecOfElement(lcoator).sendKeys(Keys.ENTER);
	}
	
    protected void refreshPage() {
        DriverFactory.getDriver().navigate().refresh();
    }

}
