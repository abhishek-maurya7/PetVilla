package com.jsd.petvilla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.jsd.petvilla.entity.PetOrders;

import com.jsd.petvilla.service.PetOrdersService;

@RestController
public class PetOrdersController {

    @Autowired
    private PetOrdersService petOrdersService;

    /*
     * endpoint to fetch Order details by ID
     * @return REsponseEntity containing PetOrders object, HttpStatus OK if successful
     */
    @GetMapping("/fetchOrder/{petOrderId}")
    public ResponseEntity<PetOrders> fetchOrderById(@PathVariable("petOrderId") int petOrderId) {
        return new ResponseEntity<PetOrders>(petOrdersService.displayPetOrderById(petOrderId), HttpStatus.OK);
    }

    /*
	 * endpoint to save orders 
	 * @return ResponseEntity containing saved of PetOrders object, HttpStatus CREATED if successful
	 */
    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestBody PetOrders newPetOrder) {
        petOrdersService.createPetOrder(newPetOrder);
        return new ResponseEntity<String>("Added to cart", HttpStatus.CREATED);
    }
    /*
	 * endpoint to cancel the orders
	 * @return ResponseEntity containing PetOrders object, HttpStatus OK if successful
	 */
    @PatchMapping("/cancelOrder/{petOrderId}")
    public ResponseEntity<PetOrders> cancelOrder(@RequestBody PetOrders petOrder, @PathVariable("petOrderId") int petOrderId) {
    	return new ResponseEntity<PetOrders>(petOrdersService.cancelPetOrder(petOrder, petOrderId), HttpStatus.OK);
    }
}
