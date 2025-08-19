package com.devkey.company.ui_automation_practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddRemoveElement {

	protected WebDriver driver;
	
	
	// Locators
	
	private By pageHeadingBy = By.xpath("//*[@id=\"content\"]/h3");
	private By addElementButtonBy = By.cssSelector("#content > div > button");
	private By addedDeleteButtonBy = By.cssSelector("#elements");
	
	
	
	
	public AddRemoveElement(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String findPageHeading()
	{
		return driver.findElement(pageHeadingBy).getText();
	}
	
	public WebElement findAddButton(WebDriver driver)
	{
		return driver.findElement(addElementButtonBy);
	}
	
	public By findDeleteButton(WebDriver driver)
	{
		return addedDeleteButtonBy;
		
	}
	
}
