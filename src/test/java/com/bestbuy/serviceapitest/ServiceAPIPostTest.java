package com.bestbuy.serviceapitest;

import static org.testng.Assert.assertEquals;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.bestbuy.constants.BestBuyConstants;
import com.bestbuy.paylods.ServicesPayload;
import com.bestbuy.servicespojo.ServicePostResponse;
import com.bestbuy.utilities.BestBuyDataProvider;
import com.bestbuy.utilities.JsonMapper;
import com.bestbuy.utilities.Utilities;

import io.restassured.response.Response;

public class ServiceAPIPostTest {
	
	ServicesPayload servicesPaylod;
	Utilities util = new Utilities();
	String serviceApiEndPoint = BestBuyConstants.ServiceApiEndPoint.getResource();
	JsonMapper mapper = new JsonMapper();
	
	@Test(dataProviderClass = BestBuyDataProvider.class, dataProvider = "ServicesPayloadData")
	public void verifyServiceApiServiceAddTest(Hashtable<String, String> table) {
		servicesPaylod = new ServicesPayload(table.get("name"));
		Response response = util.getPostRequestResponse(serviceApiEndPoint, servicesPaylod.getServicesJsonPayload());
		ServicePostResponse postResponse = mapper.getMappedResponse(response, ServicePostResponse.class);
		assertEquals(postResponse.getName(), table.get("name"));
	}

}
