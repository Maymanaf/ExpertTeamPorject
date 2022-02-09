package com.expertteam.ImproveSW;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility {
	static WebDriver driver;
	static FileInputStream fileInput;
	static FileOutputStream fileOutput;
	static HSSFWorkbook workBook ;
	static HSSFSheet sheet;
	static HSSFRow row;
	static HSSFCell cell;
	// method to capture screenshot
	public static void captureScreenshot(WebDriver driver , String screenshotName)
	{
		try
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,new File("./Screenshots/"+ screenshotName+".png"));
			System.out.println("Screenshot taken");
		}
		catch (Exception e)
		{
			System.out.println("Exception while taking screenshot"+ e.getMessage());
		}
	}


	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	// select element of DropDown by text
	public static void doSelectDropDownByText(By locator , String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	// select element of DropDown by index
	public static void doSelectDropDownByIndex(By locator , int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	// select element of DropDown by value
	public static void doSelectDropDownByValue(By locator , String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}



//	// get the number of rows in excel file 
//	public static int getRowCount(String path, String sheetName) throws IOException { 
//		fileInput = new FileInputStream(path);
//		workBook=new HSSFWorkbook(fileInput);
//		sheet=workBook.getSheet(sheetName);
//		int rowCount = sheet.getLastRowNum();
//		workBook.close(); 
//		fileInput.close(); 
//		return rowCount; 
//	} 
//	// get the number of cells in excel file 
//	public static int getColCount(String path, String sheetName, int rowNum) throws IOException { 
//		fileInput = new FileInputStream(path); 
//		workBook=new HSSFWorkbook(fileInput);
//		sheet=workBook.getSheet(sheetName);
//		row =sheet.getRow(rowNum); int colCount =
//				row.getLastCellNum(); 
//		workBook.close(); 
//		return colCount; } 
//	// Get the data from excel
//	public static String getCellData(String path, String sheetName ,int rowNum, int colNum) throws IOException { 
//		fileInput = new FileInputStream(path); 
//		workBook=new HSSFWorkbook(fileInput);
//		sheet=workBook.getSheet(sheetName);
//		row =sheet.getRow(rowNum);
//		cell=row.getCell(rowNum); 
//		DataFormatter formatter = new DataFormatter();
//		String data; 
//		try { 
//			data= formatter.formatCellValue(cell); 
//		} 
//		catch (Exception e)
//		{
//			data = "";
//		} 
//		fileInput.close(); 
//		workBook.close(); 
//		return data; }
//
//	// Set the data in excel 
//	public void setCellData(String path, String sheetName , int rowNum, int colNum, String data) throws IOException {
//		fileInput = new FileInputStream(path); 
//		workBook=new HSSFWorkbook(fileInput);
//		sheet=workBook.getSheet(sheetName); 
//		row =sheet.getRow(rowNum);
//		cell=row.createCell(colNum); 
//		cell.setCellValue(data);
//
//		fileOutput = new FileOutputStream(path);
//		workBook.write(fileOutput);
//		workBook.close();
//		fileInput.close(); 
//		fileOutput.close(); 
//	}


}
