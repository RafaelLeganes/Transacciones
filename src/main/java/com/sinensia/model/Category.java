package com.sinensia.model;

import java.util.List;

public class Category {

	private int categoryId;
	private String categoryName;
	private List<Product> productos;
	
	public Category(int categoryId, String categoryName, List<Product> productos) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.productos = productos;
	}
	
	public Category() {
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProductos() {
		return productos;
	}

	public void setProductos(List<Product> productos) {
		this.productos = productos;
	}
	
}
