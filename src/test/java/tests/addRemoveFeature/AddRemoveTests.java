package tests.addRemoveFeature;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddRemoveElementPage;
import pages.HomePage;
import reports.ExtentTestManager;

public class AddRemoveTests extends BaseTest {

	private HomePage homePage;
	private AddRemoveElementPage addRemoveElementPage;

	@BeforeMethod
	public void initPages() {
		homePage = new HomePage();
		addRemoveElementPage = new AddRemoveElementPage();
	}

	// TC01 – Add one element
	// Click Add Element
	// Verify one Delete button appears

	@Test()
	public void shouldAddOneElement() {

		homePage.clickaddRemoveBtn();

		addRemoveElementPage.clickAddBtn();

		Assert.assertEquals(addRemoveElementPage.getDeleteBtnCount(), 1, "Exactly one delete button should be present");
		ExtentTestManager.getTest().info("Delete button count is 1");

		List<String> textOfBtns = addRemoveElementPage.getAllDeleteBtnText();

		for (String text : textOfBtns) {
			Assert.assertEquals(text, "Delete");
		}
		ExtentTestManager.getTest().info("Delete text appeared in the button");
	}

	// TC02 – Remove one element
	// Click Add Element
	// Click Delete
	// Verify Delete button is removed

	@Test
	public void shouldRemoveOneELement() {

		homePage.clickaddRemoveBtn();
		addRemoveElementPage.clickAddBtn();

		Assert.assertEquals(addRemoveElementPage.getDeleteBtnCount(), 1, "Exactly one delete button should be present");
		ExtentTestManager.getTest().info("Delete button count is 1");

		addRemoveElementPage.clickAllDeleteBtn();

		Assert.assertEquals(addRemoveElementPage.getDeleteBtnCount(), 0, "No delete button should be present");
		ExtentTestManager.getTest().info("No delete button is present");
	}

	// TC03 – Add multiple elements
	// Click Add Element 5 times
	// Verify 5 Delete buttons exist

	@Test
	public void shoulAddMultipleElements() {

		homePage.clickaddRemoveBtn();
		ExtentTestManager.getTest().info("Clicked the add/remove button in home page");

		addRemoveElementPage.clickAddBtnMultipleTimes(5);

		Assert.assertEquals(addRemoveElementPage.getDeleteBtnCount(), 5);
		ExtentTestManager.getTest().info("Delete button count is 5");

		List<String> textOfBtns = addRemoveElementPage.getAllDeleteBtnText();

		for (String text : textOfBtns) {
			Assert.assertEquals(text, "Delete");
		}
		ExtentTestManager.getTest().info("Delete text appeared in the button");
	}
	
	// TC04 – Remove one among many
    // Add 5 elements
    // Click Delete on 3rd element
    // Verify 4 remain
	
	@Test
	public void shouldRemoveOneAmongMany() {
		
		homePage.clickaddRemoveBtn();
		addRemoveElementPage.clickAddBtnMultipleTimes(5);
		addRemoveElementPage.clickParticularDeleteBtn(3);
		
		Assert.assertEquals(addRemoveElementPage.getDeleteBtnCount(), 4);
	}
	
	// TC05 – Remove all elements
    // Add N elements
    // Delete all
    // Verify zero remain
	
	@Test
	public void shouldRemoveAllElements() {
		
		homePage.clickaddRemoveBtn();
		addRemoveElementPage.clickAddBtnMultipleTimes(50);
		addRemoveElementPage.clickAllDeleteBtn();
		
		Assert.assertEquals(addRemoveElementPage.getDeleteBtnCount(), 0);
	}
}
