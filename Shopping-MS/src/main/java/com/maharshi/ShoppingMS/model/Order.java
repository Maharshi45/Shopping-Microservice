package com.maharshi.ShoppingMS.model;

import java.util.List;

public class Order {

	private int orderId;
	private String deliveryAddress;
	private List<LineItem> items;

	public Order() {
		super();
	}

	public Order(int orderId, String deliveryAddress, List<LineItem> items) {
		super();
		this.orderId = orderId;
		this.deliveryAddress = deliveryAddress;
		this.items = items;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<LineItem> getItems() {
		return items;
	}

	public void setItems(List<LineItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", deliveryAddress=" + deliveryAddress + ", items=" + items + "]";
	}

	
	
}
