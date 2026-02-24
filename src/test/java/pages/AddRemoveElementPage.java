package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;
import driver.DriverFactory;
import reports.ExtentTestManager;
import utils.WaitUtil;

public class AddRemoveElementPage extends BasePage {

	private By addBtn = By.xpath("//button[text()='Add Element']");
	private By allDeleteBtns = By.xpath("//div[@id='elements']/button");

	
	public void clickAddBtn() {

		WaitUtil.elementToBeClickable(addBtn).click();
	}

	
	public int getDeleteBtnCount() {

		// return WaitUtil.presenceOfAllElement(allDeleteBtns).size();
		return DriverFactory.getDriver().findElements(allDeleteBtns).size();
	}

	
	public List<String> getAllDeleteBtnText() {

		List<WebElement> allDeleteBtn = WaitUtil.presenceOfAllElement(allDeleteBtns);
		List<String> texts = new ArrayList<>();

		for (WebElement element : allDeleteBtn) {
			texts.add(element.getText());
		}
		return texts;
	}

	
	public void clickAllDeleteBtn() {

		while (getDeleteBtnCount() > 0) {
			WaitUtil.presenceOfAllElement(allDeleteBtns).get(0).click();
		}
		ExtentTestManager.getTest().info("Clicked all delete button");

		// This logic works as well but the first one is more compact

		// int initialDeleteBtnCount = getDeleteBtnCount();
		//
		// for(int i=0;i<initialDeleteBtnCount;i++) {
		// List<WebElement> allDeleteBtn = WaitUtil.presenceOfAllElement(allDeleteBtns);
		// allDeleteBtn.get(i).click();
		// }
		// ExtentTestManager.getTest().info("Clicked all delete button");
	}

	
	public void clickAddBtnMultipleTimes(int count) {

		for (int i = 0; i < count; i++) {
			clickAddBtn();
		}
		ExtentTestManager.getTest().info("Clicked Add button" + count + " times");
	}

	
	public void clickParticularDeleteBtn(int n) {

		if (n > 0) {
			if (getDeleteBtnCount() > 0 &&  n <= getDeleteBtnCount()) {
				List<WebElement> allDeleteBtn = WaitUtil.presenceOfAllElement(allDeleteBtns);

				for (int i = 1; i <= allDeleteBtn.size(); i++) {
					if (i == n) {
						allDeleteBtn.get(i-1).click();
						ExtentTestManager.getTest().info("delete button clicked: " + n);
					}
				}

			}
		}
	}
	

}
