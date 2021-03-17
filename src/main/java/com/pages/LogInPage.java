package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

	private WebDriver driver;

	// 1. By locators or OR

	private By emailID = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");

	// 2. constructor of page class

	public LogInPage(WebDriver driver) {

		this.driver = driver;

	}

	// page actions : behavior of the page in forms of methods
	// as per best practice, should not write any assertion on the page class
	public String getLoginPageTitle() {
		return driver.getTitle();

	}

	public boolean isForgotPwdLinkExist() {

		return driver.findElement(forgotPwdLink).isDisplayed();

	}

	public void enterUserName(String username) {

		driver.findElement(emailID).sendKeys(username);

	}

	public void enterPassword(String passwrd) {

		driver.findElement(password).sendKeys(passwrd);

	}

	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}
	
	//writing a combined log in method to be re used in account page
	
	public AccoutPage doLgIn(String un, String pwd) {
		
		driver.findElement(emailID).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		
		//as per POM concept, it is the responsibility of this method to return object of Account page
		//as after clicking we are landing on Account Page i.e. next page
		
		return new AccoutPage(driver);
	}

}
