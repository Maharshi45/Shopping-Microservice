package com.maharshi.ShoppingMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maharshi.ShoppingMS.exception.ResourceNotFoundException;
import com.maharshi.ShoppingMS.model.Customer;
import com.maharshi.ShoppingMS.service.CustomerService;

@RestController
//@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.createCustomer(customer), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomerById(@PathVariable("id") int id) throws ResourceNotFoundException {
		customerService.deleteCustomerById(id);
	}

	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable("id") int id) {
		return customerService.getCustomerById(id);
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@DeleteMapping("/customers")
	public void deleteAllCustomers() {
		customerService.deleteAllCustomers();
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	
}
