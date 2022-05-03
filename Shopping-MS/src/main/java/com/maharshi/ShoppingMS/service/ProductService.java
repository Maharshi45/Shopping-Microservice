package com.maharshi.ShoppingMS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maharshi.ShoppingMS.client.InventoryProxy;
import com.maharshi.ShoppingMS.client.ProductProxy;
import com.maharshi.ShoppingMS.model.Inventory;
import com.maharshi.ShoppingMS.model.Product;
import com.maharshi.ShoppingMS.model.ProductInventory;

@Service
public class ProductService {

	@Autowired
	private ProductProxy productProxy;
	@Autowired
	private InventoryProxy inventoryProxy;

	public ProductInventory createProduct(ProductInventory productInventory) {

		Product product = new Product();
		product.setProductName(productInventory.getProductName());
		product.setProductPrice(productInventory.getProductPrice());
		product = productProxy.createProduct(product);

		Inventory inventory = new Inventory();
		inventory.setProductId(product.getProductId());
		inventory.setQuantity(productInventory.getQuantity());

		inventoryProxy.createInventory(inventory);
		productInventory.setProductId(product.getProductId());

		return productInventory;

	}

	public List<ProductInventory> getAllProducts() {

		List<Product> products = productProxy.getAllProducts();
		List<ProductInventory> productInventories = new ArrayList<ProductInventory>();

		for (Product product : products) {

			Inventory inventory = inventoryProxy.getInventoryById(product.getProductId());
			ProductInventory productInventory = new ProductInventory();
			productInventory.setProductId(product.getProductId());
			productInventory.setProductName(product.getProductName());
			productInventory.setProductPrice(product.getProductPrice());
			productInventory.setQuantity(inventory.getQuantity());
			productInventories.add(productInventory);

		}

		return productInventories;

	}

	public ProductInventory getProductById(int id) {

		Product product = productProxy.getProductById(id);
		Inventory inventory = inventoryProxy.getInventoryById(id);
		ProductInventory productInventory = new ProductInventory();

		productInventory.setProductId(product.getProductId());
		productInventory.setProductName(product.getProductName());
		productInventory.setProductPrice(product.getProductPrice());
		productInventory.setQuantity(inventory.getQuantity());

		return productInventory;

	}

	public void deleteAllProducts() {
		productProxy.deleteAllProducts();
		inventoryProxy.deleteInventory();
	}

	public void deleteProductById(int id) {
		productProxy.deleteProductById(id);
		inventoryProxy.deleteInventoryById(id);
	}

	public ProductInventory updateProduct(ProductInventory productInventory) {

		Product product = productProxy.getProductById(productInventory.getProductId());
		product.setProductName(productInventory.getProductName());
		product.setProductPrice(productInventory.getProductPrice());
		productProxy.updateProduct(product);

		Inventory inventory = inventoryProxy.getInventoryById(productInventory.getProductId());
		inventory.setQuantity(productInventory.getQuantity());
		inventoryProxy.updateInventory(inventory);

		return productInventory;

	}

}
