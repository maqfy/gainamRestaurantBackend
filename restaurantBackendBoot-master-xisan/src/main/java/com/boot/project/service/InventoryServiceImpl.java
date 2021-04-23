package com.boot.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.project.model.Inventory;
import com.boot.project.repository.InventoryRepository;

@Service
@Transactional // It is not necessary. You can use it, if you have multiple database operation
				// in a single service method.

public class InventoryServiceImpl implements InventoryService {
	
	
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public Inventory saveInventory(Inventory inventory) {
		inventoryRepository.save(inventory);
		// TODO Auto-generated method stub
		return inventory;
	}

	@Override
	public Inventory updateInventory(Inventory inventory) {
		return inventory;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInventory(Long inventoryId) {
		inventoryRepository.deleteById(inventoryId);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long numberOfInventories() {
		// TODO Auto-generated method stub
		return inventoryRepository.count();
		
	}

	@Override
	public List<Inventory> findAllInventories() {
		// TODO Auto-generated method stub
		return inventoryRepository.findAll();
	}

	
}
