package com.jsd.petvilla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsd.petvilla.entity.Payments;

/*
 * Interface repository to manage CRUD operations related to Payment entity
 * Inherits methods of JpaRepository
 */
public interface PaymentsRepository extends JpaRepository<Payments, Integer> {
	/*
	 * Method to fetch payments based on customer ID
	 * Return mulitple payments in a List
	 */
	List<Payments> findByCustomerId(int CustomerId);
}
