package com.jsd.petvilla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsd.petvilla.entity.ProductOrders;
import com.jsd.petvilla.repository.ProductOrdersRepository;
import com.jsd.petvilla.service.ProductOrdersService;

// REst controller to handle incoming requests related to the ProductOrders entity
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ProductOrdersController {

	@Autowired
	ProductOrdersService productOrdersService;
	
	/*
	 * endpoint to fetch product order information by ID
	 * @return ResponseEntity containing ProductOrders object, HttpStatus OK if successful
	 */
	@GetMapping("/fetchProductOrder/{productOrderId}")
	public ResponseEntity<ProductOrders> fetchProductOrderById(@PathVariable("productOrderId") int productOrderId) {
		return new ResponseEntity<ProductOrders>(productOrdersService.fetchProductOrderById(productOrderId), HttpStatus.OK);
	}
	
	/**
	 * endpoint to save orders 
	 * @return ResponseEntity containing string, HttpStatus CREATED if successful
	 */
    @PostMapping("/placeProductOrder")
    public ResponseEntity<String> placeProductOrder(@RequestBody List<ProductOrders> newProductOrder) {
        productOrdersService.createProductOrder(newProductOrder);
        return new ResponseEntity<String>("Added to cart", HttpStatus.CREATED);
    }
    /**
	 * endpoint to cancel the orders of the product by ID
	 * @return ResponseEntity containing ProductOrders object, HttpStatus OK if successful
	 */
    @PatchMapping("/cancelProductOrder/{productOrderId}")
    public ResponseEntity<ProductOrders> cancelProductOrder(@RequestBody ProductOrders productOrder, @PathVariable("productOrderId") int productOrderId) {
    	return new ResponseEntity<ProductOrders>(productOrdersService.cancelProductOrder(productOrder, productOrderId), HttpStatus.CREATED);
    }
}
