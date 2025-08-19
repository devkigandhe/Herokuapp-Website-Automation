package com.devkey.company.ui_automation_practice.utils;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	protected WebDriver driver;
	
	public Utility(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement WaitUtils(WebDriver driver, By button)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement newButton = wait.until(ExpectedConditions.visibilityOfElementLocated(button));
		
		return newButton;
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
