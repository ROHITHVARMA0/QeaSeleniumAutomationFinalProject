package com.cognizant.QEA0250QE28.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcelFile {
	

	public static String[] testReadExcelSheet() throws IOException {
		
		
		//Take excel sheet into file format
		FileInputStream excelSheetFile = new FileInputStream("C:\\Users\\2440837\\eclipse-workspace\\HackathonProject\\resources\\ProjectResourcesInput\\ProjectInputsExcelFile.xlsx");
		
		//After taking excel sheet to file format then make it to workbook
		XSSFWorkbook workBook = new XSSFWorkbook(excelSheetFile);
		
		//After changing excel to workbook then change it to sheet
//		XSSFSheet sheet = workBook.getSheet("Sheet1");
		XSSFSheet sheet = workBook.getSheetAt(0);
		
		//After getting the excel as sheet now get the rows and columns in the sheet
		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(1).getLastCellNum();
		
//		System.out.println("The rows length = "+rows);
//		System.out.println("The column length = "+columns);
		String[] input = new String[3];
		
		for ( int i = 0 ; i <= rows ; i++ ) {
			//Changing the rows into columns so that the next for loop can pass through the columns
			XSSFRow currentRowOfExcelSheet = sheet.getRow(i);
			for ( int j = 0 ; j< columns ; j++ ) {
				XSSFCell cell = currentRowOfExcelSheet.getCell(j);
				if ( i == 1 ) {
					long invalidNumber = (long) cell.getNumericCellValue();
					input[i] = String.valueOf(invalidNumber);
				}
				else {
				input[i]=cell.toString();
				}
			}
		}
		
		workBook.close();
		excelSheetFile.close();
		
		
		return input;
	}
	
	
	
	
	
}