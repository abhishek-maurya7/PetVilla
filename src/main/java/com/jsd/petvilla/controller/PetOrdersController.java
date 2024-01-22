package com.jsd.petvilla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jsd.petvilla.entity.Customer;
import com.jsd.petvilla.entity.PetOrders;
import com.jsd.petvilla.service.CustomerService;
import com.jsd.petvilla.service.PetOrdersService;

@RestController
public class PetOrdersController {

    @Autowired
    private PetOrdersService petOrdersService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/fetchOrder/{petOrderId}")
    public ResponseEntity<PetOrders> fetchOrderById(@PathVariable("petOrderId") int petOrderId) {
        return new ResponseEntity<>(petOrdersService.fetchPetOrderById(petOrderId), HttpStatus.OK);
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<PetOrders> placeOrder(@RequestBody PetOrders newPetOrder) {
        // Ensure the customer is saved before creating the PetOrders
        Customer customer = newPetOrder.getCustomer();
        Customer savedCustomer = customerService.registerCustomer(customer);

        // Set the saved customer in the PetOrders entity
        newPetOrder.setCustomer(savedCustomer);

        // Create the PetOrders entity
        PetOrders createdPetOrder = petOrdersService.createPetOrder(newPetOrder);

        return new ResponseEntity<>(createdPetOrder, HttpStatus.CREATED);
    }
}
