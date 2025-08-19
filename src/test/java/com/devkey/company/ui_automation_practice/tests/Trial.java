package com.devkey.company.ui_automation_practice.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.devkey.company.ui_automation_practice.base.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Trial extends BaseClass {

	


	@Test
	public void testOpenPage() {
		driver.get("https://www.google.com/");
	}

}