package com.maharshi.ShoppingMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maharshi.ShoppingMS.exception.ResourceNotFoundException;
import com.maharshi.ShoppingMS.model.Cart;
import com.maharshi.ShoppingMS.model.ProductQuantityDTO;
import com.maharshi.ShoppingMS.service.CartService;

@RestController
//@RequestMapping("/customers/{id}/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/customers/{id}/cart/products")
	public ResponseEntity<Cart> createCart(@PathVariable("id") int customerId,
			@RequestBody List<ProductQuantityDTO> productQuantities) throws ResourceNotFoundException {
		return new ResponseEntity<Cart>(cartService.createCart(customerId, productQuantities), HttpStatus.CREATED);
	}

	@GetMapping("/customers/{id}/cart")
	public Cart getCartByCustomerId(@PathVariable("id") int customerId) throws ResourceNotFoundException {
		return cartService.getCartByCustomerId(customerId);
	}

}
