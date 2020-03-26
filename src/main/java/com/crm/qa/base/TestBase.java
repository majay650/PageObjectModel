package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	// public static WebDriverWait wait;

	// initialize the properties file containing username, url, password, browser
	//to test git
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fi = new FileInputStream(
					"D:\\training\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\com.properties");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	// initialize webdriver

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		// to read the webevent listsner craeted in util package firstly create object
		// of event firingwebdriver class
		e_driver = new EventFiringWebDriver(driver);

		// now create object of webeventlistener class createdin util package to
		// register it with eventfiringwebdriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		// driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		// wait = new WebDriverWait(driver, 30);

	}
}
