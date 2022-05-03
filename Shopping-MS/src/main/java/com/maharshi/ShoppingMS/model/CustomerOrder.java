package com.maharshi.ShoppingMS.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CustomerOrder {

	@Id
	@GeneratedValue
	private int id;
	private int customerId;
	private int orderId;

	public CustomerOrder() {
		super();
	}

	public CustomerOrder(int id, int customerId, int orderId) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.orderId = orderId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "CustomerOrder [id=" + id + ", customerId=" + customerId + ", orderId=" + orderId + "]";
	}

}
