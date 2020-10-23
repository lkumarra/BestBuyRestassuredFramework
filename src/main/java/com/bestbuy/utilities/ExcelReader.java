package com.bestbuy.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;


public class ExcelReader {

	private  HSSFWorkbook workbook;
	private File file;
	private FileInputStream fileInputStream;
	private HSSFSheet sheet;
	
	public ExcelReader(String excelPath) {
		 file = new File(excelPath);
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = new HSSFWorkbook(fileInputStream);
		} catch (IOException e) {
		}
	}

	public Object[][] getExcelData(String sheetName){
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		Row keysRow = sheet.getRow(sheet.getFirstRowNum());
		Object[][] data = new Object[rowCount][1];
		int dataIterator = 0;
		for (int i = 1; i < rowCount + 1; i++) {
			Row row = sheet.getRow(i); 
			Hashtable<String, String> hashtable = new Hashtable<String, String>();
			for (int column = 0; column < row.getLastCellNum(); column++) {
				String key =  keysRow.getCell(column).toString();
				String value = row.getCell(column).toString();
				hashtable.put(key, value);
			}
			data[dataIterator][0] = hashtable;
			dataIterator++;
		}
		return data;
	}

}
