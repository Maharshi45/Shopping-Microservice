package com.maharshi.ShoppingMS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maharshi.ShoppingMS.client.CartProxy;
import com.maharshi.ShoppingMS.client.ProductProxy;
import com.maharshi.ShoppingMS.exception.ResourceNotFoundException;
import com.maharshi.ShoppingMS.model.Cart;
import com.maharshi.ShoppingMS.model.CustomerCart;
import com.maharshi.ShoppingMS.model.LineItem;
import com.maharshi.ShoppingMS.model.Product;
import com.maharshi.ShoppingMS.model.ProductQuantityDTO;

@Service
public class CartService {

	@Autowired
	private CustomerCartService customerCartService;
	@Autowired
	private ProductProxy productProxy;
	@Autowired
	private CartProxy cartProxy;
	@Autowired
	private CustomerService customerService;

	public void deleteCartById(int id) {
		cartProxy.deleteCartById(id);
	}

	public Cart createCartByCartObject(Cart cart) {
		return cartProxy.createCart(cart);
	}

	public Cart getCartById(int id) {
		return cartProxy.getCartById(id);
	}

	public List<Cart> getCarts() {
		return cartProxy.getCarts();
	}

	public void deleteAllCarts() {
		cartProxy.deleteAllCarts();
	}

	public Cart updateCart(Cart cart) {
		return cartProxy.updateCart(cart);
	}

	public Cart createCart(int customerId, List<ProductQuantityDTO> productQuantities)
			throws ResourceNotFoundException {
		if (customerService.existsById(customerId)) {
			CustomerCart customerCart = customerCartService.getCustomerCartById(customerId);
			List<LineItem> items = new ArrayList<LineItem>();

			for (ProductQuantityDTO dto : productQuantities) {
				Product product = productProxy.getProductById(dto.getProductId());

				LineItem item = new LineItem();
				item.setProductId(product.getProductId());
				item.setProductName(product.getProductName());
				item.setProductPrice(product.getProductPrice());
				item.setQuantity(dto.getQuantity());
				items.add(item);
			}

			Cart cart = this.getCartByCustomerId(customerId);

			cart.setCartId(customerCart.getCartId());
			cart.setItems(items);
			cart = cartProxy.createCart(cart);
			customerCart.setCartId(cart.getCartId());
			customerCartService.createCustomerCart(customerCart);

			return cart;

		} else
			throw new ResourceNotFoundException("Customer with id=" + customerId + " does not exist");
	}

	public Cart getCartByCustomerId(int customerId) throws ResourceNotFoundException {
		
		if (customerService.existsById(customerId)) {
			CustomerCart customerCart = customerCartService.getCustomerCartById(customerId);
			int cartId = customerCart.getCartId();
			return cartProxy.getCartById(cartId);
		} else
			throw new ResourceNotFoundException("Customer with id=" + customerId + " does not exist");
		
	}

}
