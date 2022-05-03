package com.maharshi.ShoppingMS.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maharshi.ShoppingMS.exception.InvalidCartException;
import com.maharshi.ShoppingMS.exception.ResourceNotFoundException;
import com.maharshi.ShoppingMS.model.Order;
import com.maharshi.ShoppingMS.service.OrderService;

@RestController
@RequestMapping("/customers")
public class OrderConrtroller {

	@Autowired
	private OrderService orderService;

	@PostMapping("/{id}/cart/placeorder")
	public ResponseEntity<Order> placeOrder(@PathVariable("id") int id)
			throws ResourceNotFoundException, InvalidCartException {
		return new ResponseEntity<Order>(orderService.placeOrder(id), HttpStatus.CREATED);
	}

	@GetMapping("/{id}/orders")
	public List<Map<String, Object>> getOrdersByCustomerId(@PathVariable("id") int id)
			throws ResourceNotFoundException {
		return orderService.getOrdersByCustomerId(id);
	}

	@GetMapping("/orders")
	public List<Map<String, Object>> getAllOrders() {
		return orderService.getAllOrders();
	}

}
