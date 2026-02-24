package tests.checkBoxFeature;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckBoxPage;
import pages.HomePage;

public class CheckBoxTests extends BaseTest{

	private HomePage homePage;
	private CheckBoxPage checkBoxPage;

	@BeforeMethod
	public void initPages() {
		homePage = new HomePage();
		checkBoxPage = new CheckBoxPage();
	}

	// TC 01
	// check the default state : checkbox1 -> unchecked , checkbox2 -> checked

	@Test
	public void checkDefaultState() {

		homePage.clickCheckboxBtn();
		Assert.assertEquals(checkBoxPage.isCheckbox1Selected(), false);
		Assert.assertEquals(checkBoxPage.isCheckbox2Selected(), true);
	}

	// TC 02
	// Click checkbox 1
	// Verify it becomes checked

	@Test
	public void isCheckBox1Checked() {

		homePage.clickCheckboxBtn();
		checkBoxPage.clickCheckbox1();
		Assert.assertEquals(checkBoxPage.isCheckbox1Selected(), true);
	}

	// TC 03
	// Unselect checkbox 2
	// Verify it becomes unchecked

	@Test
	public void isCheckBox2Unchecked() {

		homePage.clickCheckboxBtn();
		checkBoxPage.clickCheckbox2();
		Assert.assertEquals(checkBoxPage.isCheckbox2Selected(), false);
	}

	// TC 04
	// Click checkbox 1 twice
	// State should go unchecked -> checked -> unchecked

	@Test
	public void isCheckBox1UncheckedAgain() {

		homePage.clickCheckboxBtn();
		checkBoxPage.clickCheckbox1();
		checkBoxPage.clickCheckbox1();
		Assert.assertEquals(checkBoxPage.isCheckbox1Selected(), false);
	}
	
	// TC 05
	// Select both checkbox
	// Verify both are selected
	
	@Test
	public void areBothCheckboxesSelected() {
		
		homePage.clickCheckboxBtn();
		checkBoxPage.clickCheckbox1();
		Assert.assertEquals(checkBoxPage.isCheckbox1Selected(), true);
		Assert.assertEquals(checkBoxPage.isCheckbox2Selected(), true);
	}
	
	// TC 06
	// Uncheck both checkboxes
	// Verify both are unchecked
	
	@Test
	public void areBothCheckboxesUnchecked() {
		
		homePage.clickCheckboxBtn();
		checkBoxPage.clickCheckbox2();
		Assert.assertEquals(checkBoxPage.isCheckbox1Selected(), false);
		Assert.assertEquals(checkBoxPage.isCheckbox2Selected(), false);
	}
	
	// TC 07
	// Check checkbox 1, verify
	// Refresh page
	// Check if checkbox1 is unchecked
	
	@Test
	public void doesREfreshKeepSanity() {
		
		homePage.clickCheckboxBtn();
		checkBoxPage.clickCheckbox1();
		
		Assert.assertEquals(checkBoxPage.isCheckbox1Selected(), true);
		Assert.assertEquals(checkBoxPage.isCheckbox2Selected(), true);
		
		checkBoxPage.refresh();
		
		Assert.assertEquals(checkBoxPage.isCheckbox1Selected(), false);
		Assert.assertEquals(checkBoxPage.isCheckbox2Selected(), true);
		
	}
}
