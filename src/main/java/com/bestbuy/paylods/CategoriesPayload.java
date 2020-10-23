package com.bestbuy.paylods;

import java.util.Hashtable;

import org.json.JSONObject;

public class CategoriesPayload {
	
	String name;
	String id;
	
	public CategoriesPayload(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public CategoriesPayload(Hashtable<String, String> categoriesTable) {
		this.name = categoriesTable.get("name");
		this.id = categoriesTable.get("id");
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCategoriesJsonPayload() {
		JSONObject obj = new JSONObject();
		obj.put("name", this.name);
		obj.put("id", this.id);
		return obj.toString();
	}

}
