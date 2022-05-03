package com.maharshi.ShoppingMS.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.maharshi.ShoppingMS.model.Inventory;

@FeignClient(name = "Inventory-Service")
//@RequestMapping("/inventory")
public interface InventoryProxy {

	@PostMapping("/inventory")
	public Inventory createInventory(@RequestBody Inventory inventory);

	@GetMapping("/inventory/{id}")
	public Inventory getInventoryById(@PathVariable("id") int id);

	@GetMapping("/inventory")
	public List<Inventory> getInventory();

	@PutMapping("/inventory")
	public Inventory updateInventory(@RequestBody Inventory inventory);

	@DeleteMapping("/inventory/{id}")
	public void deleteInventoryById(@PathVariable("id") int id);

	@DeleteMapping("/inventory")
	public void deleteInventory();

}
