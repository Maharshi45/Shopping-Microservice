package com.maharshi.ShoppingMS.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.maharshi.ShoppingMS.model.Product;

@FeignClient(name = "Product-Service")
//@RequestMapping("/products")
public interface ProductProxy {

	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product);

	@DeleteMapping("/products/{prodid}")
	public void deleteProductById(@PathVariable("prodid") int id);

	@GetMapping("/products/{prodid}")
	public Product getProductById(@PathVariable("prodid") int id);

	@GetMapping("/products")
	public List<Product> getAllProducts();

	@DeleteMapping("/products")
	public void deleteAllProducts();

	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product);

}
