package com.maharshi.ShoppingMS.model;

import java.util.List;

public class Cart {

	private int cartId;
	private List<LineItem> items;

	public Cart() {
		super();
	}

	public Cart(int cartId, List<LineItem> items) {
		super();
		this.cartId = cartId;
		this.items = items;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<LineItem> getItems() {
		return items;
	}

	public void setItems(List<LineItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", items=" + items + "]";
	}

}
