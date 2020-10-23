package com.bestby.productapitest;

import static org.testng.Assert.assertEquals;

import java.util.Hashtable;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bestbuy.constants.BestBuyConstants;
import com.bestbuy.productpojo.ProductResponse;
import com.bestbuy.utilities.BestBuyDataProvider;
import com.bestbuy.utilities.JsonMapper;
import com.bestbuy.utilities.Utilities;

import io.restassured.response.Response;

public class ProductAPIGetTest {
	
	String productApiEndPoint = BestBuyConstants.ProductApiEndPoint.getResource();
	Utilities util = new Utilities();
	JsonMapper mapper = new JsonMapper();
	Response response;
	ProductResponse productResponse;
	
	@BeforeMethod
	public void getProductApiResponse() {
		response = util.getRequestResponse(productApiEndPoint);
		productResponse = mapper.getMappedResponse(response, ProductResponse.class);
	}
	
	@Test(dataProviderClass = BestBuyDataProvider.class, dataProvider = "ProductGetData")
	public void verifyProductApiResponse(Hashtable<String, String> table) {
		int index = (int) Float.parseFloat(table.get("index"));
		assertEquals(productResponse.getData()[index].getName(), table.get("name"));
		assertEquals(productResponse.getData()[index].getImage(), table.get("image"));
		assertEquals(productResponse.getData()[index].getManufacturer(), table.get("manufacturer"));
		assertEquals(productResponse.getData()[index].getDescription(), table.get("description"));
	}

}
