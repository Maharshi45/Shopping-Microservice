package com.maharshi.CartService.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private int cartId;

	@OneToMany(targetEntity = LineItem.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ol_fk", referencedColumnName = "cartId")
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
