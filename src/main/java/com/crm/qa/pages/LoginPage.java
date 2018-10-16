package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.thread.ThreadUtil;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase  {
	
	
	//creating page repositories or webelements
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(linkText="Sign Up")
	WebElement signUpButton;
	
	@FindBy(xpath="//img[@alt='free crm logo']")
	WebElement crmLogo;
	
	//initialize the page elements
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//creating methods or actions to be performed on login page
	
	public String verifyLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean verifyCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login (String un, String pwd)throws Exception{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		//password.sendKeys(keys.ENTER);
		loginButton.click();
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(loginButton)).(keys.ENTER);
		return new HomePage();
	}
	

}
