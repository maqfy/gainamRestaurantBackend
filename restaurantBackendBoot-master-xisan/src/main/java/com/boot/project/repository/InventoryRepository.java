package com.boot.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.project.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
