package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";

	public ContactsPageTest() {

		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		contactsPage = homePage.clickContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label is not displayed on contacts page");
	}

	@Test(priority = 2)
	public void clickUsernameCheckboxTest() {
		contactsPage.clickUsernameCheckbox();
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = testUtil.getTestData(sheetName);
		return data;

	}

	@Test(priority = 3, dataProvider="getCRMTestData")
	public void validateCreateNewContactTest(String title, String firstName, String lastName, String company) {
		homePage.clickNewContactLink();
		contactsPage.createNewContact(title, firstName, lastName, company);

	}

	@AfterMethod
	public void testDown() {

		driver.quit();
	}
}
