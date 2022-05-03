package com.maharshi.InventoryService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maharshi.InventoryService.exception.ProductNotFoundException;
import com.maharshi.InventoryService.model.Inventory;
import com.maharshi.InventoryService.repository.InventoryDao;

@Service
public class InventoryService {

	@Autowired
	private InventoryDao dao;

	public Inventory createInventory(Inventory inventory) {
		return dao.save(inventory);
	}

	public Inventory getInventoryById(int id) throws ProductNotFoundException {
		Optional<Inventory> inventory = dao.findById(id);
		if (inventory.isPresent())
			return inventory.get();
		else
			throw new ProductNotFoundException("Product with id=" + id + " does not exist");
	}

	public List<Inventory> getInventory() {
		return dao.findAll();
	}

	public Inventory updateInventory(Inventory inventory) throws ProductNotFoundException {
		Optional<Inventory> tempInventory = dao.findById(inventory.getProductId());
		if (tempInventory.isPresent())
			return dao.save(inventory);
		else
			throw new ProductNotFoundException("Product with id=" + inventory.getProductId() + " does not exist");
	}

	public void deleteInventoryById(int id) throws ProductNotFoundException {
		Optional<Inventory> inventory = dao.findById(id);
		if (inventory.isPresent())
			dao.deleteById(id);
		else
			throw new ProductNotFoundException("Product with id=" + id + " does not exist");
	}

	public void deleteInventory() {
		dao.deleteAll();
	}

}
