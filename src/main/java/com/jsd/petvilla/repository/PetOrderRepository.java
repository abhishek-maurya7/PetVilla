package com.jsd.petvilla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsd.petvilla.entity.PetOrders;

/*
 * Interface repository to manage CRUD operations related to PetOrder entity
 * Inherits methods of JpaRepository
 */
public interface PetOrderRepository extends JpaRepository<PetOrders, Integer> {
	/*
	 * Method to fetch Pet Orders for specific customer based on customer ID
	 * Returns multiple Pet Orders in a list
	 */
	@Query("Select po from PetOrders po where po.customerId = ?1")
	List<PetOrders> findByCustomerId(int cId);
	
	/*
	 * Method to fetch Pet Orders for specific customer based on status
	 * Returns multiple Pet Orders in a list
	 */
	@Query("Select po from PetOrders po where po.status = ?1")
	List<PetOrders> findByStatus(String status);
}