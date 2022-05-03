package com.maharshi.ShoppingMS.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maharshi.ShoppingMS.client.CartProxy;
import com.maharshi.ShoppingMS.client.OrderProxy;
import com.maharshi.ShoppingMS.exception.InvalidCartException;
import com.maharshi.ShoppingMS.exception.ResourceNotFoundException;
import com.maharshi.ShoppingMS.model.Cart;
import com.maharshi.ShoppingMS.model.Customer;
import com.maharshi.ShoppingMS.model.CustomerOrder;
import com.maharshi.ShoppingMS.model.LineItem;
import com.maharshi.ShoppingMS.model.Order;
import com.maharshi.ShoppingMS.model.ProductInventory;
import com.maharshi.ShoppingMS.repository.CustomerOrderDao;

@Service
public class OrderService {

	@Autowired
	private CartService cartService;
	@Autowired
	private OrderProxy orderProxy;
	@Autowired
	private CustomerOrderDao customerOrderDao;
	@Autowired
	private ProductService productService;
	@Autowired
	private CartProxy cartProxy;
	@Autowired
	private CustomerService customerService;

	public Order createOrder(Order order) {
		return orderProxy.createOrder(order);
	}

	public List<Order> getOrders() {
		return orderProxy.getAllOrders();
	}

	public void deleteOrderById(int id) {
		orderProxy.deleteOrderById(id);
	}

	public Order updateOrder(Order order) {
		return orderProxy.updateOrder(order);
	}

	public Order getOrderById(int id) {
		return orderProxy.getOrderById(id);
	}

	public void deleteOrder(Order order) {
		orderProxy.deleteOrder(order);

	}

	public void deleteAllOrders() {
		orderProxy.deleteAllOrders();
	}

	public Order placeOrder(int id) throws ResourceNotFoundException, InvalidCartException {
		if (customerService.existsById(id)) {
			Cart cart = cartService.getCartByCustomerId(id);
			if (!cart.getItems().isEmpty()) {
				List<LineItem> items = cart.getItems();
				List<LineItem> items2 = new ArrayList<LineItem>();

				for (LineItem it : items) {
					LineItem item = new LineItem();

					item.setProductId(it.getProductId());
					item.setProductName(it.getProductName());
					item.setProductPrice(it.getProductPrice());
					item.setQuantity(it.getQuantity());
					items2.add(item);
				}

				if (this.checkEligibilityOfCart(items)) {
					Order order = new Order();
					order.setItems(items2);

					Customer customer = customerService.getCustomerById(id);
					order.setDeliveryAddress(customer.getDeliveryAddress());
					order = this.createOrder(order);

					this.updateInventory(items);
					items.clear();
					cart.setItems(items);

					cartProxy.createCart(cart);
					CustomerOrder customerOrder = new CustomerOrder();
					customerOrder.setCustomerId(id);
					customerOrder.setOrderId(order.getOrderId());

					customerOrderDao.save(customerOrder);
					return order;

				} else
					throw new InvalidCartException(
							"We don't have enough quantity in inventory, please update your cart");
			} else
				throw new InvalidCartException("Cart is empty");
		} else
			throw new ResourceNotFoundException("Customer with id=" + id + " does not exist");
	}

	public List<Map<String, Object>> getOrdersByCustomerId(int id) throws ResourceNotFoundException {

		if (customerService.existsById(id)) {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			List<CustomerOrder> customerOrders = customerOrderDao.getCustomerOrdersByCustomerId(id);

			for (CustomerOrder customerOrder : customerOrders) {
				Order order = orderProxy.getOrderById(customerOrder.getOrderId());
				List<LineItem> items = order.getItems();
				double totalPrice = 0;
				for (int i = 0; i < items.size(); i++) {
					LineItem item = items.get(i);
					totalPrice += item.getProductPrice() * item.getQuantity();
				}

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("Order", order);
				map.put("totalPrice", totalPrice);

				list.add(map);
			}
			return list;
		} else
			throw new ResourceNotFoundException("Customer with id=" + id + " does not exist");

	}

	public List<Map<String, Object>> getAllOrders() {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<CustomerOrder> customerOrders = customerOrderDao.findAll();

		for (CustomerOrder customerOrder : customerOrders) {
			Order order = orderProxy.getOrderById(customerOrder.getOrderId());
			List<LineItem> items = order.getItems();
			double totalPrice = 0;
			for (int i = 0; i < items.size(); i++) {
				LineItem item = items.get(i);
				totalPrice += item.getProductPrice() * item.getQuantity();
			}

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("Order", order);
			map.put("totalPrice", totalPrice);

			list.add(map);
		}
		return list;
	}

	public boolean checkEligibilityOfCart(List<LineItem> items) {
		for (LineItem item : items) {
			ProductInventory productInventory = productService.getProductById(item.getProductId());
			if (productInventory.getQuantity() < item.getQuantity())
				return false;
		}
		return true;
	}

	public void updateInventory(List<LineItem> items) {
		for (LineItem item : items) {

			ProductInventory productInventory = productService.getProductById(item.getProductId());
			productInventory.setQuantity(productInventory.getQuantity() - item.getQuantity());
			productService.updateProduct(productInventory);

		}
	}

}
