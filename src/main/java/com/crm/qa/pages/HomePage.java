package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	// creating page factory/web elements for this page

	@FindBy(xpath = "//td[contains(text(), 'User: Ajay Thakur')]")
	WebElement usernameLabel;

	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath= "//a[contains(text(), 'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(), 'Tasks')]")
	WebElement tasksLink;

	// initialize page elements by creating constructor of home age

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String veryfyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUsername() {
		
	return usernameLabel.isDisplayed();	
		
	}

	public ContactsPage clickContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	
	public DealsPage clickDealsLink() {
		dealsLink.click();
		return new DealsPage();
		
	}
	
	public TasksPage clickTasksLink() {
		tasksLink.click();
		return new TasksPage();
		
	}
	
	public void clickNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
	
	
	
	
	
	
	
	
}
