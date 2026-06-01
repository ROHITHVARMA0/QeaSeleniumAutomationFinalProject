package com.cognizant.QEA25QE028.Selenium.EventListenersAndReports;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.cognizant.QEA25QE028.Selenium.TestNG.ProjectNew.DriverSetUp;

public class ProjectEventListeners implements ITestListener {
	
	
WebDriver driver;
	
	@Override
	public void onStart(ITestContext context) {
		ProjectReportsClass.createAReport();
	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
		ProjectReportsClass.createTest(result.getMethod().getMethodName());
	}
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ProjectReportsClass.test.log(Status.PASS, "This test pass");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		ProjectReportsClass.test.log(Status.FAIL, "This test has failed");
		
		WebDriver currentDriver = DriverSetUp.getDriver(); 

        if (currentDriver != null) {
            try {
                
                TakesScreenshot screenShot = (TakesScreenshot) currentDriver;
                
                
                File src = screenShot.getScreenshotAs(OutputType.FILE);


                File targetDir = new File("C:\\Users\\2440837\\eclipse-workspace\\HackathonProject\\test-output");

                
                FileUtils.copyFileToDirectory(src, targetDir);
                
            } catch (Exception e) {
                System.out.println("Error taking screenshot: " + e.getMessage());
            }
        } else {
            System.out.println("Driver instance is null in listener, cannot take screenshot.");
        }
    }	
	
	
	@Override
	public void onFinish(ITestContext context) {
		ProjectReportsClass.endReport();
	}
	
	
}