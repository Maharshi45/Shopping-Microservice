package com.maharshi.InventoryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maharshi.InventoryService.model.Inventory;

public interface InventoryDao  extends JpaRepository<Inventory, Integer>{

}
