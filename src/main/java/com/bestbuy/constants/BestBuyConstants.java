package com.bestbuy.constants;

public enum BestBuyConstants {
	
	BaseUri("http://localhost:3030"),
	ProductApiEndPoint("/products"),
	CategoriesApiEndPoint("/categories"),
	ServiceApiEndPoint("/services"),
	StoresApiEndPoint("/stores");
	
	private String resource;
	
	BestBuyConstants(String resource){
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}

}
