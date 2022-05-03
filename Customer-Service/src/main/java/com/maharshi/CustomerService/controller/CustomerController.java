package com.maharshi.CustomerService.controller;

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

import com.maharshi.CustomerService.exception.CustomerNotFoundException;
import com.maharshi.CustomerService.model.Customer;
import com.maharshi.CustomerService.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping("")
	public Customer createCustomer(@RequestBody Customer customer) {
		return service.createCustomer(customer);
	}

	@DeleteMapping("/{id}")
	public void deleteCustomerById(@PathVariable("id") int id) throws CustomerNotFoundException {
		service.deleteCustomerById(id);
	}

	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable("id") int id) throws CustomerNotFoundException {
		return service.getCustomerById(id);
	}

	@GetMapping("")
	public List<Customer> getAllCustomers() {
		return service.getAllCustomers();
	}

	@DeleteMapping("")
	public void deleteAllCustomers() {
		service.deleteAllCustomers();
	}

	@PutMapping("")
	public Customer updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		return service.updateCustomer(customer);
	}

	@GetMapping("/exist/{id}")
	public boolean existsById(@PathVariable("id") int id) {
		return service.existsById(id);
	}

}
