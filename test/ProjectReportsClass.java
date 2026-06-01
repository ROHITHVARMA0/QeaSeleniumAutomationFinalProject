package com.cognizant.QEA25QE028.Selenium.TestNG.ProjectNew;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ProjectReportsClass {
	
	
	public static ExtentReports reports;
	public static ExtentTest test;
	
	
	public static void createAReport() {
		reports = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("projectResourcesOutputs/reportProjectEventListener.html");
		reports.attachReporter(spark);
	}
	
	public static void createTest(String name) {
		test = reports.createTest(name);
	}
	
	public static void endReport() {
		reports.flush();
	}
	
	
	
	
	
}