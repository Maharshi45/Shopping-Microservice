package com.maharshi.ShoppingMS.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.maharshi.ShoppingMS.model.Customer;

@FeignClient(name = "Customer-Service")
//@RequestMapping("/customers")
public interface CustomerProxy {

	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer);

	@DeleteMapping("/customers/{id}")
	public void deleteCustomerById(@PathVariable("id") int id);

	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable("id") int id);

	@GetMapping("/customers")
	public List<Customer> getAllCustomers();

	@DeleteMapping("/customers")
	public void deleteAllCustomers();

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer);

	@GetMapping("/customers/exist/{id}")
	public boolean existsById(@PathVariable("id") int id);
}
