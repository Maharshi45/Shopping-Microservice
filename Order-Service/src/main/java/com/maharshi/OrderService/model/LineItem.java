package com.maharshi.OrderService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LineItem {

	@Id
	@GeneratedValue
	private int id;
	private int productId;
	private String productName;
	private double productPrice;
	private int quantity;

	public LineItem() {
		super();
	}

	public LineItem(int id, int productId, String productName, double productPrice, int quantity) {
		super();
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "LineItem [id=" + id + ", productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", quantity=" + quantity + "]";
	}

}
