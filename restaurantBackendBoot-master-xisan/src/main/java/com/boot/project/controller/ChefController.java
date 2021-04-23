package com.boot.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.boot.project.model.Inventory;
import com.boot.project.model.Product;
import com.boot.project.model.StringResponse;
import com.boot.project.service.InventoryService;
import com.boot.project.service.ProductService;

@RestController
public class ChefController {

    
    
    @Autowired
	private InventoryService inventoryService;

    @Autowired
    private ProductService productService;

    
    
    
    //inventory
    @PostMapping("/api/chef/inventory-create")
	public ResponseEntity<?> createInventory(@RequestBody Inventory inventory) {
		return new ResponseEntity<>(inventoryService.saveInventory(inventory), HttpStatus.CREATED);
	}

	
	@PutMapping("/api/chef/inventory-update")
	public ResponseEntity<?> updateInventory(@RequestBody Inventory inventory) {
		return new ResponseEntity<>(inventoryService.updateInventory(inventory), HttpStatus.CREATED);
	}

	// This can be also @DeleteMapping.

	@PostMapping("/api/chef/inventory-delete")
	public ResponseEntity<?> deleteInventory(@RequestBody Inventory inventory) {
		inventoryService.deleteInventory(inventory.getId());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/api/chef/inventory-all")
	public ResponseEntity<?> findAllInventories() {
		return new ResponseEntity<>(inventoryService.findAllInventories(), HttpStatus.OK);
	}

	@GetMapping("/api/chef/inventory-number")
	public ResponseEntity<?> numberOfInventorys() {
		Long number = inventoryService.numberOfInventories();
		StringResponse response = new StringResponse();
		response.setResponse(number.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
    
    //product
    @PostMapping("/api/chef/product-create")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }
//    @GetMapping("api/admin/delete/{email}")
//	public Iterable<Reserve> deleteReserve(@PathVariable String email){
//		return reserveService.deleteUserByEmail(email);
//	}

    @PutMapping("/api/chef/product-update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.CREATED);
    }

    //This can be also @DeleteMapping.
    @PostMapping("/api/chef/product-delete")
    public ResponseEntity<?> deleteProduct(@RequestBody Product product){
        productService.deleteProduct(product.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/chef/product-all")
    public ResponseEntity<?> findAllProducts(){
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/api/chef/product-number")
    public ResponseEntity<?> numberOfProducts(){
        Long number = productService.numberOfProducts();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}