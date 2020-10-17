package com.bestbuy.rough;

import com.bestbuy.constants.BestBuyConstants;
import com.bestbuy.paylods.ProductPayload;
import com.bestbuy.utilities.Utilities;

import io.restassured.response.Response;

public class Rough {

	public static void main(String[] args) {
		
		Utilities util = new Utilities();
		
		//Response res = util.getRequestResponse(BestBuyConstants.ProductApiEndPoint.getResource(), "id", "127687");
		ProductPayload ppl = new ProductPayload("Apple Macbook", "Electronics", 10000, 250, "Laptop", "14 inch laptop", "Apple", "Macbook pro", "https://google.com", "https://google.com");
		Response res = util.getPostRequestResponse(BestBuyConstants.ProductApiEndPoint.getResource(),ppl.getProductJsonPayload());
		res.prettyPrint();
	}

}
