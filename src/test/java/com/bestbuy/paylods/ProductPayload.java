package com.bestbuy.paylods;

import org.json.JSONObject;

public class ProductPayload {

	String name;
	String type;
	int price;
	int shipping;
	String upc;
	String description;
	String manufacturer;
	String model;
	String url;
	String image;

	public ProductPayload(String name, String type, int price, int shipping, String upc, String description,
			String manufacturer, String model, String url, String image) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.shipping = shipping;
		this.upc = upc;
		this.description = description;
		this.manufacturer = manufacturer;
		this.model = model;
		this.url = url;
		this.image = image;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getProductJsonPayload() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", this.name);
		jsonObj.put("type", this.type);
		jsonObj.put("price", this.price);
		jsonObj.put("shipping", this.shipping);
		jsonObj.put("upc", this.upc);
		jsonObj.put("description", this.description);
		jsonObj.put("manufacturer", this.manufacturer);
		jsonObj.put("model", this.model);
		jsonObj.put("url", this.url);
		jsonObj.put("image", this.image);
		return jsonObj.toString();
	}

}
