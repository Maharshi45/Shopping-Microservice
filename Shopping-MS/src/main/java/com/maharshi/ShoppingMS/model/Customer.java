package com.maharshi.ShoppingMS.model;

public class Customer {

	private int customerId;
	private String customerName;
	private String email;
	private String deliveryAddress;

	public Customer() {
		super();
	}

	public Customer(int customerId, String customerName, String email, String deliveryAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.deliveryAddress = deliveryAddress;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email
				+ ", deliveryAddress=" + deliveryAddress + "]";
	}

}
