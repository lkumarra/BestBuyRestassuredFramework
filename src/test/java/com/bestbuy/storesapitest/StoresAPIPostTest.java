package com.bestbuy.storesapitest;

import static org.testng.Assert.assertEquals;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.bestbuy.constants.BestBuyConstants;
import com.bestbuy.paylods.StoresPayload;
import com.bestbuy.storespojo.StoresPostResponse;
import com.bestbuy.utilities.BestBuyDataProvider;
import com.bestbuy.utilities.JsonMapper;
import com.bestbuy.utilities.Utilities;

import io.restassured.response.Response;

public class StoresAPIPostTest {
	
	String storesApiEndPoint = BestBuyConstants.StoresApiEndPoint.getResource();
	StoresPayload storesPayload;
	Utilities util = new Utilities();
	JsonMapper mapper = new JsonMapper();
	
	@Test(dataProviderClass = BestBuyDataProvider.class, dataProvider = "StoresPayloadData")
	public void verifyStoresApiStoresAddTest(Hashtable<String, String> table) {
		storesPayload = new StoresPayload(table);
		Response response = util.getPostRequestResponse(storesApiEndPoint, storesPayload.getStoresJsonPayload());
		StoresPostResponse storesPostResponse = mapper.getMappedResponse(response, StoresPostResponse.class);
		assertEquals(storesPostResponse.getName(), table.get("name"));
		assertEquals(storesPostResponse.getType(), table.get("type"));
	}

}
