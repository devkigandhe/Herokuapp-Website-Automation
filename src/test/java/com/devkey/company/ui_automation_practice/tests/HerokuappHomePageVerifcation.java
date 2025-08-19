package com.devkey.company.ui_automation_practice.tests;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.devkey.company.ui_automation_practice.base.BaseClass;
import com.devkey.company.ui_automation_practice.pages.HerokuappHomePage;

public class HerokuappHomePageVerifcation extends BaseClass {

	private HerokuappHomePage herokuappHomePage;

	@BeforeMethod
	public void initPageObjects(Method method) {
		setup(method);
		herokuappHomePage = new HerokuappHomePage(driver);

	}

	@Test
	public void homePageTitleVerification() throws InterruptedException {
		String expectedTitle = "The Internet";

		String actualTitle = herokuappHomePage.getTitle();

		test.log(Status.INFO, "Step 2. Actual title retrieved. Comparing expected and actual titles");
		assertEquals(actualTitle, expectedTitle,"Expected and actual titles do not match. ");
		test.log(Status.PASS, "Expected and actual titles match.");

	}

	@Test
	public void homePageWelcomeMessageVerification() {

		String welcomeMessage = herokuappHomePage.getHeading();
		assertEquals("Welcome to the-internet", welcomeMessage,"Expected and Actual headings do not match. ");

	}
}
