package com.bestbuy.utilities;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class JsonMapper {
	
	/**
	 * Mapped the Json Response to Java Objects
	 * @param <T> 
	 * @param response Resonse from api
	 * @param valueType Class Name
	 * @return Object of the class after mapping the response from java objects
	 */
	public <T> T getMappedResponse(Response response, Class<T> valueType) {
		ObjectMapper mapper = new ObjectMapper(); 
		try {
			return (T) mapper.readValue(response.asInputStream(), valueType);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
