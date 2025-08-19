package com.devkey.company.ui_automation_practice.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.devkey.company.ui_automation_practice.base.BaseClass;
import com.devkey.company.ui_automation_practice.pages.AddRemoveElement;
import com.devkey.company.ui_automation_practice.pages.HerokuappHomePage;
import com.devkey.company.ui_automation_practice.utils.Utility;

public class AddRemoveElementVerification extends BaseClass{
 
	private AddRemoveElement addRemoveElement;
	private HerokuappHomePage herokuappHomePage;
	private Utility utility;
	private String expectedpageHeading = "Add/Remove Elements";
	
	
	
	@BeforeMethod
	public void initialisation(Method method)
	{
		setup(method);
		herokuappHomePage = new HerokuappHomePage(driver);
		addRemoveElement = new AddRemoveElement(driver);
		utility = new Utility(driver);
		herokuappHomePage.clickLink();
		switchFocus();
	}
	
	
	@Test
	public void addRemovePageHeadingVerification()
	{
		
		String actualPageHeading = addRemoveElement.findPageHeading();
		assertEquals(actualPageHeading, expectedpageHeading);
		
	}
	
	@Test
	public void addElementVerification()
	{
		WebElement addButton = addRemoveElement.findAddButton(driver);
		addButton.click();
		By deleteButtonBy = addRemoveElement.findDeleteButton(driver);
		WebElement deleteButton = utility.WaitUtils(driver, deleteButtonBy);
		
		assertTrue(deleteButton.isDisplayed(),"Delete Button displayed on clicking Add Button");
		
	}
	
	
}
