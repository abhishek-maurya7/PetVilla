package com.jsd.petvilla.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsd.petvilla.entity.Customer;
import com.jsd.petvilla.exception.CustomerIDNotFoundException;
import com.jsd.petvilla.repository.CustomerRepository;
import com.jsd.petvilla.service.CustomerService;

//Implementation of abstract methods of CustomerService interface
//Handles CRUD operation for Customer entity
@Service
public class CustomerServiceImpl implements CustomerService {

	/*
	 * Injecting the CustomerRepository using Autowired
	 */
	@Autowired
	CustomerRepository custRepo;
	
	/*
	 * Method to register new customer
	 * Using .save() method of JpaRepository
	 */
	@Override
	public Customer registerCustomer(Customer customer) {
		return custRepo.save(customer);
	}

	/*
	 * Method to Update customer information based on ID
	 */
	@Override
	public Customer editCustomer(Customer customer, int cId) {
		Customer updatedCustomerDetails = custRepo.findById(cId).orElseThrow(()-> new CustomerIDNotFoundException("Customer ID does not exists."));
		updatedCustomerDetails.setCPhone(customer.getCPhone());
		updatedCustomerDetails.setCAddress(customer.getCAddress());
		updatedCustomerDetails.setCEmail(customer.getCEmail());
		custRepo.save(updatedCustomerDetails);
		return updatedCustomerDetails;
	}

	/*
	 * Method to delete customer from the system
	 * Using .delete method of JpaRepository
	 */
	@Override
	public void deleteCustomer(int cId) {
		custRepo.findById(cId).orElseThrow(() -> new CustomerIDNotFoundException("Customer ID does not exists"));
		custRepo.deleteById(cId);
	}

	/*
	 * Method to fetch customer details using ID
	 * Using .findById() of JpaRepository
	 */
	@Override
	public Customer fetchCustomer(int cId) {
		return custRepo.findById(cId).orElseThrow(()-> new CustomerIDNotFoundException("Customer ID does not exists."));
	}

	/**
	 * method to fetch user by username
	 * using fetchByUsername() of JpaRepository
	 */
	@Override
	public Customer fetchByUsername(String username) {
		return custRepo.fetchByUsername(username);
	}

}
