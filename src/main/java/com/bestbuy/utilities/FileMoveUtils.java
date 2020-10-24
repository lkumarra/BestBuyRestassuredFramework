package com.bestbuy.utilities;

import java.io.File;

import com.bestbuy.constants.Constants;

public class FileMoveUtils {
	
	public static void moveReport() {
		File extentReport = new File(Constants.EXTENT_REPORT_PATH);
		File oldExtentReport = new File(Constants.OLD_REPORT_PATH);
		extentReport.renameTo(oldExtentReport);
	}
	
	public static void moveLogsFile() {
		File reqLogs = new File(Constants.REQ_LOG_PATH);
		File oldReqLogs = new File(Constants.OLDREQ_LOG_PATH);
		reqLogs.renameTo(oldReqLogs);
		File resLogs = new File(Constants.RES_LOG_PATH);
		File oldResLogs = new File(Constants.OLDRES_LOG_PATH);
		resLogs.renameTo(oldResLogs);
	}
	
}
