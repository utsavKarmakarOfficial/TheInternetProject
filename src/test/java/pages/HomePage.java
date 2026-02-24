package pages;

import org.openqa.selenium.By;

import base.BasePage;
import reports.ExtentTestManager;

public class HomePage extends BasePage{
	
    private By addRemoveBtn = By.linkText("Add/Remove Elements");
    private By checkboxBtn = By.xpath("//a[@href='/checkboxes']");

    
    public void clickaddRemoveBtn() {
    	
    	click(addRemoveBtn);
    	ExtentTestManager.getTest().info("Clicked the add/remove button in home page");
    }
    
    
    public void clickCheckboxBtn() {
    	
    	click(checkboxBtn);
    	ExtentTestManager.getTest().info("Clicked the checkbox button in home page");
    }
}
