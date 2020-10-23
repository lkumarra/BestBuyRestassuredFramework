package com.bestbuy.paylods;

import org.json.JSONObject;

public class ServicesPayload {
	
	String name;
	
	public ServicesPayload(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getServicesJsonPayload() {
		JSONObject obj = new JSONObject();
		obj.put("name", this.name);
		return obj.toString();
	}

}
