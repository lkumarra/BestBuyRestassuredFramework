package com.bestbuy.steps;

import com.bestbuy.constants.BestBuyConstants;
import com.bestbuy.constants.StatusCodes;
import com.bestbuy.productpojo.ProductResponse;
import com.bestbuy.utilities.JsonMapper;
import com.bestbuy.utilities.Utilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ProductAPISteps {
	
	static String productApiEndPoint;
	static Response response;
	static Utilities util = new Utilities();
	static JsonMapper mapper = new JsonMapper();
	static ProductResponse productResponse;
	
	@Given("I hava a valid endpoint for productapi")
	public void i_hava_a_valid_endpoint_for_productapi() {
		productApiEndPoint = BestBuyConstants.ProductApiEndPoint.getResource();
	}

	@When("I navitage to productapi endpoint")
	public void i_navitage_to_productapi_endpoint() {
	    response = util.getRequestResponse(productApiEndPoint);
	    productResponse = mapper.getMappedResponse(response, ProductResponse.class);
	}

	@Then("I get {int} as response code")
	public void i_get_as_response_code(Integer int1) {
	    Assert.assertEquals(response.statusCode(), StatusCodes.OK);
	}

	@Then("I get limit as {int} in response")
	public void i_get_limit_as_in_response(int limit) {
		Assert.assertEquals(productResponse.getLimit(), limit);
	}

	@Then("I get total as {int} in response")
	public void i_get_total_as_in_response(int total) {
		Assert.assertEquals(productResponse.getTotal(), total);
	}

	@Then("I get skip as {int} in response")
	public void i_get_skip_as_in_response(int skip) {
		Assert.assertEquals(productResponse.getSkip(), skip);
	}

}
