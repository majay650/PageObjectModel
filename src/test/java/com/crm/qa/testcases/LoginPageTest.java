package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	// create class variable loginPage so that we can access its methods
	LoginPage loginPage;
	HomePage homePage;

	// call constructor of TestBase class as it contains initialization of
	// properties file required for driver initialization method
	
	public LoginPageTest() {
		super();
	}

	// method to call browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		// create object of loginpage class as we will be assessing methods created in
		// login page class
		 loginPage = new LoginPage();
	}

	// access methods of loginpage class
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}

	@Test(priority=2)
	public void crmLogoTest() {
		boolean flag = loginPage.verifyCRMLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority=3)
	// this method returns home page
	public void loginTest() throws Exception{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
