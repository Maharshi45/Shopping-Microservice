package com.maharshi.OrderService.controller;

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

import com.maharshi.OrderService.exception.OrderNotFoundException;
import com.maharshi.OrderService.model.Order;
import com.maharshi.OrderService.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;

	@PostMapping("")
	public Order createOrder(@RequestBody Order order) {
		return service.createOrder(order);
	}

	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable("id") int id) throws OrderNotFoundException {
		return service.getOrderById(id);
	}

	@GetMapping("")
	public List<Order> getAllOrders() {
		return service.getAllOrders();
	}

	@DeleteMapping("/{id}")
	public void deleteOrderById(@PathVariable("id") int id) throws OrderNotFoundException {
		service.deleteOrderById(id);
	}

	@DeleteMapping("")
	public void deleteAllOrders() {
		service.deleteAllOrders();
	}

	@PutMapping("")
	public Order updateOrder(@RequestBody Order order) throws OrderNotFoundException {
		return service.updateOrder(order);
	}

	@DeleteMapping("/byObject")
	public void deleteOrder(@RequestBody Order order) throws OrderNotFoundException {
		service.deleteOrder(order);
	}

}
