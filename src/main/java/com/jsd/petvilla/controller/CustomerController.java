package com.jsd.petvilla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsd.petvilla.entity.Customer;
import com.jsd.petvilla.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	//Injecting CustomerService using Autowired
	@Autowired
	CustomerService cs;
	
	/*
	 * Mapping ro handle
	 */
	@PostMapping("/register")
	public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(cs.registerCustomer(customer), HttpStatus.CREATED);
	}
	
	@GetMapping("/customer/{cId}")
	public ResponseEntity<Customer> findCustomer(@PathVariable("cId") int cId) {
		return new ResponseEntity<Customer>(cs.fetchCustomer(cId), HttpStatus.OK);
	}
	
	@PatchMapping("editCustomer/{cId}")
	public ResponseEntity<Customer> editCustomer(@RequestBody Customer customer ,@PathVariable("cId") int cId) {
		return new ResponseEntity<Customer>(cs.editCustomer(customer, cId), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomer/{cId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("cId") int cId) {
		cs.deleteCustomer(cId);
		return new ResponseEntity<String>("Customer has been deleted 😿.", HttpStatus.OK);
	}
}
