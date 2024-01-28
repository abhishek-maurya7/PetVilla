package com.jsd.petvilla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsd.petvilla.entity.ProductOrders;

/*
 * Interface repository to manage CRUD operations related to ProductOrder entity
 * Inherits methods of JpaRepository
 */
public interface ProductOrdersRepository extends JpaRepository<ProductOrders, Integer>{
	
	/*
	 * Custom method to fetch Product Orders based on customer ID
	 * Returns list of orders
	 */
//	@Query("Select productOrders from ProductOrders productOrders where productOrders.customerId = ?1")
//	List<ProductOrders> findByCustomerId(int cId); 
	
	/*
	 * Custom method to fetch Product Orders based on status
	 * Returns list of orders 
	 */
	@Query("Select productOrders from ProductOrders productOrders where productOrders.status = ?1")
	List<ProductOrders> findByStatus(String status);
}