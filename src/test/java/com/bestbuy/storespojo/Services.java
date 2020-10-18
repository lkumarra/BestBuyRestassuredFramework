package com.bestbuy.storespojo;

public class Services {

	int id;
	String name;
	String createdAt;
	String updatedAt;
	StoreServices storeservices;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public StoreServices getStoreservices() {
		return storeservices;
	}

	public void setStoreservices(StoreServices storeservices) {
		this.storeservices = storeservices;
	}

}
