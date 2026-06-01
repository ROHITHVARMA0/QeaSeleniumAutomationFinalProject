package com.cognizant.QEA25QE028.Selenium.TestNG.ProjectNew.WebElements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteIntoExcelFile {
	
	
	
	public static void carWashingDataIntoExcel(List<String> storeNamesText , List<String> phoneNumbersText) throws IOException {
		
		FileOutputStream writeIntoExcelSheet = new FileOutputStream(System.getProperty("user.dir")+"\\projectResourcesOutputs\\IdentifyCarWashingServices.xlsx");
 		
 		XSSFWorkbook workBook = new XSSFWorkbook();
 		
 		XSSFSheet sheet = workBook.createSheet();
 		
 		int rowsSize = 5;
 		
 		int columnsSize = 3;
 		
 		int rowCount = 1;
 		
 		for ( int i = 0 ; i < rowsSize+1 ; i++ ) {
 			
 			XSSFRow currentRow = sheet.createRow(i);
 			
 			for ( int j = 0 ; j < columnsSize ; j++ ) {
 				
 				XSSFCell currentCell = currentRow.createCell(j);
 				
 				if (i == 0) { 
 	                currentRow.createCell(0).setCellValue("Serial Number");
 	                currentRow.createCell(1).setCellValue("Car Washing Service Store Name");
 	                currentRow.createCell(2).setCellValue("Car Washing Service Store Phone Number");
 	            }
 				
 				else if( j == 0 ) {
 					currentCell.setCellValue(rowCount);
 					rowCount++;
 				}
 				
 				else if( j == 1 ) {
 					currentCell.setCellValue(storeNamesText.get(i));
 				}
 				else if ( j == 2 ) {
 					currentCell.setCellValue(phoneNumbersText.get(i));
 				}
 				
 			}
 		}
 		
 		workBook.write(writeIntoExcelSheet);
 		workBook.close();
 		writeIntoExcelSheet.close();
 		
	}
	
	
	public static void gymsDataIntoExcel( List<String> gymNamesText , List<String> gymPhoneNumbersText ) throws IOException {
		
		
		FileOutputStream writeIntoExcelSheet = new FileOutputStream(System.getProperty("user.dir")+"\\projectResourcesOutputs\\GymsData.xlsx");
 		
 		XSSFWorkbook workBook = new XSSFWorkbook();
 		
 		XSSFSheet sheet = workBook.createSheet();
 		
 		int rowsSize = gymNamesText.size();
 		
 		int columnsSize = 3;
 		
 		int rowCount = 1;
 		
 	//	int gymNamesSize = gymNamesText.size();
 		
 		for ( int i = 0 ; i < rowsSize ; i++ ) {
 			
 			XSSFRow currentRow = sheet.createRow(i);
 			
 			for ( int j = 0 ; j < columnsSize ; j++ ) {
 				
 				XSSFCell currentCell = currentRow.createCell(j);
 				
 				if (i == 0) { 
 	                currentRow.createCell(0).setCellValue("Serial Number");
 	                currentRow.createCell(1).setCellValue("Gym Name");
 	                currentRow.createCell(2).setCellValue("Gym Phone Number");
 	            }
 				else if( i != 0 ) {
	 				if( j == 0 ) {
	 					currentCell.setCellValue(rowCount);
	 					rowCount++;
	 				}
	 				
	 				
	 				else if( j == 1 ) {
		 				currentCell.setCellValue(gymNamesText.get(i));
		 			}
		 			
	 				else if ( j == 2 ) {
		 				currentCell.setCellValue(gymPhoneNumbersText.get(i));
		 			}
 				}
 				
 			}
 		}
 		
 		workBook.write(writeIntoExcelSheet);
 		workBook.close();
 		writeIntoExcelSheet.close();
		
		
	}
	
	
	public static void gymsDataWithOutPhNumIntoExcel( List<String> gymNamesTextWithoutPhno , List<String> gymPhoneNumbersTextWithoutPhNo ) throws IOException {
		
		
		FileOutputStream writeIntoExcelSheet = new FileOutputStream(System.getProperty("user.dir")+"\\projectResourcesOutputs\\GymsDataWithOutPhNum.xlsx");
 		
 		XSSFWorkbook workBook = new XSSFWorkbook();
 		
 		XSSFSheet sheet = workBook.createSheet();
 		
 		int rowsSize = gymNamesTextWithoutPhno.size();
 		
 		int columnsSize = 3;
 		
 		int rowCount = 1;
 		
 		//int gymNamesSize = gymNamesText.size();
 		
 		for ( int i = 0 ; i < rowsSize ; i++ ) {
 			
 			XSSFRow currentRow = sheet.createRow(i);
 			
 			for ( int j = 0 ; j < columnsSize ; j++ ) {
 				
 				XSSFCell currentCell = currentRow.createCell(j);
 				
 				if (i == 0) { 
 	                currentRow.createCell(0).setCellValue("Serial Number");
 	                currentRow.createCell(1).setCellValue("Gym Name");
 	                currentRow.createCell(2).setCellValue("Gym Phone Number");
 	            }
 				
 				else if ( i != 0 ) {
 				
	 				if( j == 0 ) {
	 					currentCell.setCellValue(rowCount);
	 					rowCount++;
	 				}
	 				
	 				
		 			if( j == 1 ) {
		 				currentCell.setCellValue(gymNamesTextWithoutPhno.get(i));
		 			}
		 			
		 			if ( j == 2 ) {
		 				currentCell.setCellValue(gymPhoneNumbersTextWithoutPhNo.get(i));
		 			}
		 			
 				}
 				
 			}
 		}
 		
 		workBook.write(writeIntoExcelSheet);
 		workBook.close();
 		writeIntoExcelSheet.close();
		
		
	}
	
	
	
}