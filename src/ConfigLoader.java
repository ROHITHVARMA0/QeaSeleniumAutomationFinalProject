package com.cognizant.QEA25QE028.Selenium.TestNG.ProjectNew.WebElements;


import java.io.FileInputStream;
import java.util.Properties;

public class ConfigLoader {

    // Define the key and path constants
    private final static String CONFIG_FILE_PATH = "C:/Users/2440837/eclipse-workspace/TestNG/resources/config/config.properties";
    private final static String URL_KEY = "baseURL";

    public static String getBaseURL() {
        Properties props = new Properties();
        String url = null;

        // Use try-with-resources to ensure the FileInputStream is closed
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)) {
            props.load(fis);
            url = props.getProperty(URL_KEY);
            
            // Validate that the key was found and has a value
            if (url == null || url.trim().isEmpty()) {
                throw new IllegalArgumentException("Configuration key '" + URL_KEY + "' is missing or empty.");
            }
            
        } catch (Exception e) {
            // Re-throw the validation error wrapped in a RuntimeException
            throw new RuntimeException("Test initialization failed: " + e.getMessage(), e);
        }

        return url;
    }
}