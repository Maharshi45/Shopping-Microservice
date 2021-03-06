package com.maharshi.ShoppingMS.model;

public class ProductQuantityDTO {

	private int productId;
	private int quantity;

	public ProductQuantityDTO() {
		super();
	}

	public ProductQuantityDTO(int productId, int quantity) {
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

	@Override
	public String toString() {
		return "ProductQuantityDTO [productId=" + productId + ", quantity=" + quantity + "]";
	}

}
