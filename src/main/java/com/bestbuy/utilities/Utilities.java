package com.bestbuy.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import com.bestbuy.constants.BestBuyConstants;
import com.bestbuy.constants.Constants;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class Utilities {
	
	static RequestSpecification req = null;
	static PrintStream requestlog = null;
	static PrintStream responselog = null;
	
	/**
	 * Insert the request logs to the RequestLogs.txt file
	 */
	private PrintStream printRequestLogs() {
		if(requestlog == null) {
		try {
			requestlog = new PrintStream(new FileOutputStream(Constants.REQ_LOG_PATH));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return requestlog;
		}
		return requestlog;
	}
	
	/**
	 * Insert the response logs to ResponseLogs.txt file.
	 */
	private PrintStream printResponseLogs() {
		if (responselog == null) {
		try {
			responselog = new PrintStream(new FileOutputStream(Constants.RES_LOG_PATH));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return responselog;
		}
		return responselog;
	}
	
	/**
	 * Return a request speacification without any query parameter
	 * @return Request Specification
	 */
	public RequestSpecification requestSpecification() {
		if(req == null) {
			req = new RequestSpecBuilder().setBaseUri(BestBuyConstants.BaseUri.getResource()).addFilter(RequestLoggingFilter.logRequestTo(this.printRequestLogs()))
					.addFilter(ResponseLoggingFilter.logResponseTo(this.printResponseLogs())).setContentType(ContentType.JSON).build();
		}
		return req;
	}
	
	/**
	 * Return a request speacification with query params.
	 * @return Request Specification
	 */
	public RequestSpecification requestSpecification(String queryName, String queryValue) {
		if(req == null) {
			req = new RequestSpecBuilder().setBaseUri(BestBuyConstants.BaseUri.getResource()).addQueryParam(queryName, queryValue).addFilter(RequestLoggingFilter.logRequestTo(this.printRequestLogs()))
					.addFilter(ResponseLoggingFilter.logResponseTo(this.printResponseLogs())).setContentType(ContentType.JSON).build();
		}
		return req;
	}
	
	/**
	 * Return the response of get request.
	 * @param endPoint
	 * @param queryName
	 * @param queryValue
	 * @return
	 */
	public Response getRequestResponse(String endPoint, String queryName, String queryValue) {
		Response res = given().spec(this.requestSpecification(queryName, queryValue)).get(endPoint);
		return res;
	}
	
	/**
	 * Return the response of get request
	 * @param endPoint
	 * @return
	 */
	public Response getRequestResponse(String endPoint) {
		Response res = given().spec(this.requestSpecification()).get(endPoint);
		return res;
	}
	
	/**
	 * 
	 * @param endPoint
	 * @param object
	 * @return
	 */
	public Response getPostRequestResponse(String endPoint, String object) {
		Response res = given().spec(this.requestSpecification()).body(object).post(endPoint);
		return res;
	}
	
	/**
	 * 
	 * @param endPoint
	 * @param fileInputStream
	 * @return
	 */
	public Response getPostRequestResponse(String endPoint, FileInputStream fileInputStream) {
		Response res = given().spec(this.requestSpecification()).body(fileInputStream).post(endPoint);
		return res;
	}
	
}
