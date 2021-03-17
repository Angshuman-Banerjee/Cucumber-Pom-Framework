package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	// read and understand ThreadLocal, below WebDriver is pass on as generic
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	/**
	 * method used to initialize threadlocal driver on the basis of given browser
	 * @param browser
	 * @return method returns tlDriver
	 */

	public WebDriver init_driver(String browser) {

		System.out.println("The browser selected for this run is: " + browser);

		// read about WebDriverManager
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}

		if (browser.equals("safari")) {

			tlDriver.set(new SafariDriver());

		} else {
			System.out.println(" Please pass on the correct browser " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}
	// may be 5 thread will call this method in parallel, hence used synchronized
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
