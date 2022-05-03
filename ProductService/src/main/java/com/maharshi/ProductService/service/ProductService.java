package com.maharshi.ProductService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maharshi.ProductService.exception.ProductNotFoundException;
import com.maharshi.ProductService.model.Product;
import com.maharshi.ProductService.repository.ProductDao;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;

	public Product createProduct(Product product) {
		return dao.save(product);
	}

	public void deleteProductById(int id) throws ProductNotFoundException {
		Optional<Product> product = dao.findById(id);
		if (product.isPresent())
			dao.deleteById(id);
		else
			throw new ProductNotFoundException("Product with id=" + id + " does not exist");
	}

	public Product getProductById(int id) throws ProductNotFoundException {
		Optional<Product> product = dao.findById(id);
		if (product.isPresent())
			return product.get();
		else
			throw new ProductNotFoundException("Product with id=" + id + " does not exist");
	}

	public Product updateProduct(Product product) throws ProductNotFoundException {
		Optional<Product> tempProduct = dao.findById(product.getProductId());
		if (tempProduct.isPresent())
			return dao.save(product);
		else
			throw new ProductNotFoundException("Product with id=" + product.getProductId() + " does not exist");
	}

	public void deleteAllProducts() {
		dao.deleteAll();
	}

	public List<Product> getAllProducts() {
		return dao.findAll();
	}

}
