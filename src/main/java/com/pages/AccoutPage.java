package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccoutPage {

	private WebDriver driver;

	private By accountsection = By.cssSelector("div#center_column span");

	public AccoutPage(WebDriver driver) {

		this.driver = driver;

	}

	public int getAccountsectioncount() {

		return driver.findElements(accountsection).size();

	}
	
	public String getPageTitle() {
		
		return driver.getTitle();
	}

	public List<String> getAccountsectionText() {

		List<String> accountList = new ArrayList<>();

		List<WebElement> accountsectionList = driver.findElements(accountsection);

		for (WebElement e : accountsectionList) {

			String accountSectionName = e.getText();
			System.out.println(accountSectionName);
			accountList.add(accountSectionName);

		}

		return accountList;
	}

}
