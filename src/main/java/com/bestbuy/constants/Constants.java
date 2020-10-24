package com.bestbuy.constants;

import java.util.Date;

public class Constants {
	
	private static final String DATE = new Date().toString().replace(" ", "_").replace(":", "_");
	private static final String CURRDIR = System.getProperty("user.dir");
	public static final String EXCEL_PATH = CURRDIR+"\\src\\test\\resources\\TestData\\BestBuyApiDate.xls";
	public static final String EXTENT_REPORT_PATH = CURRDIR+"\\src\\test\\resources\\TestReports\\BestBuyAPIReport.html";
	public static final String OLD_REPORT_PATH = CURRDIR+"\\src\\test\\resources\\OldTestReports"+"\\BestBuyAPIReport"+DATE+".html";
	public static final String REQ_LOG_PATH =CURRDIR+"\\src\\test\\resources\\ReqResLogs\\RequestLogs.txt";
	public static final String RES_LOG_PATH = CURRDIR+"\\src\\test\\resources\\ReqResLogs\\ResponseLogs.txt";
	public static final String OLDREQ_LOG_PATH = CURRDIR+"\\src\\test\\resources\\OldReqResLogs\\RequestLogs"+DATE+".txt";
	public static final String OLDRES_LOG_PATH = CURRDIR+"\\src\\test\\resources\\OldReqResLogs\\ResponseLogs"+DATE+".txt";
	public static final String ARTIFACTS_PATH  = CURRDIR+"\\src\\test\\resources\\ExecutionArtifacts"+"\\TestArtifacts"+DATE+".zip";
	public static final String PRODUCT_POST_SHEET = "ProductPost";
	public static final String CATEGORIES_POST_SHEET = "CategoriesPost";
	public static final String STORES_POST_SHEET = "StoresPost";
	public static final String SERVICE_POST_SHEET = "ServicesPost";
	public static final String PRODUCT_GET_DATA_SHEET = "ProductGetData";
	public static final String PRODUCT_GET_CATEGORIES_SHEET = "ProductGetCategories";
	
	
}
