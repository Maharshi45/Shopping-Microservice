package com.maharshi.OrderService.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "OrderTable")
public class Order {

	@Id
	@GeneratedValue
	private int orderId;
	private String deliveryAddress;

	@OneToMany(targetEntity = LineItem.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ol_fk", referencedColumnName = "orderId")
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
