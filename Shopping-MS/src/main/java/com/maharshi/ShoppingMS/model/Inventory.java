package com.maharshi.ShoppingMS.model;

public class Inventory {

	private int productId;
	private int quantity;

	public Inventory() {
		super();
	}

	public Inventory(int productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
