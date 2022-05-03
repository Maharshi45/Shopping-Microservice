package com.maharshi.ProductService.controller;

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

import com.maharshi.ProductService.exception.ProductNotFoundException;
import com.maharshi.ProductService.model.Product;
import com.maharshi.ProductService.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("")
	public Product createProduct(@RequestBody Product product) {
		return service.createProduct(product);
	}

	@DeleteMapping("/{prodid}")
	public void deleteProductById(@PathVariable("prodid") int id) throws ProductNotFoundException {
		service.deleteProductById(id);
	}

	@GetMapping("/{prodid}")
	public Product getProductById(@PathVariable("prodid") int id) throws ProductNotFoundException {
		return service.getProductById(id);
	}

	@GetMapping("")
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}

	@DeleteMapping("")
	public void deleteAllProducts() {
		service.deleteAllProducts();
	}

	@PutMapping("")
	public Product updateProduct(@RequestBody Product product) throws ProductNotFoundException {
		return service.updateProduct(product);
	}

}
