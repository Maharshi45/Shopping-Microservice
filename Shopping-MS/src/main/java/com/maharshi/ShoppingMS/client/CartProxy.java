package com.maharshi.ShoppingMS.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.maharshi.ShoppingMS.model.Cart;

@FeignClient(name = "Cart-Service")
//@RequestMapping("/cart")
public interface CartProxy {

	@PostMapping("/cart")
	public Cart createCart(@RequestBody Cart cart);

	@GetMapping("/cart/{id}")
	public Cart getCartById(@PathVariable("id") int id);

	@GetMapping("/cart")
	public List<Cart> getCarts();

	@DeleteMapping("/cart/{id}")
	public void deleteCartById(@PathVariable("id") int id);

	@DeleteMapping("/cart")
	public void deleteAllCarts();

	@PutMapping("/cart")
	public Cart updateCart(@RequestBody Cart cart);
	
}
