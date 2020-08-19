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

public class LoginPageTest {
	// this will be our testng class
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPage loginPage;
	Credentials userCred;
	@BeforeTest
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.init_properties();
		String browserName =	prop.getProperty("browser");
		driver =basepage.init_driver(browserName);
		driver.get(prop.getProperty("url"));

		loginPage = new  LoginPage(driver);
		userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)

	public void verifyLoginPageTitleTest() throws InterruptedException {
		Thread.sleep(5000);
		String title =	loginPage.getPageTitle();
		System.out.println("login page title is " + title);

		Assert.assertEquals(title, "HubSpot Login");
	}
	@Test(priority=2)
	public void verifySignUpLink() {
		Assert.assertTrue(loginPage.checkSignUpLink());
	}

	@Test(priority=3)

	public void loginTest() {
		HomePage	homepage =loginPage.doLogin(userCred);
		String accountHolderName =	homepage.getLoggedInUserAccountName();

		Assert.assertEquals(accountHolderName, "oracle");

	}
	@AfterTest

	public void tearDown() {
		driver.quit();
	}

}
