package com.cognizant.QEA0250QE28.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    // 1. Define the key and path constants
    private final static String configFilePath = "C:\\Users\\2440837\\eclipse-workspace\\HackathonProject\\resources\\config\\config.properties";

    // 2. Define all property keys in a clean block
    private final static String webPageUrl = "baseURL";
    private final static String readData = "excelReadFilePath";
    private final static String carWashServFilePath = "excelWriteCarWashingServicesFilePath";
    private final static String screnShotFilePath = "screenShotFilePath";
    private final static String gymsFilePath = "excelWriteGymsFilePath";
    private final static String gymsWithoutPhNumFilePath = "excelWriteGymsWithoutPhNumFilePath";
    private final static String reportsHtmlFilePath = "reportsHtmlFilePath";


    // --- Core Reusable Method ---
    
    /**
     * Private helper method to load the config file and retrieve a specific property value.
     * @param propertyKey The key of the property to retrieve.
     * @return The value of the property.
     * @throws RuntimeException if the file cannot be loaded or the key is not found/empty.
     */
    private static String getProperty(String propertyKey) {
        Properties props = new Properties();
        String propertyValue = null;

        // Use try-with-resources to ensure the FileInputStream is closed
        try (FileInputStream fis = new FileInputStream(configFilePath)) {
            props.load(fis);
            propertyValue = props.getProperty(propertyKey);
            
            // Validate that the key was found and has a value
            if (propertyValue == null || propertyValue.trim().isEmpty()) {
                throw new IllegalArgumentException("Configuration key '" + propertyKey + "' is missing or empty.");
            }
            
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Configuration file not found at: " + configFilePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading configuration file: " + e.getMessage(), e);
        } catch (Exception e) {
            // Re-throw any other error wrapped in a RuntimeException for consistent failure handling
            throw new RuntimeException("Test initialization failed: " + e.getMessage(), e);
        }

        return propertyValue;
    }
    
    // --- Public Getter Methods (Simplified) ---

    public static String getBaseURL() {
        return getProperty(webPageUrl);
    }
    
    public static String getExcelReadFilePath() {
        return getProperty(readData);
    }
    
    public static String getExcelWriteCarWashServFilePath() {
        return getProperty(carWashServFilePath);
    }
    
    public static String getScreenShotFilePath() {
        return getProperty(screnShotFilePath);
    }
    
    public static String getGymsFilePath() {
        return getProperty(gymsFilePath);
    }
    
    public static String getGymsWithoutPhNumFilePath() {
        return getProperty(gymsWithoutPhNumFilePath);
    }
    
    public static String getReportsFilePath() {
        return getProperty(reportsHtmlFilePath);
    }
}





















//package com.cognizant.QEA0250QE28.Utilities;
//
//
//import java.io.FileInputStream;
//import java.util.Properties;
//
//public class ConfigLoader {
//
//    // Define the key and path constants
//    private final static String CONFIG_FILE_PATH = "C:\\Users\\2440837\\eclipse-workspace\\HackathonProject\\resources\\config\\config.properties";
//    private final static String URL_KEY = "baseURL";
//    private final static String readData = "excelReadFilePath";
//    private final static String carWashServFilePath="excelWriteCarWashingServicesFilePath";
//    private final static String screnShotFilePath = "screenShotFilePath";
//    private final static String gymsFilePath = "excelWriteGymsFilePath";
//    private final static String gymsWithoutPhNumFilePath = "excelWriteGymsWithoutPhNumFilePath";
//    private final static String reportsHtmlFilePath = "reportsHtmlFilePath";
//
//    public static String getBaseURL() {
//        Properties props = new Properties();
//        String url = null;
//
//        // Use try-with-resources to ensure the FileInputStream is closed
//        try (FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)) {
//            props.load(fis);
//            url = props.getProperty(URL_KEY);
//            
//            // Validate that the key was found and has a value
//            if (url == null || url.trim().isEmpty()) {
//                throw new IllegalArgumentException("Configuration key '" + URL_KEY + "' is missing or empty.");
//            }
//            
//        } catch (Exception e) {
//            // Re-throw the validation error wrapped in a RuntimeException
//            throw new RuntimeException("Test initialization failed: " + e.getMessage(), e);
//        }
//
//        return url;
//    }
//    
//    
//    public static String getExcelReadFilePath() {
//        Properties props = new Properties();
//        String readDataFilePath = null;
//
//        // Use try-with-resources to ensure the FileInputStream is closed
//        try (FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)) {
//            props.load(fis);
//            readDataFilePath = props.getProperty(readData);
//            
//            // Validate that the key was found and has a value
//            if (readDataFilePath == null || readDataFilePath.trim().isEmpty()) {
//                throw new IllegalArgumentException("Configuration key '" + readData + "' is missing or empty.");
//            }
//            
//        } catch (Exception e) {
//            // Re-throw the validation error wrapped in a RuntimeException
//            throw new RuntimeException("Test initialization failed: " + e.getMessage(), e);
//        }
//
//        return readDataFilePath;
//    }
//    
//    
//    public static String getExcelWriteCarWashServFilePath() {
//        Properties props = new Properties();
//        String carFilePath = null;
//
//        // Use try-with-resources to ensure the FileInputStream is closed
//        try (FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)) {
//            props.load(fis);
//            carFilePath = props.getProperty(carWashServFilePath);
//            
//            // Validate that the key was found and has a value
//            if (carFilePath == null || carFilePath.trim().isEmpty()) {
//                throw new IllegalArgumentException("Configuration key '" + carWashServFilePath + "' is missing or empty.");
//            }
//            
//        } catch (Exception e) {
//            // Re-throw the validation error wrapped in a RuntimeException
//            throw new RuntimeException("Test initialization failed: " + e.getMessage(), e);
//        }
//
//        return carFilePath;
//    }
//    
//    
//    public static String getScreenShotFilePath() {
//        Properties props = new Properties();
//        String screenshotPath = null;
//
//        // Use try-with-resources to ensure the FileInputStream is closed
//        try (FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)) {
//            props.load(fis);
//            screenshotPath = props.getProperty(screnShotFilePath);
//            
//            // Validate that the key was found and has a value
//            if (screenshotPath == null || screenshotPath.trim().isEmpty()) {
//                throw new IllegalArgumentException("Configuration key '" + screnShotFilePath + "' is missing or empty.");
//            }
//            
//        } catch (Exception e) {
//            // Re-throw the validation error wrapped in a RuntimeException
//            throw new RuntimeException("Test initialization failed: " + e.getMessage(), e);
//        }
//
//        return screenshotPath;
//    }
//    
//    
//    
//    
//    public static String getGymsFilePath() {
//        Properties props = new Properties();
//        String gymsDataFilePath = null;
//
//        // Use try-with-resources to ensure the FileInputStream is closed
//        try (FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)) {
//            props.load(fis);
//            gymsDataFilePath = props.getProperty(gymsFilePath);
//            
//            // Validate that the key was found and has a value
//            if (gymsDataFilePath == null || gymsDataFilePath.trim().isEmpty()) {
//                throw new IllegalArgumentException("Configuration key '" + gymsFilePath + "' is missing or empty.");
//            }
//            
//        } catch (Exception e) {
//            // Re-throw the validation error wrapped in a RuntimeException
//            throw new RuntimeException("Test initialization failed: " + e.getMessage(), e);
//        }
//
//        return gymsDataFilePath;
//    }
//    
//    
//    public static String getGymsWithoutPhNumFilePath() {
//        Properties props = new Properties();
//        String gymsWithOutPhNumDataFilePath = null;
//
//        // Use try-with-resources to ensure the FileInputStream is closed
//        try (FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)) {
//            props.load(fis);
//            gymsWithOutPhNumDataFilePath = props.getProperty(gymsWithoutPhNumFilePath);
//            
//            // Validate that the key was found and has a value
//            if (gymsWithOutPhNumDataFilePath == null || gymsWithOutPhNumDataFilePath.trim().isEmpty()) {
//                throw new IllegalArgumentException("Configuration key '" + gymsWithoutPhNumFilePath + "' is missing or empty.");
//            }
//            
//        } catch (Exception e) {
//            // Re-throw the validation error wrapped in a RuntimeException
//            throw new RuntimeException("Test initialization failed: " + e.getMessage(), e);
//        }
//
//        return gymsWithOutPhNumDataFilePath;
//    }
//    
//    
//    public static String getReportsFilePath() {
//        Properties props = new Properties();
//        String reportsPath = null;
//
//        // Use try-with-resources to ensure the FileInputStream is closed
//        try (FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)) {
//            props.load(fis);
//            reportsPath = props.getProperty(reportsHtmlFilePath);
//            
//            // Validate that the key was found and has a value
//            if (reportsPath == null || reportsPath.trim().isEmpty()) {
//                throw new IllegalArgumentException("Configuration key '" + reportsHtmlFilePath + "' is missing or empty.");
//            }
//            
//        } catch (Exception e) {
//            // Re-throw the validation error wrapped in a RuntimeException
//            throw new RuntimeException("Test initialization failed: " + e.getMessage(), e);
//        }
//
//        return reportsPath;
//    }
//    
//    
//    
//    
//    
//}