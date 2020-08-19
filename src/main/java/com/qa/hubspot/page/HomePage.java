package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends BasePage{
	WebDriver driver;
	ElementUtil elementutil;
	By header = By.xpath("//span//h1[text()='Sales dashboard']");
	By accountName = By.cssSelector("span.account-name" );

	public HomePage(WebDriver driver) {
		this.driver= driver;
		elementutil = new ElementUtil(driver);
	}

	public String getHomePageTitle() {
		return elementutil.doGetPageTitle();
	}
	public String getHomePageHeader() {
		return elementutil.doGetText(header);
	}

	public String  getLoggedInUserAccountName() {
		return elementutil.doGetText(accountName);
	}
}
