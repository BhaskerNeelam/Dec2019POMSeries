package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.util.Credentials;

public class HomePageTest {

	// this will be our testng class
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPage loginPage;
	Credentials userCred;
	HomePage homepage;
	@BeforeTest
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.init_properties();
		String browserName =	prop.getProperty("browser");
		driver =basepage.init_driver(browserName);
		driver.get(prop.getProperty("url"));

		loginPage = new  LoginPage(driver);
		userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		homepage =	loginPage.doLogin(userCred);
		
	}

	@Test(priority=1)

	public void verifyHomePageTitleTest() {
		String title = homepage.getHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "HubSpot Login");
	}
	@Test(priority=2)

	public void verifyAccountHolder() {
		String accountHolderName =	homepage.getLoggedInUserAccountName();
		System.out.println(accountHolderName);
		Assert.assertEquals(accountHolderName, "oracle");
	}

	@Test(priority=2)

	public void verifyHomeHeader() {
		String header =	homepage.getHomePageHeader();
		System.out.println(header);
		Assert.assertEquals(header, "Sales dashboard");
	}
	@AfterTest

	public void tearDown() {
		driver.quit();
	}


}
