package com.maharshi.ShoppingMS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maharshi.ShoppingMS.client.CartProxy;
import com.maharshi.ShoppingMS.client.CustomerProxy;
import com.maharshi.ShoppingMS.exception.ResourceNotFoundException;
import com.maharshi.ShoppingMS.model.Cart;
import com.maharshi.ShoppingMS.model.Customer;
import com.maharshi.ShoppingMS.model.CustomerCart;
import com.maharshi.ShoppingMS.model.CustomerOrder;
import com.maharshi.ShoppingMS.model.LineItem;
import com.maharshi.ShoppingMS.model.Order;
import com.maharshi.ShoppingMS.repository.CustomerOrderDao;

@Service
public class CustomerService {

	@Autowired
	private CustomerProxy customerProxy;
	@Autowired
	private CartProxy cartProxy;
	@Autowired
	private CustomerCartService customerCartService;
	@Autowired
	private CustomerOrderDao customerOrderDao;
	@Autowired
	private OrderService orderService;

	public boolean existsById(int id) {
		return customerProxy.existsById(id);
	}

	public Customer createCustomer(Customer customer) {

		customer = customerProxy.createCustomer(customer);

		Cart cart = new Cart();
		List<LineItem> items = new ArrayList<LineItem>();
		cart.setItems(items);
		cart = cartProxy.createCart(cart);
		CustomerCart customerCart = new CustomerCart();

		customerCart.setCartId(cart.getCartId());
		customerCart.setCustomerId(customer.getCustomerId());
		customerCartService.createCustomerCart(customerCart);

		return customer;

	}

	public void deleteCustomerById(int id) throws ResourceNotFoundException {
		if (customerProxy.existsById(id)) {
			CustomerCart customerCart = customerCartService.getCustomerCartById(id);

			List<CustomerOrder> customerOrders = customerOrderDao.getCustomerOrdersByCustomerId(id);

			for (CustomerOrder customerOrder : customerOrders) {
				Order order = orderService.getOrderById(customerOrder.getOrderId());
				orderService.deleteOrder(order);
			}

			customerOrderDao.deleteByCustomerId(id);
			cartProxy.deleteCartById(customerCart.getCartId());
			customerCartService.deleteCustomerCartById(id);
			customerProxy.deleteCustomerById(id);

		} else
			throw new ResourceNotFoundException("Customer with id=" + id + " does not exist");
	}

	public Customer getCustomerById(int id) {
		return customerProxy.getCustomerById(id);
	}

	public List<Customer> getAllCustomers() {
		return customerProxy.getAllCustomers();
	}

	public void deleteAllCustomers() {
		cartProxy.deleteAllCarts();
		customerProxy.deleteAllCustomers();
		orderService.deleteAllOrders();
		customerOrderDao.deleteAll();
		customerCartService.deleteAllCustomerCart();
	}

	public Customer updateCustomer(Customer customer) {
		return customerProxy.updateCustomer(customer);
	}

}
