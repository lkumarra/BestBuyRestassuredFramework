package com.bestbuy.utilities;

import org.testng.annotations.DataProvider;

import com.bestbuy.constants.Constants;

public class BestBuyDataProvider {
	
	static ExcelReader excelReader = new ExcelReader(Constants.EXCEL_PATH);
	
	@DataProvider(name = "ProductPayloadData")
	public static Object[][] getProductPayloadData() {
		return excelReader.getExcelData(Constants.PRODUCT_POST_SHEET);
	}
	
	@DataProvider(name = "CategoriesPayloadData")
	public static Object[][] getCategoriePayloadData(){
		return excelReader.getExcelData(Constants.CATEGORIES_POST_SHEET);
	}
	
	@DataProvider(name = "StoresPayloadData")
	public static Object[][] getStoresPayloadData(){
		return excelReader.getExcelData(Constants.STORES_POST_SHEET);
	}
	
	@DataProvider(name = "ServicesPayloadData")
	public static Object[][] getServicesPayloadData(){
		return excelReader.getExcelData(Constants.SERVICE_POST_SHEET);
	}
	
	@DataProvider(name = "ProductGetData")
	public static Object[][] getProductApiData(){
		return excelReader.getExcelData(Constants.PRODUCT_GET_DATA_SHEET);
	}
}
