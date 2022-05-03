package com.maharshi.ShoppingMS.model;

public class ProductInventory {

	private int productId;
	private String productName;
	private double productPrice;
	private int quantity;

	public ProductInventory() {
		super();
	}

	public ProductInventory(int productId, String productName, double productPrice, int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductInventory [productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", quantity=" + quantity + "]";
	}

}
