package com.cognizant.QEA0250QE28.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

	// The file path of config properties file is stored
	private final static String configFilePath = "C:\\Users\\2440837\\eclipse-workspace\\HackathonProject\\resources\\config\\config.properties";

	// The variables storing the file path in config properties are stored
	private final static String webPageUrl = "baseURL";
	private final static String readData = "excelReadFilePath";
	private final static String carWashServFilePath = "excelWriteCarWashingServicesFilePath";
	private final static String screnShotFilePath = "screenShotFilePath";
	private final static String gymsFilePath = "excelWriteGymsFilePath";
	private final static String gymsWithoutPhNumFilePath = "excelWriteGymsWithoutPhNumFilePath";
	private final static String reportsHtmlFilePath = "reportsHtmlFilePath";

	// Method used to retrieve the file path from the properties file with
	// respective key words
	private static String getProperty(String propertyKey) 
	{
		Properties props = new Properties();
		String propertyValue = null;

		try (FileInputStream fis = new FileInputStream(configFilePath)) 
		{
			props.load(fis);
			propertyValue = props.getProperty(propertyKey);

			// Validate that the key word was found and has a meaningful value
			if (propertyValue == null || propertyValue.trim().isEmpty()) 
			{
				throw new IllegalArgumentException("Configuration key '" + propertyKey + "' is missing or empty.");
			}

		} 
		catch (FileNotFoundException e) 
		{
			throw new RuntimeException("Configuration file not found at: " + configFilePath, e);
		} 
		catch (IOException e) 
		{
			throw new RuntimeException("Error reading configuration file: " + e.getMessage(), e);
		} 
		catch (Exception e) 
		{
			// Re-throw any other error wrapped in a RuntimeException for consistent failure handling
			throw new RuntimeException("Test initialization failed: " + e.getMessage(), e);
		}

		return propertyValue;
	}
	
	//Getting the base url which we have to load into the web browser to open the web page
	public static String getBaseURL() {
		return getProperty(webPageUrl);
	}
	
	//Getting the file path of the excel file from which we have to read data
	public static String getExcelReadFilePath() {
		return getProperty(readData);
	}
	
	//Getting the file path of the excel file in which we have to write the car washing services 
	public static String getExcelWriteCarWashServFilePath() {
		return getProperty(carWashServFilePath);
	}
	
	//Getting the file path of the screen shot where we have to save it
	public static String getScreenShotFilePath() {
		return getProperty(screnShotFilePath);
	}
	
	//Getting the file path of the excel file in which we have to save the gyms data
	public static String getGymsFilePath() {
		return getProperty(gymsFilePath);
	}
	
	//Getting the file path of the excel file in which we have to save the gyms data without phone number 
	public static String getGymsWithoutPhNumFilePath() {
		return getProperty(gymsWithoutPhNumFilePath);
	}
	
	//Getting the file path of reports file to store the reports
	public static String getReportsFilePath() {
		return getProperty(reportsHtmlFilePath);
	}
}



