package com.jsd.petvilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsd.petvilla.entity.PetOrders;

/*
 * Interface repository to manage CRUD operations related to PetOrder entity
 * Inherits methods of JpaRepository
 */
public interface PetOrdersRepository extends JpaRepository<PetOrders, Integer> {
	
}