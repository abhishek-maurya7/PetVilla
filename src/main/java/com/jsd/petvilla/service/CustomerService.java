package com.jsd.petvilla.service;

import com.jsd.petvilla.entity.Customer;

//Service interface to perform CRUD operations related to the Customer Entity
public interface CustomerService {
	
	/*
	 * Register new customer in the database
	 * Returns a registered Customer
	 */
	Customer registerCustomer(Customer customer);
	
	/*
	 * Edit existing customer details by ID
	 * Returns customer after editing it
	 */
	Customer editCustomer(Customer customer, int cId);
	
	/*
	 * Delete existing customer by ID 
	 */
	void deleteCustomer(int cId);
	
	/*
	 * Fetch details of customer based on ID
	 * Return the fetched customer 
	 */
	Customer fetchCustomer(int cId);
	
	/**
	 * @param username
	 * @return Customer object
	 */
	Customer fetchByUsername(String username);
}
