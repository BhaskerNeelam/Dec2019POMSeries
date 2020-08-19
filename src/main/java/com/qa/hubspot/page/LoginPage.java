package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Credentials;
import com.qa.hubspot.util.ElementUtil;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementutil;
	// every page will have by locators
	
	// page actions means methods
	//mitsip25@gmail.com
	
	//TestTest@123

	
	// 1. By locators
	// once the locators are defined we have to initial with WebDriver
	// so we have to create webdriver reference and then create the constructor of LoginPage with driver refrence so that it asks the driver
	// in base page we will initial the driver and properties
	
	// it is not good practice to use driver in page library so we have to create separate element util and use it in the page classes
	
	// martin flower page object model // creator of the POM most of the design patterns
	
	// simon stewart the founder of selenium 
	
	// we should not use drivers api in the test class i.e driver. findlemet etc
	// we should not write any assertions in page class
	
	By emailID = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.partialLinkText("Sign up");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
	}
	// page actions
	
	public String getPageTitle() {
		return elementutil.doGetPageTitle();
	}
	
	public boolean checkSignUpLink() {
		return elementutil.doIsDisplayed(signUpLink);
		
	}
	
	public HomePage doLogin(Credentials userCred) {
		elementutil.doSendKeys(emailID, userCred.getAppUserName());
		elementutil.doSendKeys(password, userCred.getAppPassword());
		elementutil.doClick(loginButton);
		/*elementutil.getElement(emailID).se
	driver.findElement(password).sendKeys(pwd);
	driver.findElement(loginButton).click();*/
	return new HomePage(driver);
	
	}
}
