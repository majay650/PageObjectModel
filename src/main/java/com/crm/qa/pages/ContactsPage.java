package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	// define webelements and methods of contacts page here
	@FindBy(xpath = "//td[contains(text(), 'Contacts')]")
	WebElement contactsLabel;

	@FindBy(xpath = "//input[@value='52388340']")
	WebElement usernameCheckbox;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;

	@FindBy(name = "client_lookup")
	WebElement company;

	@FindBy(xpath = "//input[@class='button'][@value='Save']")
	WebElement saveBtn;

	// initiLIZE THE PAGE FACTORY ELEMENTS
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	// methods or actions to be performed on login page

	public boolean verifyContactsLabel() {

		return contactsLabel.isDisplayed();
	}

	public void clickUsernameCheckbox() {
		usernameCheckbox.click();
	}

	public void createNewContact(String title, String ftName, String ltName, String comp) {
		Select select = new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();

	}

}
