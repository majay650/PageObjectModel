package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public HomePageTest() {

		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.veryfyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Title of home page not correct");
	}

	@Test(priority = 2)
	public void verifyCorrectUsernameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUsername(), "Correct username is not displayed on homepage");
	}

	@Test(priority = 3)
	public void clickContactsLink() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickContactsLink();

	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
