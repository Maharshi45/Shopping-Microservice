package com.maharshi.OrderService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maharshi.OrderService.exception.OrderNotFoundException;
import com.maharshi.OrderService.model.Order;
import com.maharshi.OrderService.repository.OrderDao;

@Service
public class OrderService {

	@Autowired
	private OrderDao dao;

	public Order createOrder(Order order) {
		return dao.save(order);
	}

	public Order getOrderById(int id) throws OrderNotFoundException {
		if (dao.existsById(id))
			return dao.findById(id).get();
		else
			throw new OrderNotFoundException("Order with id=" + id + " does not exist");

	}

	public List<Order> getAllOrders() {
		return dao.findAll();
	}

	public void deleteOrderById(int id) throws OrderNotFoundException {
		if (dao.existsById(id))
			dao.deleteById(id);
		else
			throw new OrderNotFoundException("Order with id=" + id + " does not exist");
	}

	public void deleteAllOrders() {
		dao.deleteAll();
	}

	public void deleteOrder(Order order) throws OrderNotFoundException {
		if (dao.existsById(order.getOrderId()))
			dao.delete(order);
		else
			throw new OrderNotFoundException("Order with id=" + order.getOrderId() + " does not exist");
	}

	public Order updateOrder(Order order) throws OrderNotFoundException {
		if (dao.existsById(order.getOrderId()))
			return dao.save(order);
		else
			throw new OrderNotFoundException("Order with id=" + order.getOrderId() + " does not exist");
	}

}
