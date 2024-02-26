package com.jsd.petvilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsd.petvilla.entity.Customer;

/*
 * Interface repository to manage CRUD operations related to Customer entity
 * Inherits methods of JpaRepository
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	/*
	 * Method to fetch Pets based on username
	 * Returns single customer 
	 */
	@Query("Select customer from Customer customer where customer.username = ?1")
	Customer fetchByUsername(String username);
}