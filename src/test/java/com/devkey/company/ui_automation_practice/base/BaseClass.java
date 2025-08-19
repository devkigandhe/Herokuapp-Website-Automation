package com.devkey.company.ui_automation_practice.base;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import java.time.Duration;
import java.util.Set;

import org.apache.commons.exec.OS;
import org.apache.hc.core5.http.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected WebDriver driver;
	protected ExtentReports extentReport;
	protected ExtentTest test;
	protected String url = "https://the-internet.herokuapp.com/";
	
	@BeforeSuite
	public void initialiseReporting()
	{
		ExtentSparkReporter spark = new ExtentSparkReporter("testoutput/extentReport.html");
		extentReport = new ExtentReports();
		
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Herokuapp Automation Tests Results");
		spark.config().setReportName("UI Automation Results");
		
		extentReport.attachReporter(spark);
		
		extentReport.setSystemInfo("Author and Tester", "Devki G");
		extentReport.setSystemInfo("Environment", "QA");
		extentReport.setSystemInfo("OS", System.getProperty("os.name"));
		
		
	}
	
	
	
	
	
	
	
	public void setup(java.lang.reflect.Method method) {
		
		System.out.println("In Setup Method");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		test = extentReport.createTest(method.getName());
		test.log(Status.INFO, "Opening the home page");
		try {
		driver.get(url);
		System.out.println("");
		String currentUrl =  driver.getCurrentUrl();
		
		if(currentUrl.equalsIgnoreCase(url))
		{
			test.log(Status.PASS, "Step 1.Open Home Page. Url:"+currentUrl);
		}
		}
		catch (Exception e)
		{
			test.log(Status.FAIL,"Step 1. Open Home Page. Error Message: " +e.getMessage());
			Assert.fail();
			driver.quit();
		}
		
		
		
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Overall Test Failed:"+result.getThrowable());
			
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Overall Test Pass");
		}
		else
		{
			test.log(Status.SKIP, "Test Case Not Executed" +result.getThrowable());
		}
		
		if(driver!=null)
			driver.quit();
	}
	
	public void switchFocus(){
		
		Set<String> windowHandles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		for(String handle : windowHandles)
		{
			if(!(handle.equals(currentHandle)))
			{
				driver.switchTo().window(handle);	
				
			}
		}
		
		
		
		
		
	}
	@AfterSuite
	public void closeExtentReport()
	{
		if(extentReport !=null)
			extentReport.flush();
		
	}
}
