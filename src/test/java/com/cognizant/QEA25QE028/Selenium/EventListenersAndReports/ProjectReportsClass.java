package com.cognizant.QEA25QE028.Selenium.EventListenersAndReports;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cognizant.QEA0250QE28.Utilities.ConfigLoader;

public class ProjectReportsClass implements ITestListener {
	
	public static ExtentSparkReporter spark;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	ConfigLoader cfl = new ConfigLoader();
	
	
	public static void createAReport() {
		
		
		reports = new ExtentReports();
		
//		ExtentSparkReporter spark = new ExtentSparkReporter("projectResourcesOutputs/reportProjectEventListener.html");
		
//		ExtentSparkReporter spark = new ExtentSparkReporter(ConfigLoader.getReportsFilePath());
		
		spark = new ExtentSparkReporter(ConfigLoader.getReportsFilePath());
		
		spark.config().setTheme(Theme.DARK);
		
		reports.attachReporter(spark);
	}
	
	public static void createTest(String name) {
		test = reports.createTest(name);
	}
	
	
	public void onTestSuccess(ITestResult result) {
		//test = reports.createTest(result.getName());
		test.log(Status.PASS, "Test case success is "+result.getName());
	}
	
	
	public void onTestFailure(ITestResult result) {
		//test = reports.createTest(result.getName());
		test.log(Status.FAIL, "Test case failed is "+result.getName());
		test.log(Status.FAIL, "Test case failed is "+result.getThrowable());
	}
	
	
	public void onTestSkipped(ITestResult result) {
		//test = reports.createTest(result.getName());
		test.log(Status.SKIP, "Test case skipped is "+result.getName());
	}
	
	
	public static void endReport() {
		reports.flush();
	}
	
	
	
	
	
}