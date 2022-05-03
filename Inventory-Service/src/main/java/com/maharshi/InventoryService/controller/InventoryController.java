package com.maharshi.InventoryService.controller;

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

import com.maharshi.InventoryService.exception.ProductNotFoundException;
import com.maharshi.InventoryService.model.Inventory;
import com.maharshi.InventoryService.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService service;

	@PostMapping("")
	public Inventory createInventory(@RequestBody Inventory inventory) {
		return service.createInventory(inventory);
	}

	@GetMapping("/{id}")
	public Inventory getInventoryById(@PathVariable("id") int id) throws ProductNotFoundException {
		return service.getInventoryById(id);
	}

	@GetMapping("")
	public List<Inventory> getInventory() {
		return service.getInventory();
	}

	@PutMapping("")
	public Inventory updateInventory(@RequestBody Inventory inventory) throws ProductNotFoundException {
		return service.updateInventory(inventory);
	}

	@DeleteMapping("{id}")
	public void deleteInventoryById(@PathVariable("id") int id) throws ProductNotFoundException {
		service.deleteInventoryById(id);
	}

	@DeleteMapping("")
	public void deleteInventory() {
		service.deleteInventory();
	}

}