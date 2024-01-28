package com.jsd.petvilla.repository;

import com.jsd.petvilla.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
 * Interface repository to manage CRUD operations related to Payments entity
 * Inherits methods of JpaRepository
 */
public interface PaymentsRepository extends JpaRepository<Payments, Integer> {
	
	/*
	 * Method to fetch payment information by customer ID
	 * @return List of payments object
	 */
    @Query("SELECT payment FROM Payments payment WHERE payment.pCustomer.cId = :customerId")
    List<Payments> findByCId(int customerId);
}

