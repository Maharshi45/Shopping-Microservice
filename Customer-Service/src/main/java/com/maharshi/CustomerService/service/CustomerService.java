package com.maharshi.CustomerService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maharshi.CustomerService.exception.CustomerNotFoundException;
import com.maharshi.CustomerService.model.Customer;
import com.maharshi.CustomerService.repository.CustomerDao;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;

	public Customer createCustomer(Customer customer) {
		return dao.save(customer);
	}

	public void deleteCustomerById(int id) throws CustomerNotFoundException {
		Optional<Customer> customer = dao.findById(id);
		if (customer.isPresent())
			dao.deleteById(id);
		else
			throw new CustomerNotFoundException("Customer with id=" + id + " does not exist");
	}

	public Customer getCustomerById(int id) throws CustomerNotFoundException {
		Optional<Customer> customer = dao.findById(id);
		if (customer.isPresent())
			return customer.get();
		else
			throw new CustomerNotFoundException("Customer with id=" + id + " does not exist");
	}

	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		Optional<Customer> tempCustomer = dao.findById(customer.getCustomerId());
		if (tempCustomer.isPresent())
			return dao.save(customer);
		else
			throw new CustomerNotFoundException("Customer with id=" + customer.getCustomerId() + " does not exist");
	}

	public void deleteAllCustomers() {
		dao.deleteAll();
	}

	public List<Customer> getAllCustomers() {
		return dao.findAll();
	}

	public boolean existsById(int id) {
		return dao.existsById(id);
	}

}
