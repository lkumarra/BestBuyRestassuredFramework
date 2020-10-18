package com.bestbuy.categoriespojo;

public class Data {

	String id;
	String name;
	String createdAt;
	String updatedAt;
	SubCategories subCategories[];
	CategoryPath categoryPath[];

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public SubCategories[] getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(SubCategories[] subCategories) {
		this.subCategories = subCategories;
	}

	public CategoryPath[] getCategoryPath() {
		return categoryPath;
	}

	public void setCategoryPath(CategoryPath[] categoryPath) {
		this.categoryPath = categoryPath;
	}

}
