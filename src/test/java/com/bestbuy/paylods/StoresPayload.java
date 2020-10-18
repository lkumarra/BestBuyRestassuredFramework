package com.bestbuy.paylods;

import org.json.JSONObject;

public class StoresPayload {

	String name;
	String type;
	String address;
	String address2;
	String city;
	String state;
	String zip;
	int lat;
	int lng;
	String hours;
	String services;
	String serviceType;

	public StoresPayload(String name, String type, String address, String address2, String city, String state,String zip, int lat,
			int lng, String hours, String services, String serviceType) {
		this.name = name;
		this.type = type;
		this.address = address;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.lat = lat;
		this.lng = lng;
		this.hours = hours;
		this.services = services;
		this.serviceType = serviceType;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getStoresJsonPayload() {
		JSONObject obj = new JSONObject();
		obj.put("name", this.name);
		obj.put("type", this.type);
		obj.put("address", this.address);
		obj.put("address2", this.address2);
		obj.put("city", this.city);
		obj.put("state", this.state);
		obj.put("zip", this.zip);
		obj.put("lat", this.lat);
		obj.put("lng", this.lng);
		obj.put("hours", this.hours);
		JSONObject obj2 = new JSONObject();
		obj2.put(this.services, this.serviceType);
		obj.put("services",obj2);
		return obj.toString();
	}

}
