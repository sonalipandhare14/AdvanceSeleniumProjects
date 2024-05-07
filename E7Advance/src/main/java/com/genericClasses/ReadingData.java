package com.genericClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadingData extends BaseClass {
	
	public String fetchProperty(String key) {
		Properties properties=new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(PROPERTYFILE_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value =properties.getProperty(key);
		return value;
	}
	
	public String fetchDataFromExcel(String sheet, int rowNum, int cellNum)  {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(EXCEL_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String data=workbook.getSheet(sheet).getRow(rowNum).getCell(cellNum).toString();
		return data;
	}
	
	public int getNumberofRows(String sheet) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./test-resources/DWSData.xslx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int data=workbook.getSheet(sheet).getPhysicalNumberOfRows();
		return data;
	}
	
	public int getNumberofCells(String sheet) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./test-resources/DWSData.xslx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int data=workbook.getSheet(sheet).getRow(0).getPhysicalNumberOfCells();
		return data;
	}
	
	@DataProvider(name = "dataReader")
	public String[][] dataProvider()  {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(EXCEL_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(prop.fetchProperty("sheet"));
		int rowCount=sheet.getPhysicalNumberOfRows()-1;
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] arr=new String[rowCount][cellCount];
	    //adding datas to the array
		for(int i=0;i<rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				arr[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return arr;
	}

}
