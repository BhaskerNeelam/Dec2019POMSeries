package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver; // we create the constructor so that we can call the actual driver when invoke the methods of these class
	}

	public String doGetPageTitle() {
		try {
			return driver.getTitle();
		}
		catch(Exception e) {
			System.out.println("some exception occured while getting the title");
		}
		return null;
	}
	// getting the element using By locator

	/**
	 * This  method is used to create the webelement on the basis of the locator
	 * @param locator
	 * @return element
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		}
		catch(Exception e) {
			System.out.println("some exception occured while creating the element");
		}
		return element;
	}

	public void doClick(By locator) {
		try {
			getElement(locator).click();
		}
		catch(Exception e) {
			System.out.println("some exception occured while clicking on element");
		}
	}

	public void doSendKeys(By locator,String value) {
		try {
			WebElement ele =getElement(locator);
			ele.clear();
			ele.sendKeys(value);
		}
		catch(Exception e) {
			System.out.println("some exception occured while entering  the value in the field");
		}
	}
	public boolean doIsDisplayed(By locator) {

		try {
			return getElement(locator).isDisplayed();

		}

		catch(Exception e) {
			System.out.println("element is not displayed");
		}
		return false;

	}

	public String doGetText(By locator) {
		try {
			return getElement(locator).getText();
		}
		catch(Exception e) {
			System.out.println("some exception occured while getting the text");
		}
		return null;
	}
}
