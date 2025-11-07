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
		
		
				// 1. Generate a unique file name using a timestamp
				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

				// 2. Define the Report file name and extension
				String reportFileName = "TestReport_" + timeStamp + ".html"; 

				// 3. Define the target directory path using your configuration
				String targetDirPath = ConfigLoader.getReportsFilePath(); 

				// 4. Create the complete File object for the new report
				File reportFile = new File(targetDirPath, reportFileName);
				
				// Get the absolute path string to pass to ExtentSparkReporter
		        String uniqueReportPath = reportFile.getAbsolutePath();

				// 5. Confirmation log.
				System.out.println("Report file path generated: " + uniqueReportPath);
				
				reports = new ExtentReports();
				
				spark = new ExtentSparkReporter(uniqueReportPath); // <-- FIXED LINE
				
				spark.config().setTheme(Theme.DARK);
				
				spark.config().setDocumentTitle("Test Execution Report - " + timeStamp);
				
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


//// 1. Generate a unique file name using a timestamp
////This ensures each test execution creates a distinct report.
//String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//
//// 2. Define the Report file name and extension (e.g., .html for Extent or .log)
//String reportFileName = "TestReport_" + timeStamp + ".html"; 
//
//// 3. Define the target directory path using your configuration
////ConfigLoader.getReportFilePath() should return the base folder for reports
//String targetDirPath = ConfigLoader.getReportsFilePath(); 
//
//// 4. Create the complete File object for the new report
//File reportFile = new File(targetDirPath, reportFileName);
//
//
//
//// 5. You would typically use this 'reportFile' path to initialize your reporting tool.
////	    (e.g., ExtentReports.attachReporter(new ExtentHtmlReporter(reportFile.getAbsolutePath()));)
////	    We print the path for confirmation.
//System.out.println("Report file path generated: " + reportFile.getAbsolutePath());
//
//// Note: The actual content (steps, results) is written to this file 
//// by the reporting tool during the test execution.
//
//reports = new ExtentReports();
//
////ExtentSparkReporter spark = new ExtentSparkReporter("projectResourcesOutputs/reportProjectEventListener.html");
//
////ExtentSparkReporter spark = new ExtentSparkReporter(ConfigLoader.getReportsFilePath());
//
//spark = new ExtentSparkReporter(ConfigLoader.getReportsFilePath());
//
//spark.config().setTheme(Theme.DARK);
//
//reports.attachReporter(spark);