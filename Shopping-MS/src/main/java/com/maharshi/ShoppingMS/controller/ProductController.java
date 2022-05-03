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

import com.maharshi.ShoppingMS.model.ProductInventory;
import com.maharshi.ShoppingMS.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("")
	public ResponseEntity<ProductInventory> createProduct(@RequestBody ProductInventory productInventory) {
		return new ResponseEntity<ProductInventory>(productService.createProduct(productInventory), HttpStatus.CREATED);
	}

	@GetMapping("")
	public List<ProductInventory> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{prodid}")
	public ProductInventory getProductById(@PathVariable("prodid") int id) {
		return productService.getProductById(id);
	}

	@DeleteMapping("")
	public void deleteAllProducts() {
		productService.deleteAllProducts();
	}

	@DeleteMapping("/{id}")
	public void deleteProductById(@PathVariable("id") int id) {
		productService.deleteProductById(id);
	}

	@PutMapping("")
	public ProductInventory updateProduct(@RequestBody ProductInventory productInventory) {
		return productService.updateProduct(productInventory);
	}

}
