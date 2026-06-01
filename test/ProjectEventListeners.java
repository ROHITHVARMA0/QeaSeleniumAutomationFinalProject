package com.cognizant.QEA25QE028.Selenium.TestNG.ProjectNew;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

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
		WebDriver currentDriver = DriverSetUp.getDriver(); 

        // 2. ONLY proceed if the driver is not null
        if (currentDriver != null) {
            try {
                // The NullPointerException was here (ProjectEventListeners.java:38)
                TakesScreenshot screenShot = (TakesScreenshot) currentDriver;
                
             // 1. Get the temporary screenshot file (src)
                File src = screenShot.getScreenshotAs(OutputType.FILE);

                // 2. Define the target directory
                File targetDir = new File("C:\\Users\\2440837\\eclipse-workspace\\TestNG\\projectResourcesOutputs");

                // 3. Copy the file into the directory. It will use the original temp file name.
//                    (The destination file will be: ...\\projectResourcesOutputs\\temp_selenium_file.png)
                FileUtils.copyFileToDirectory(src, targetDir);
                
            } catch (Exception e) {
                System.err.println("Error taking screenshot: " + e.getMessage());
            }
        } else {
            System.err.println("Driver instance is null in listener, cannot take screenshot.");
        }
    }	
	
	
	@Override
	public void onFinish(ITestContext context) {
		ProjectReportsClass.endReport();
	}
	
	
}