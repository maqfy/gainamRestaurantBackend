package com.boot.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.boot.project.model.Inventory;
import com.boot.project.model.Product;
import com.boot.project.model.Reserve;
import com.boot.project.model.StringResponse;
import com.boot.project.service.InventoryService;
import com.boot.project.service.ProductService;
import com.boot.project.service.ReserveService;
import com.boot.project.service.TransactionService;

@RestController
public class ManagerController {

	@Autowired
	private ReserveService reserveService;

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private TransactionService transactionService;

	// reserve
	@PutMapping("/api/manager/reserve-update")
	public ResponseEntity<?> updateReserve(@RequestBody Reserve reserve) {
		Reserve existReserve = reserveService.findByEmail(reserve.getEmail());
		if (existReserve != null && !existReserve.getId().equals(reserve.getId())) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(reserveService.updateReserve(reserve), HttpStatus.CREATED);
	}

	// This can be also @DeleteMapping.
	@PostMapping("/api/manager/reserve-delete")
	public ResponseEntity<?> deleteReserve(@RequestBody Reserve reserve) {
		reserveService.deleteReserve(reserve.getId());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/api/manager/reservation-all")
	public Iterable<Reserve> showAllUsers() {
		return reserveService.showAllReservations();
	}

	@GetMapping("api/manager/delete/{email}")
	public Iterable<Reserve> deleteUser(@PathVariable String email) {
		return reserveService.deleteUserByEmail(email);
	}

	// inventory
	@PostMapping("/api/manager/inventory-create")
	public ResponseEntity<?> createInventory(@RequestBody Inventory inventory) {
		return new ResponseEntity<>(inventoryService.saveInventory(inventory), HttpStatus.CREATED);
	}

	@PutMapping("/api/manager/inventory-update")
	public ResponseEntity<?> updateInventory(@RequestBody Inventory inventory) {
		return new ResponseEntity<>(inventoryService.updateInventory(inventory), HttpStatus.CREATED);
	}

	// This can be also @DeleteMapping.

	@PostMapping("/api/manager/inventory-delete")
	public ResponseEntity<?> deleteInventory(@RequestBody Inventory inventory) {
		inventoryService.deleteInventory(inventory.getId());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/api/manager/inventory-all")
	public ResponseEntity<?> findAllInventories() {
		return new ResponseEntity<>(inventoryService.findAllInventories(), HttpStatus.OK);
	}

	@GetMapping("/api/manager/inventory-number")
	public ResponseEntity<?> numberOfInventorys() {
		Long number = inventoryService.numberOfInventories();
		StringResponse response = new StringResponse();
		response.setResponse(number.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// product
	@PostMapping("/api/manager/product-create")
	public ResponseEntity<?> createProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
	}
//    @GetMapping("api/admin/delete/{email}")
//	public Iterable<Reserve> deleteReserve(@PathVariable String email){
//		return reserveService.deleteUserByEmail(email);
//	}

	@PutMapping("/api/manager/product-update")
	public ResponseEntity<?> updateProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.CREATED);
	}

	// This can be also @DeleteMapping.
	@PostMapping("/api/manager/product-delete")
	public ResponseEntity<?> deleteProduct(@RequestBody Product product) {
		productService.deleteProduct(product.getId());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/api/manager/product-all")
	public ResponseEntity<?> findAllProducts() {
		return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/api/manager/product-number")
	public ResponseEntity<?> numberOfProducts() {
		Long number = productService.numberOfProducts();
		StringResponse response = new StringResponse();
		response.setResponse(number.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// transaction
	@GetMapping("/api/manager/transaction-all")
	public ResponseEntity<?> findAllTransactions() {
		return new ResponseEntity<>(transactionService.findAllTransactions(), HttpStatus.OK);
	}

	@GetMapping("api/manager/transaction-number")
	public ResponseEntity<?> numberOfTransactions() {
		Long number = transactionService.numberOfTransactions();
		StringResponse response = new StringResponse();
		response.setResponse(number.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
