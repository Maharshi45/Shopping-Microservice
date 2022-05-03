package com.maharshi.ShoppingMS.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maharshi.ShoppingMS.model.Order;

@FeignClient(name = "Order-Service")
//@RequestMapping("/order")
public interface OrderProxy {

	@PostMapping("/order")
	public Order createOrder(@RequestBody Order order);

	@GetMapping("/order/{id}")
	public Order getOrderById(@PathVariable("id") int id);

	@GetMapping("/order")
	public List<Order> getAllOrders();

	@DeleteMapping("/order/{id}")
	public void deleteOrderById(@PathVariable("id") int id);

	@DeleteMapping("/order")
	public void deleteAllOrders();

	@PutMapping("/order")
	public Order updateOrder(@RequestBody Order order);

	@DeleteMapping("/order/byObject")
	public void deleteOrder(@RequestBody Order order);

}
