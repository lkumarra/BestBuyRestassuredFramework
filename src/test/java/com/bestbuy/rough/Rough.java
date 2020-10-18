package com.bestbuy.rough;

import java.io.IOException;

import org.json.JSONObject;

import com.bestbuy.categoriespojo.CategoriesResponse;
import com.bestbuy.constants.BestBuyConstants;
import com.bestbuy.paylods.CategoriesPayload;
import com.bestbuy.paylods.ProductPayload;
import com.bestbuy.paylods.ServicesPayload;
import com.bestbuy.paylods.StoresPayload;
import com.bestbuy.productpojo.Categories;
import com.bestbuy.productpojo.ProductResponse;
import com.bestbuy.storespojo.StoresResponse;
import com.bestbuy.utilities.JsonMapper;
import com.bestbuy.utilities.Utilities;
import com.besybuy.servicespojo.ServicesResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class Rough {

	public static void main(String[] args) {

		Utilities util = new Utilities();

		// Response res =
		// util.getRequestResponse(BestBuyConstants.ProductApiEndPoint.getResource(),
		// "id", "127687");
//		StoresPayload payload = new StoresPayload("Apple Store", "Electronics", "Dhampur", "Bijnor", "Bijnor",
//				"Uttar Pradesh", "246761", 120, 124, "24", "Electronics", "Repair");
//		
//		CategoriesPayload cpayLoad = new CategoriesPayload("Electronics", "875596");
//		ServicesPayload spayload = new ServicesPayload("Electronic");
//		util.getPostRequestResponse(BestBuyConstants.StoresApiEndPoint.getResource(), payload.getStoresJsonPayload()).prettyPrint();
//		util.getPostRequestResponse(BestBuyConstants.CategoriesApiEndPoint.getResource(), cpayLoad.getCategoriesJsonPayload()).prettyPrint();
//		util.getPostRequestResponse(BestBuyConstants.ServiceApiEndPoint.getResource(), spayload.getServicesJsonPayload()).prettyPrint();
	
		Response response = util.getRequestResponse(BestBuyConstants.ProductApiEndPoint.getResource());
		JsonMapper mapper = new JsonMapper();
		ProductResponse presponse = mapper.getMappedResponse(response, ProductResponse.class);
		System.out.println(presponse.getData()[0].getName());
		
		Response storesResponse = util.getRequestResponse(BestBuyConstants.StoresApiEndPoint.getResource());
		StoresResponse sresponse = mapper.getMappedResponse(storesResponse, StoresResponse.class);
		System.out.println(sresponse.getLimit());
		
		Response servicesResponse = util.getRequestResponse(BestBuyConstants.ServiceApiEndPoint.getResource());
		ServicesResponse sresponse1 = mapper.getMappedResponse(servicesResponse, ServicesResponse.class);
		System.out.println(sresponse1.getLimit());
		
		Response categoriesResponse = util.getRequestResponse(BestBuyConstants.CategoriesApiEndPoint.getResource());
		CategoriesResponse cresponse = mapper.getMappedResponse(categoriesResponse, CategoriesResponse.class);
		System.out.println(cresponse.getLimit());
	}
;
}
