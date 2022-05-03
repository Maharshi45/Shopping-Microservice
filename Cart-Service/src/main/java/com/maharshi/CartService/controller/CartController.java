package com.maharshi.CartService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maharshi.CartService.exception.CartNotFoundException;
import com.maharshi.CartService.model.Cart;
import com.maharshi.CartService.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService service;

	@PostMapping("")
	public Cart createCart(@RequestBody Cart cart) {
		return service.createCart(cart);
	}

	@GetMapping("/{id}")
	public Cart getCartById(@PathVariable("id") int id) throws CartNotFoundException {
		return service.getCartById(id);
	}

	@GetMapping("")
	public List<Cart> getCarts() {
		return service.getCarts();
	}

	@DeleteMapping("/{id}")
	public void deleteCartById(@PathVariable("id") int id) throws CartNotFoundException {
		service.deleteCartById(id);
	}

	@DeleteMapping("")
	public void deleteAllCarts() {
		service.deleteAllCarts();
	}

	@PutMapping("")
	public Cart updateCart(@RequestBody Cart cart) throws CartNotFoundException {
		return service.updateCart(cart);
	}

}
