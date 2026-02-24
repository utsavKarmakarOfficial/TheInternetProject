package pages;

import org.openqa.selenium.By;

import base.BasePage;
import reports.ExtentTestManager;
import utils.WaitUtil;

public class CheckBoxPage extends BasePage{

	private By checkbox1 = By.xpath("//form[@id='checkboxes']/input[1]");
	private By checkbox2 = By.xpath("//form[@id='checkboxes']/input[2]");


	public void clickCheckbox1() {

		WaitUtil.elementToBeClickable(checkbox1).click();
		ExtentTestManager.getTest().info("Clicked checkbox 1");
	}

	public void clickCheckbox2() {

		WaitUtil.elementToBeClickable(checkbox2).click();
		ExtentTestManager.getTest().info("Clicked checkbox 2");
	}

	public boolean isCheckbox1Selected() {

		return WaitUtil.presenecOfElement(checkbox1).isSelected();
	}

	public boolean isCheckbox2Selected() {

		return WaitUtil.presenecOfElement(checkbox2).isSelected();
	}
	
	public boolean AreBothCheckboxSelected() {
		
		Boolean a = WaitUtil.presenecOfElement(checkbox1).isSelected();
		Boolean b = WaitUtil.presenecOfElement(checkbox2).isSelected();
		
		if(a && b) {
			return true;
		}
		
		return false;
	}
	
	public boolean isNoCheckboxSelected() {
		
		if(isCheckbox1Selected() && isCheckbox2Selected()) {
			return false;
		}
		
		return true;
	}
	
	public void refresh() {
		
        refreshPage();   
    }

}
