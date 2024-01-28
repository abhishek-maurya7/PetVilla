package com.jsd.petvilla.service;

import java.util.List;

import com.jsd.petvilla.entity.Payments;

public interface PaymentsService {
	/*
	 * save payment information 
	 * @return saved payment object
	 */
	public Payments savePayment(Payments payment);
	
	
	/*
	 * fetching payments based on customer ID
	 * @return List of Payments objects 
	 */
	public List<Payments> fetchPaymentByCId(int customerId);
	
}
