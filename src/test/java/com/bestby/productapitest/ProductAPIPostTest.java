package com.bestby.productapitest;

import static org.testng.Assert.assertEquals;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.bestbuy.constants.BestBuyConstants;
import com.bestbuy.paylods.ProductPayload;
import com.bestbuy.productpojo.ProductPostResponse;
import com.bestbuy.utilities.BestBuyDataProvider;
import com.bestbuy.utilities.JsonMapper;
import com.bestbuy.utilities.Utilities;

import io.restassured.response.Response;

public class ProductAPIPostTest {
	
	String productApiEndPoint = BestBuyConstants.ProductApiEndPoint.getResource();
	Utilities util = new Utilities();
	ProductPayload productPayload;
	JsonMapper mapper = new JsonMapper();
	
	@Test(dataProviderClass = BestBuyDataProvider.class, dataProvider = "ProductPayloadData")
	public void verifyProductApiProductAddTest(Hashtable<String, String> table) {
		productPayload = new ProductPayload(table);
		Response productpost = util.getPostRequestResponse(productApiEndPoint, productPayload.getProductJsonPayload());
		ProductPostResponse productPostResponse = mapper.getMappedResponse(productpost, ProductPostResponse.class);
		assertEquals(productPostResponse.getName(), table.get("name"));
		assertEquals(productPostResponse.getType(), table.get("type"));
	}

}
