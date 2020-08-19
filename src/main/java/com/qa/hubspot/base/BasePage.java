package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver; // driver reference
	Properties prop; // properties reference

	public WebDriver init_driver(String browserName) {
		System.out.println("browser name is " + browserName);
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		}

		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else
		{
			System.out.println("brower Name" +browserName+ "is not found, please pass the correct browser");
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		//driver.get(url);

		return driver;
	}
	public Properties init_properties() {
		// in order to initilize the properties first we need to create object of the Properties class


		prop = new Properties();

		String path ="src\\main\\java\\com\\qa\\hubspot\\config\\config.properties";
		try {
			FileInputStream ip = new FileInputStream(path); // will connect to the config file
			// next loading
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("some issue with config properties please correct it");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}
