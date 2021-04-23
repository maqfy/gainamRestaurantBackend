package com.boot.project.service;

import java.util.List;

import com.boot.project.model.Inventory;


public interface InventoryService {
	
	    Inventory saveInventory(Inventory inventory);

	    Inventory updateInventory(Inventory inventory);

	    void deleteInventory(Long inventoryId);

	    Long numberOfInventories();

	    List<Inventory> findAllInventories();
	}



