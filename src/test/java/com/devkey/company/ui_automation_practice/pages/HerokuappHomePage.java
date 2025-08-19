package com.devkey.company.ui_automation_practice.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.devkey.company.ui_automation_practice.base.BaseClass;
public class HerokuappHomePage {

	protected WebDriver driver; 
// Element	locators
	
	private By welcomeMessageBy = By.xpath("//h1[@class='heading']");
	private By addRemoveElementBy = By.cssSelector("#content > ul > li:nth-child(2) > a");
	
	
	//Constructors



	public HerokuappHomePage(WebDriver driver)
	{
		this.driver = driver;
		
		
	}
	
	
	//Actions
	
	public String getHeading()
	{
		
		return (driver.findElement(welcomeMessageBy)).getText();
	}
	public String getTitle() throws InterruptedException
	{
		Thread.sleep(3000);
		return driver.getTitle();
		
	}
	
	public void clickLink()
	{
			driver.findElement(addRemoveElementBy).click();
			
	}
	
	
	
	
	
	
	
	
	
	
}
