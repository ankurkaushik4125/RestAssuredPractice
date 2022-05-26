package com.qa.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {

	void browser()
	{
	System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM FRAMEWORK\\chromedriver_win32\\chromedriver.exe");
	
	WebDriver driver  = new ChromeDriver();
	driver.get("https://www.google.com");
	}
	}
