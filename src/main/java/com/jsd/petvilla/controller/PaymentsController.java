package com.jsd.petvilla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsd.petvilla.entity.Payments;
import com.jsd.petvilla.service.PaymentsService;

@RestController
public class PaymentsController {
	
	@Autowired
	PaymentsService paymentsService;
	
	/*
	 * endpoint to save payment information
	 * @return ResponseEntity containing saved Payment object, HttpStatus CREATED if successful
	 */
	@PostMapping("/makePayment")
	public ResponseEntity<Payments> makePayment(@RequestBody Payments newPayment) {
		return new ResponseEntity<Payments>(paymentsService.savePayment(newPayment), HttpStatus.CREATED);
	}
	
	/*
	 * endpoint to payment payment information
	 * @return ResponseEntity containing Payment object, HttpStatus OK if successful
	 */
	@GetMapping("/showPaymentByCId/{customerId}")
	public ResponseEntity<List<Payments>> showPaymentByCId(@PathVariable("customerId") int customerId) {
		return new ResponseEntity<List<Payments>>(paymentsService.fetchPaymentByCId(customerId), HttpStatus.OK);
	}
}
