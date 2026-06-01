package com.cognizant.QEA25QE028.Selenium.EventListenersAndReports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		
				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

				String reportFileName = "TestReport_" + timeStamp + ".html"; 

				String targetDirPath = ConfigLoader.getReportsFilePath(); 

				File reportFile = new File(targetDirPath, reportFileName);
				
		        String uniqueReportPath = reportFile.getAbsolutePath();

				System.out.println("Report file path generated: " + uniqueReportPath);
				
				reports = new ExtentReports();
				
				spark = new ExtentSparkReporter(uniqueReportPath); 
				
				spark.config().setTheme(Theme.DARK);
				
				spark.config().setDocumentTitle("Test Execution Report - " + timeStamp);
				
				reports.attachReporter(spark);
		
		

	}
	
	public static void createTest(String name) {
		test = reports.createTest(name);
	}
	
	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test case success is "+result.getName());
	}
	
	
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test case failed is "+result.getName());
		test.log(Status.FAIL, "Test case failed is "+result.getThrowable());
	}
	
	
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test case skipped is "+result.getName());
	}
	
	
	public static void endReport() {
		reports.flush();
	}
	
	
	
	
	
}